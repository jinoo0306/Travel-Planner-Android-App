package com.example.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AlbumFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;

    private Button btnChooseImage;
    private ImageView imageView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_album, container, false);

        btnChooseImage = rootView.findViewById(R.id.selectImageButton);
        imageView = rootView.findViewById(R.id.albumImageView);

        btnChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        });

        return rootView;
    }

    private void openImageChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            // 이미지를 앱 내부 저장소로 복사
            copyImageToAppStorage(imageUri);
        }
    }

    private void copyImageToAppStorage(Uri imageUri) {
        try {
            // 이미지 파일의 원본 경로 가져오기
            String imagePath = getImagePath(imageUri);

            // 이미지 파일을 앱 내부 저장소로 복사
            File destinationFile = getDestinationFile();
            copyFile(new File(imagePath), destinationFile);

            // 이미지가 성공적으로 저장되었음을 알림
            Toast.makeText(getActivity(), "Image saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            // 이미지 저장 중에 오류 발생한 경우에 대한 예외 처리
            Toast.makeText(getActivity(), "Failed to save image", Toast.LENGTH_SHORT).show();
        }
    }

    private String getImagePath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String imagePath = cursor.getString(columnIndex);
            cursor.close();
            return imagePath;
        }
        return null;
    }

    private File getDestinationFile() {
        File directory = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String fileName = "image.jpg";
        return new File(directory, fileName);
    }

    private void copyFile(File sourceFile, File destinationFile) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
