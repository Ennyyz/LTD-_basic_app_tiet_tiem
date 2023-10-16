package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BangLaiSuatActivity extends AppCompatActivity {
    ImageButton back;
    Button moTKTK, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_lai_suat);
        back = findViewById(R.id.account12);
        moTKTK = findViewById(R.id.moTktk);
        cancel = findViewById(R.id.cancel);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BangLaiSuatActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        moTKTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BangLaiSuatActivity.this,MoTaiKhoanTietKiemActivity.class);
                startActivity(i);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i = new Intent(BangLaiSuatActivity.this,MainActivity.class);
              startActivity(i);
            }
        });
    }
}