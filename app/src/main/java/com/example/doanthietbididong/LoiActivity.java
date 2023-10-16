package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoiActivity extends AppCompatActivity {
Button loiQuaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loi);
        loiQuaylai = findViewById(R.id.backUp);
        loiQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoiActivity.this,ChinhActivity.class);
                startActivity(i);
            }
        });
    }
}