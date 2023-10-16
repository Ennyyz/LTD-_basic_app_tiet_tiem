package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChuaDangNhapThongTinChungActivity extends AppCompatActivity {
    ImageButton quayve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chua_dang_nhap_thong_tin_chung);
        quayve = findViewById(R.id.account12);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChuaDangNhapThongTinChungActivity.this,ChinhActivity.class);
                startActivity(i);
            }
        });
    }
}