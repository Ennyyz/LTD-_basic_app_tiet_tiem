package com.example.doanthietbididong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GiaiThichThuatNguActivity extends AppCompatActivity {
ImageButton img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_thich_thuat_ngu);
        img=findViewById(R.id.account12);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GiaiThichThuatNguActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}