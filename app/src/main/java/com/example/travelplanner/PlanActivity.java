package com.example.travelplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;


public class PlanActivity extends AppCompatActivity {

    PlanFragment planFragment;
    AlbumFragment albumFragment;
    WalletFragment walletFragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 뒤로가기 버튼 처리
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceSTate) {
        super.onCreate(savedInstanceSTate);
        setContentView(R.layout.activity_schedule);

        //MainActivity에 있는 num, title[] 변수들 intent
        Intent intent = getIntent();
        int num = getIntent().getIntExtra("Num", 0);
        String[] title = getIntent().getStringArrayExtra("plan_title");

        //actionbar제목 설정
        getSupportActionBar().setTitle(title[1]);

        // 액션바에 뒤로가기 버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        planFragment = new PlanFragment();
        albumFragment = new AlbumFragment();
        walletFragment = new WalletFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, planFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.TabPlan:
                        Bundle bundle = new Bundle();
                        bundle.putInt("Num", num);
                        bundle.putStringArray("plan_title", title);
                        planFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, planFragment).commit();
                        return true;

                    case R.id.TabAlbum:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, albumFragment).commit();
                        return true;

                    case R.id.TabWallet:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, walletFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}






