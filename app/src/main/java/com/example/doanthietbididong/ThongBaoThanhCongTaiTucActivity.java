package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThongBaoThanhCongTaiTucActivity extends AppCompatActivity {
Button tieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao_thanh_cong_tai_tuc);
        tieptuc = findViewById(R.id.tieptucmotktk);
        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongBaoThanhCongTaiTucActivity.this,KhiChonKhongCamOnActivity.class);
                startActivity(i);
            }
        });
    }
}