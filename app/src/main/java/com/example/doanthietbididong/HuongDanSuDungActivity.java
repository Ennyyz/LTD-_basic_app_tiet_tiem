package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HuongDanSuDungActivity extends AppCompatActivity {
    ImageButton quayve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan_su_dung);
        quayve = findViewById(R.id.account12);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HuongDanSuDungActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}