package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BangLaiSuat1Activity extends AppCompatActivity {
ImageButton account12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_lai_suat1);
        account12=findViewById(R.id.account12);
        account12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(BangLaiSuat1Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}