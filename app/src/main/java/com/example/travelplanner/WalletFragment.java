package com.example.travelplanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WalletFragment extends Fragment {

    private final String route = Environment.getExternalStorageDirectory().getAbsolutePath();
    private final File mydir = new File(route + "/mydir");
    private int num;
    private String[][] expend;
    private LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10, layout11, layout12, layout13, layout14, layout15;
    private TextView edtinfo1, edtinfo2, edtinfo3, edtinfo4, edtinfo5, edtinfo6, edtinfo7, edtinfo8, edtinfo9, edtinfo10, edtinfo11, edtinfo12, edtinfo13, edtinfo14, edtinfo15;
    private TextView edtpri1, edtpri2, edtpri3, edtpri4, edtpri5, edtpri6, edtpri7, edtpri8, edtpri9, edtpri10, edtpri11, edtpri12, edtpri13, edtpri14, edtpri15;
    private Button btnPlus, btnMinus;
    private EditText edtinfo, edtpri;
    private View dialogview;

    private void readTitleFromFile() {
        String road_path = route + "/mydir/wallet.txt";
        try {
            FileInputStream inputS = new FileInputStream(road_path);
            byte[] txt = new byte[inputS.available()];
            inputS.read(txt);

            String test = new String(txt);
            String rows[] = test.split("!");
            expend = new String[rows.length][];
            int r = 0;
            for (String row : rows) {
                expend[r++] = row.split("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wallet, container, false);
        // Fragment에서 사용할 뷰들을 rootView에서 찾아서 초기화 및 설정합니다.
        Bundle bundle = getArguments();
        if (bundle != null) {
            int num = bundle.getInt("Num", 0);
            String[] title = bundle.getStringArray("plan_title");
        }

        readTitleFromFile();


        {
            layout1 = rootView.findViewById(R.id.ExpLay1);
            layout2 = rootView.findViewById(R.id.ExpLay2);
            layout3 = rootView.findViewById(R.id.ExpLay3);
            layout4 = rootView.findViewById(R.id.ExpLay4);
            layout5 = rootView.findViewById(R.id.ExpLay5);
            layout6 = rootView.findViewById(R.id.ExpLay6);
            layout7 = rootView.findViewById(R.id.ExpLay7);
            layout8 = rootView.findViewById(R.id.ExpLay8);
            layout9 = rootView.findViewById(R.id.ExpLay9);
            layout10 = rootView.findViewById(R.id.ExpLay10);
            layout11 = rootView.findViewById(R.id.ExpLay11);
            layout12 = rootView.findViewById(R.id.ExpLay12);
            layout13 = rootView.findViewById(R.id.ExpLay13);
            layout14 = rootView.findViewById(R.id.ExpLay14);
            layout15 = rootView.findViewById(R.id.ExpLay15);

            edtinfo1 = rootView.findViewById(R.id.ExpInfo1);
            edtinfo2 = rootView.findViewById(R.id.ExpInfo2);
            edtinfo3 = rootView.findViewById(R.id.ExpInfo3);
            edtinfo4 = rootView.findViewById(R.id.ExpInfo4);
            edtinfo5 = rootView.findViewById(R.id.ExpInfo5);
            edtinfo6 = rootView.findViewById(R.id.ExpInfo6);
            edtinfo7 = rootView.findViewById(R.id.ExpInfo7);
            edtinfo8 = rootView.findViewById(R.id.ExpInfo8);
            edtinfo9 = rootView.findViewById(R.id.ExpInfo9);
            edtinfo10 = rootView.findViewById(R.id.ExpInfo10);
            edtinfo11 = rootView.findViewById(R.id.ExpInfo11);
            edtinfo12 = rootView.findViewById(R.id.ExpInfo12);
            edtinfo13 = rootView.findViewById(R.id.ExpInfo13);
            edtinfo14 = rootView.findViewById(R.id.ExpInfo14);
            edtinfo15 = rootView.findViewById(R.id.ExpInfo15);

            edtpri1 = rootView.findViewById(R.id.ExpPri1);
            edtpri2 = rootView.findViewById(R.id.ExpPri2);
            edtpri3 = rootView.findViewById(R.id.ExpPri3);
            edtpri4 = rootView.findViewById(R.id.ExpPri4);
            edtpri5 = rootView.findViewById(R.id.ExpPri5);
            edtpri6 = rootView.findViewById(R.id.ExpPri6);
            edtpri7 = rootView.findViewById(R.id.ExpPri7);
            edtpri8 = rootView.findViewById(R.id.ExpPri8);
            edtpri9 = rootView.findViewById(R.id.ExpPri9);
            edtpri10 = rootView.findViewById(R.id.ExpPri10);
            edtpri11 = rootView.findViewById(R.id.ExpPri11);
            edtpri12 = rootView.findViewById(R.id.ExpPri12);
            edtpri13 = rootView.findViewById(R.id.ExpPri13);
            edtpri14 = rootView.findViewById(R.id.ExpPri14);
            edtpri15 = rootView.findViewById(R.id.ExpPri15);

            btnPlus = rootView.findViewById(R.id.WalletPlus);
            btnMinus = rootView.findViewById(R.id.WalletMinus);

        }

        switch(expend.length)
        {
            case 15:
                layout15.setVisibility(View.VISIBLE);
                edtinfo15.setText(expend[14][0]);
                edtpri15.setText(expend[14][1]);
            case 14:
                layout14.setVisibility(View.VISIBLE);
                edtinfo14.setText(expend[13][0]);
                edtpri14.setText(expend[13][1]);
            case 13:
                layout13.setVisibility(View.VISIBLE);
                edtinfo13.setText(expend[12][0]);
                edtpri13.setText(expend[12][1]);
            case 12:
                layout12.setVisibility(View.VISIBLE);
                edtinfo12.setText(expend[11][0]);
                edtpri12.setText(expend[11][1]);
            case 11:
                layout11.setVisibility(View.VISIBLE);
                edtinfo11.setText(expend[10][0]);
                edtpri11.setText(expend[10][1]);
            case 10:
                layout10.setVisibility(View.VISIBLE);
                edtinfo10.setText(expend[9][0]);
                edtpri10.setText(expend[9][1]);
            case 9:
                layout9.setVisibility(View.VISIBLE);
                edtinfo9.setText(expend[8][0]);
                edtpri9.setText(expend[8][1]);
            case 8:
                layout8.setVisibility(View.VISIBLE);
                edtinfo8.setText(expend[7][0]);
                edtpri8.setText(expend[7][1]);
            case 7:
                layout7.setVisibility(View.VISIBLE);
                edtinfo7.setText(expend[6][0]);
                edtpri7.setText(expend[6][1]);
            case 6:
                layout6.setVisibility(View.VISIBLE);
                edtinfo6.setText(expend[5][0]);
                edtpri6.setText(expend[5][1]);
            case 5:
                layout5.setVisibility(View.VISIBLE);
                edtinfo5.setText(expend[4][0]);
                edtpri5.setText(expend[4][1]);
            case 4:
                layout4.setVisibility(View.VISIBLE);
                edtinfo4.setText(expend[3][0]);
                edtpri4.setText(expend[3][1]);
            case 3:
                layout3.setVisibility(View.VISIBLE);
                edtinfo3.setText(expend[2][0]);
                edtpri3.setText(expend[2][1]);
            case 2:
                layout2.setVisibility(View.VISIBLE);
                edtinfo2.setText(expend[1][0]);
                edtpri2.setText(expend[1][1]);
            case 1:
                layout1.setVisibility(View.VISIBLE);
                edtinfo1.setText(expend[0][0]);
                edtpri1.setText(expend[0][1]);
            default:
        }

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogview = (View) View.inflate(getActivity(), R.layout.dialog_walletplus, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setView(dialogview);
                mydir.mkdir();
                // '확인' 버튼 클릭 리스너 설정
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int click) {
                        //edtinfo = rootView.findViewById(R.id.EnterInfo);

                    }
                });

            }
        });





        return rootView;
    }
}
