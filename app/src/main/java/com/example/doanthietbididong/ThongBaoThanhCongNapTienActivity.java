package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThongBaoThanhCongNapTienActivity extends AppCompatActivity {
Button continued;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao_thanh_cong_nap_tien);
        continued = findViewById(R.id.btntiepTuc);
        continued.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongBaoThanhCongNapTienActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}