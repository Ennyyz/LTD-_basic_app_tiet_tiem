package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class ChinhActivity extends AppCompatActivity {
ImageButton Button1, btnTktk, btnAdd,btnMinus,minusNotlogin1;
Button btn1, btn2, btn3,btn4,btnn1,btnn2,btnn3,btnn4,bell1;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh);
        btnn1=findViewById(R.id.btnn1);
        btnn2=findViewById(R.id.btnn2);
        btnn3=findViewById(R.id.btnn3);
        btnn4=findViewById(R.id.btnn4);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        bell1=findViewById(R.id.bell1);
        Button1=findViewById(R.id.account12);
        login=findViewById(R.id.login);
        btnTktk=findViewById(R.id.tktkNotlogin);
        minusNotlogin1=findViewById(R.id.minusNotlogin1);
        btnAdd = findViewById(R.id.addNotlogin);
        btnMinus = findViewById(R.id.minusNotlogin);
        bell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
        btnn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
        btnn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
        minusNotlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent i =new Intent(ChinhActivity.this, ChuaDangNhapGiaiThichThuatNguActivity.class);
            startActivity(i);
         }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this, ChuaDangNhapHuongDanSuDungActivity.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,ChuaDangNhapCachThucTinhLaiActivity.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this, ChuaDangNhapThongTinChungActivity.class);
                startActivity(i);
            }
        });
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChinhActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        btnTktk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                startActivity(i);
            }
        });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                        startActivity(i);
                    }
                });
                btnMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(ChinhActivity.this,LoiActivity.class);
                        startActivity(i);
                    }
                });
    }

}
