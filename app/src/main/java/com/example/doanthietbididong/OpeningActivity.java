package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class OpeningActivity extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(OpeningActivity.this, ChinhActivity.class);
                startActivity(i);
            }
        }, 1500);//3000 = 3s, nếu muốn đổi thành 2s thì thay thành 2000, 1s thì 1000
    }
}


