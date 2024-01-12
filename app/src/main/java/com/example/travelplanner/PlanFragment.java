package com.example.travelplanner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PlanFragment extends Fragment {

    EditText editplan;
    String fileName;
    Button saveBtn;
    int num;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_plan, container, false);
        // Fragment에서 사용할 뷰들을 rootView에서 찾아서 초기화 및 설정합니다.
        editplan = rootView.findViewById(R.id.EditPlan);
        saveBtn = rootView.findViewById(R.id.SaveBtn);

        // 인수 가져오기
        Bundle bundle = getArguments();
        if (bundle != null) {
            num = bundle.getInt("Num", 0);
            String[] title = bundle.getStringArray("plan_title");
        }

        fileName = Integer.toString(num)+"번째 일정.txt";
        String str = readDiary(fileName);
        editplan.setText(str);
        saveBtn.setEnabled(true);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editplan.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getActivity().getApplicationContext(),"저장 완료!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return rootView;
    }

    private String readDiary(String fileName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = getActivity().openFileInput(fileName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diaryStr;
    }
}
