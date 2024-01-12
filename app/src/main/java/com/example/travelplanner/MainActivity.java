package com.example.travelplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private LinearLayout dateLo1, dateLo2, dateLo3, dateLo4, dateLo5, dateLo6, dateLo7, dateLo8, dateLo9;
    private EditText travel_destination;
    private DatePicker startdate, enddate;
    private View dialogview;
    private TextView dateTv1, dateTv2, dateTv3, dateTv4, dateTv5, dateTv6, dateTv7, dateTv8, dateTv9;
    private Button dateBtn1, dateBtn2, dateBtn3, dateBtn4, dateBtn5, dateBtn6, dateBtn7, dateBtn8, dateBtn9;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9;
    private String[][] title;
    private String[] recent_title;
    private int save_count = 0;
    private final String route = Environment.getExternalStorageDirectory().getAbsolutePath();
    private final File mydir = new File(route + "/mydir");
    //private final File title_txt = new File(route + "/mydir/title.txt");

    private void readTitleFromFile() {
        String road_path = route + "/mydir/title.txt";
        try {
            FileInputStream inputS = new FileInputStream(road_path);
            byte[] txt = new byte[inputS.available()];
            inputS.read(txt);

            String test = new String(txt);
            String rows[] = test.split("!");
            title = new String[rows.length][];
            int r = 0;
            for (String row : rows) {
                title[r++] = row.split("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("the Better Travel Start");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_APPEND);


        dateLo1 = (LinearLayout) findViewById(R.id.DateLayout1);
        dateLo2 = (LinearLayout) findViewById(R.id.DateLayout2);
        dateLo3 = (LinearLayout) findViewById(R.id.DateLayout3);
        dateLo4 = (LinearLayout) findViewById(R.id.DateLayout4);
        dateLo5 = (LinearLayout) findViewById(R.id.DateLayout5);
        dateLo6 = (LinearLayout) findViewById(R.id.DateLayout6);
        dateLo7 = (LinearLayout) findViewById(R.id.DateLayout7);
        dateLo8 = (LinearLayout) findViewById(R.id.DateLayout8);
        dateLo9 = (LinearLayout) findViewById(R.id.DateLayout9);

        dateTv1 = (TextView) findViewById(R.id.DateTv1);
        dateTv2 = (TextView) findViewById(R.id.DateTv2);
        dateTv3 = (TextView) findViewById(R.id.DateTv3);
        dateTv4 = (TextView) findViewById(R.id.DateTv4);
        dateTv5 = (TextView) findViewById(R.id.DateTv5);
        dateTv6 = (TextView) findViewById(R.id.DateTv6);
        dateTv7 = (TextView) findViewById(R.id.DateTv7);
        dateTv8 = (TextView) findViewById(R.id.DateTv8);
        dateTv9 = (TextView) findViewById(R.id.DateTv9);

        dateBtn1 = (Button) findViewById(R.id.DateBtn1);
        dateBtn2 = (Button) findViewById(R.id.DateBtn2);
        dateBtn3 = (Button) findViewById(R.id.DateBtn3);
        dateBtn4 = (Button) findViewById(R.id.DateBtn4);
        dateBtn5 = (Button) findViewById(R.id.DateBtn5);
        dateBtn6 = (Button) findViewById(R.id.DateBtn6);
        dateBtn7 = (Button) findViewById(R.id.DateBtn7);
        dateBtn8 = (Button) findViewById(R.id.DateBtn8);
        dateBtn9 = (Button) findViewById(R.id.DateBtn9);

        readTitleFromFile();

        //title.txt에 아무것도 없다면 save_count를 0으로, 저장된 무언가가 있다면 title.length로 초기화
        if (title == null) {
            save_count = 0;
        } else {
            save_count = title.length;
        }

        //기존에 저장한 데이터들을 다시 부름
        if (save_count != 0) {

            switch (save_count) {
                case 9: {
                    dateLo9.setVisibility(View.VISIBLE);
                    dateTv9.setText(title[8][1]);
                    dateBtn9.setText(title[8][2] + " ~ " + title[8][3]);
                }
                case 8: {
                    dateLo8.setVisibility(View.VISIBLE);
                    dateTv8.setText(title[7][1]);
                    dateBtn8.setText(title[7][2] + " ~ " + title[7][3]);
                }
                case 7: {
                    dateLo7.setVisibility(View.VISIBLE);
                    dateTv7.setText(title[6][1]);
                    dateBtn7.setText(title[6][2] + " ~ " + title[6][3]);
                }
                case 6: {
                    dateLo6.setVisibility(View.VISIBLE);
                    dateTv6.setText(title[5][1]);
                    dateBtn6.setText(title[5][2] + " ~ " + title[5][3]);
                }
                case 5: {
                    dateLo5.setVisibility(View.VISIBLE);
                    dateTv5.setText(title[4][1]);
                    dateBtn5.setText(title[4][2] + " ~ " + title[4][3]);
                }
                case 4: {
                    dateLo4.setVisibility(View.VISIBLE);
                    dateTv4.setText(title[3][1]);
                    dateBtn4.setText(title[3][2] + " ~ " + title[3][3]);
                }
                case 3: {
                    dateLo3.setVisibility(View.VISIBLE);
                    dateTv3.setText(title[2][1]);
                    dateBtn3.setText(title[2][2] + " ~ " + title[2][3]);
                }
                case 2: {
                    dateLo2.setVisibility(View.VISIBLE);
                    dateTv2.setText(title[1][1]);
                    dateBtn2.setText(title[1][2] + " ~ " + title[1][3]);
                }
                case 1: {
                    dateLo1.setVisibility(View.VISIBLE);
                    dateTv1.setText(title[0][1]);
                    dateBtn1.setText(title[0][2] + " ~ " + title[0][3]);
                }

            }
        }

        dateBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 0;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 1;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 2;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 3;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 4;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 5;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 6;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 7;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });

        dateBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readTitleFromFile();

                int num = 8;
                String[] plan_title = {title[num][0], title[num][1], title[num][2], title[num][3]};

                Intent intent = new Intent(MainActivity.this, PlanActivity.class);

                intent.putExtra("Num", num);
                intent.putExtra("plan_title", plan_title);
                startActivity(intent);
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch(item.getItemId()){
            case R.id.PlusMain:
            {
                dialogview = (View) View.inflate(MainActivity.this, R.layout.activity_title_enter, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogview);
                mydir.mkdir();
                // '확인' 버튼 클릭 리스너 설정
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int click) {

                        travel_destination = (EditText) dialogview.findViewById(R.id.Travel_Destination);
                        startdate = (DatePicker) dialogview.findViewById(R.id.StartDate);
                        enddate = (DatePicker) dialogview.findViewById(R.id.EndDate);

                        // 버튼 텍스트 설정
                        String destination = travel_destination.getText().toString();
                        String startDate = String.format("%d년 %d월 %d일", startdate.getYear(), startdate.getMonth() + 1, startdate.getDayOfMonth());
                        String endDate = String.format("%d년 %d월 %d일", enddate.getYear(), enddate.getMonth() + 1, enddate.getDayOfMonth());
                        String textviewText = String.format("%s", destination);
                        String buttonText = String.format("%s ~ %s", startDate, endDate);


                        if (startdate.getYear() > enddate.getYear()
                                || (startdate.getYear() == enddate.getYear() && startdate.getMonth() > enddate.getMonth())
                                || (startdate.getYear() == enddate.getYear() && startdate.getMonth() == enddate.getMonth() && startdate.getDayOfMonth() > enddate.getDayOfMonth())) {
                            Toast.makeText(getApplicationContext(), "시작 날짜는 종료 날짜보다 빨라야 합니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            if (destination.equals(""))
                                Toast.makeText(getApplicationContext(), "여행 제목을 입력해주세요!", Toast.LENGTH_SHORT).show();
                            else {
                                String s = "";

                                if (save_count == 0) {
                                    s = "";

                                } else {
                                    s = "!";
                                }

                                String recent_title[] = {s,
                                        destination,
                                        startdate.getYear() + "년 " + (startdate.getMonth() + 1) + "월 " + startdate.getDayOfMonth() + "일",
                                        enddate.getYear() + "년 " + (enddate.getMonth() + 1) + "월 " + enddate.getDayOfMonth() + "일"};

                                save_count++;


                                try {



                                    switch (save_count) {
                                        case 1: {
                                            dateLo1.setVisibility(View.VISIBLE);
                                            dateTv1.setText(recent_title[1]);
                                            dateBtn1.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 2: {
                                            dateLo2.setVisibility(View.VISIBLE);
                                            dateTv2.setText(recent_title[1]);
                                            dateBtn2.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 3: {
                                            dateLo3.setVisibility(View.VISIBLE);
                                            dateTv3.setText(recent_title[1]);
                                            dateBtn3.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 4: {
                                            dateLo4.setVisibility(View.VISIBLE);
                                            dateTv4.setText(recent_title[1]);
                                            dateBtn4.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 5: {
                                            dateLo5.setVisibility(View.VISIBLE);
                                            dateTv5.setText(recent_title[1]);
                                            dateBtn5.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 6: {
                                            dateLo6.setVisibility(View.VISIBLE);
                                            dateTv6.setText(recent_title[1]);
                                            dateBtn6.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 7: {
                                            dateLo7.setVisibility(View.VISIBLE);
                                            dateTv7.setText(recent_title[1]);
                                            dateBtn7.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 8: {
                                            dateLo8.setVisibility(View.VISIBLE);
                                            dateTv8.setText(recent_title[1]);
                                            dateBtn8.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }
                                        case 9: {
                                            dateLo9.setVisibility(View.VISIBLE);
                                            dateTv9.setText(recent_title[1]);
                                            dateBtn9.setText(recent_title[2] + " ~ " + recent_title[3]);
                                            break;
                                        }

                                    }


                                    BufferedWriter fos = new BufferedWriter(new FileWriter(route + "/mydir/title.txt", true));
                                    for (int i = 0; i < recent_title.length; i++) {
                                        fos.write(recent_title[i]);
                                        fos.write("\n");
                                    }


                                    fos.close();

                                } catch (IOException e) {
                                }
                            }

                            dialogInterface.dismiss(); // 확인 버튼 클릭 후 dialog 종료
                        }


                    }
                });


                // '닫기' 버튼 클릭 리스너 설정
                dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dialog 종료
                        dialogInterface.dismiss();
                    }
                });

                // AlertDialog 객체 생성 및 출력
                AlertDialog alertDialog = dlg.create();
                alertDialog.show();
                return true;
            }
            case R.id.ClearMain:
            {
                title = null;
                dateLo1.setVisibility(View.INVISIBLE);
                dateLo2.setVisibility(View.INVISIBLE);
                dateLo3.setVisibility(View.INVISIBLE);
                dateLo4.setVisibility(View.INVISIBLE);
                dateLo5.setVisibility(View.INVISIBLE);
                dateLo6.setVisibility(View.INVISIBLE);
                dateLo7.setVisibility(View.INVISIBLE);
                dateLo8.setVisibility(View.INVISIBLE);
                dateLo9.setVisibility(View.INVISIBLE);

                String filePath = route + "/mydir/title.txt";
                File file = new File(filePath);
                if (file.exists()) {
                    boolean deleted = file.delete();
                }



                return true;
            }
            case R.id.DeleteMain:
            {

                readTitleFromFile();
                String[][] bucket_title;
                bucket_title = title;

                dialogview = (View) View.inflate(MainActivity.this, R.layout.deletemenu_checkbox, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogview);
                dlg.setTitle("삭제할 일정을 선택해 주세요");
                // 다이얼로그 뷰에서 라디오 그룹을 찾아옵니다
                RadioGroup radioGroup = dialogview.findViewById(R.id.DltMenu_Rdo0);
                radioButton1 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo1);
                radioButton2 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo2);
                radioButton3 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo3);
                radioButton4 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo4);
                radioButton5 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo5);
                radioButton6 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo6);
                radioButton7 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo7);
                radioButton8 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo8);
                radioButton9 = (RadioButton) dialogview.findViewById(R.id.DltMenu_Rdo9);

                //save_count만큼 radiobutton이 보이게 하는 기능
                switch (save_count) {
                    case 9:
                        radioButton9.setText(title[8][1]);
                        radioButton9.setVisibility(View.VISIBLE);
                    case 8:
                        radioButton8.setText(title[7][1]);
                        radioButton8.setVisibility(View.VISIBLE);
                    case 7:
                        radioButton7.setText(title[6][1]);
                        radioButton7.setVisibility(View.VISIBLE);
                    case 6:
                        radioButton6.setText(title[5][1]);
                        radioButton6.setVisibility(View.VISIBLE);
                    case 5:
                        radioButton5.setText(title[4][1]);
                        radioButton5.setVisibility(View.VISIBLE);
                    case 4:
                        radioButton4.setText(title[3][1]);
                        radioButton4.setVisibility(View.VISIBLE);
                    case 3:
                        radioButton3.setText(title[2][1]);
                        radioButton3.setVisibility(View.VISIBLE);
                    case 2:
                        radioButton2.setText(title[1][1]);
                        radioButton2.setVisibility(View.VISIBLE);
                    case 1:
                        radioButton1.setText(title[0][1]);
                        radioButton1.setVisibility(View.VISIBLE);
                }


                //title.txt에 아무것도 없다면 save_count를 0으로, 저장된 무언가가 있다면 title.length로 초기화
                if (title == null) {
                    save_count = 0;
                } else {
                    save_count = title.length;
                }


                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int click) {
                        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                        int select;

                        switch (selectedRadioButtonId) {
                            case R.id.DltMenu_Rdo1:
                                select = 0;
                                break;
                            case R.id.DltMenu_Rdo2:
                                select = 1;
                                break;
                            case R.id.DltMenu_Rdo3:
                                select = 2;
                                break;
                            case R.id.DltMenu_Rdo4:
                                select = 3;
                                break;
                            case R.id.DltMenu_Rdo5:
                                select = 4;
                                break;
                            case R.id.DltMenu_Rdo6:
                                select = 5;
                                break;
                            case R.id.DltMenu_Rdo7:
                                select = 6;
                                break;
                            case R.id.DltMenu_Rdo8:
                                select = 7;
                                break;
                            case R.id.DltMenu_Rdo9:
                                select = 8;
                                break;
                            default:
                                select = -1;
                                break;
                        }

                        if(bucket_title.length>2) {
                            if (select >= 0 && select < bucket_title.length) {
                                // 배열의 유효한 인덱스 범위 내에서 삭제 수행
                                for (int i = select; i < bucket_title.length - 1; i++) {
                                    bucket_title[i] = bucket_title[i + 1];
                                }
                                bucket_title[bucket_title.length - 1] = null;
                                save_count--; // 일정이 삭제되었으므로 save_count 감소
                                for (int i = 1; i < bucket_title.length - 1; i++) {
                                    bucket_title[i][0] = "!";
                                }

                            }
                            else if (bucket_title.length == 2){
                                bucket_title[0] = bucket_title[1];
                                bucket_title[1] = null;
                            }
                            else if(bucket_title.length == 1)
                            {
                                bucket_title[0] = null;
                            }
                        }
                        title = bucket_title;

                        if (select == -1) {
                            Toast.makeText(getApplicationContext(), "삭제할 일정을 선택해주세요!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //title = bucket_title;
                            try {

                                BufferedWriter fos = new BufferedWriter(new FileWriter(route + "/mydir/title.txt", false));

                                // 파일에 쓰기 작업 수행


                                for (int i = 0; i < bucket_title.length; i++) {
                                    if (bucket_title[i] != null) {
                                        for (int j = 0; j < bucket_title[i].length; j++) {
                                            fos.write(bucket_title[i][j]);
                                            fos.write("\n");
                                        }
                                    }
                                }

                                fos.flush(); // 버퍼 비우기
                                fos.close(); // 파일 닫기
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (save_count != 0) {

                                dateLo1.setVisibility(View.INVISIBLE);
                                dateLo2.setVisibility(View.INVISIBLE);
                                dateLo3.setVisibility(View.INVISIBLE);
                                dateLo4.setVisibility(View.INVISIBLE);
                                dateLo5.setVisibility(View.INVISIBLE);
                                dateLo6.setVisibility(View.INVISIBLE);
                                dateLo7.setVisibility(View.INVISIBLE);
                                dateLo8.setVisibility(View.INVISIBLE);
                                dateLo9.setVisibility(View.INVISIBLE);
                                switch (save_count) {
                                    case 9: {

                                        //dateLo9.setVisibility(View.VISIBLE);
                                        dateTv9.setText(bucket_title[8][1]);
                                        dateBtn9.setText(bucket_title[8][2] + " ~ " + bucket_title[8][3]);
                                    }
                                    case 8: {
                                        //dateLo9.setVisibility(View.INVISIBLE);
                                        dateLo8.setVisibility(View.VISIBLE);
                                        dateTv8.setText(bucket_title[7][1]);
                                        dateBtn8.setText(bucket_title[7][2] + " ~ " + bucket_title[7][3]);
                                    }
                                    case 7: {
                                        //dateLo8.setVisibility(View.INVISIBLE);
                                        dateLo7.setVisibility(View.VISIBLE);
                                        dateTv7.setText(title[6][1]);
                                        dateBtn7.setText(bucket_title[6][2] + " ~ " + bucket_title[6][3]);
                                    }
                                    case 6: {
                                        //dateLo7.setVisibility(View.INVISIBLE);
                                        dateLo6.setVisibility(View.VISIBLE);
                                        dateTv6.setText(title[5][1]);
                                        dateBtn6.setText(bucket_title[5][2] + " ~ " + bucket_title[5][3]);
                                    }
                                    case 5: {
                                        //dateLo6.setVisibility(View.INVISIBLE);
                                        dateLo5.setVisibility(View.VISIBLE);
                                        dateTv5.setText(bucket_title[4][1]);
                                        dateBtn5.setText(bucket_title[4][2] + " ~ " + bucket_title[4][3]);
                                    }
                                    case 4: {
                                        dateLo5.setVisibility(View.INVISIBLE);
                                        dateLo4.setVisibility(View.VISIBLE);
                                        dateTv4.setText(bucket_title[3][1]);
                                        dateBtn4.setText(bucket_title[3][2] + " ~ " + bucket_title[3][3]);
                                    }
                                    case 3: {
                                        //dateLo4.setVisibility(View.INVISIBLE);
                                        dateLo3.setVisibility(View.VISIBLE);
                                        dateTv3.setText(bucket_title[2][1]);
                                        dateBtn3.setText(bucket_title[2][2] + " ~ " + bucket_title[2][3]);
                                    }
                                    case 2: {
                                        //dateLo3.setVisibility(View.INVISIBLE);
                                        dateLo2.setVisibility(View.VISIBLE);
                                        dateTv2.setText(bucket_title[1][1]);
                                        dateBtn2.setText(bucket_title[1][2] + " ~ " + bucket_title[1][3]);
                                    }
                                    case 1: {
                                        //dateLo2.setVisibility(View.INVISIBLE);
                                        dateLo1.setVisibility(View.VISIBLE);
                                        dateTv1.setText(bucket_title[0][1]);
                                        dateBtn1.setText(bucket_title[0][2] + " ~ " + bucket_title[0][3]);
                                    }

                                }
                            }
                        }

                        dialogInterface.dismiss(); // 확인 버튼 클릭 후 dialog 종료
                    }
                });

                dlg.setNegativeButton("닫기", null); // 취소 버튼 설정

                // AlertDialog 객체 생성 및 출력
                AlertDialog alertDialog = dlg.create();
                alertDialog.show();

                // 이벤트 처리가 완료되지 않았으므로 false 반환
                return false;
            }
        }
        return false;
    }
}