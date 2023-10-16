package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {
    Button DangKy;
    private FirebaseFirestore db;
    ImageButton img;
    private String hoten, sodienthoai, email, ngaythangnam, hochieu, matkhau, nhaplaimatkhau, uid;
    EditText edHoTen, edSoDienThoai, edEmail, edNgayThangNam, edHoChieu, edMatKhau, edNhaplaiMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        img = findViewById(R.id.account12);
        DangKy = findViewById(R.id.DangKy);
        anhxadulieu();
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        Bundle bundle = getIntent().getExtras();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, ChinhActivity.class);
                startActivity(i);
            }
        });
        DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten1=edHoTen.getText().toString();
                String email1=edEmail.getText().toString();
                String hochieu1=edHoChieu.getText().toString();
                String matkhau1=edMatKhau.getText().toString();
                String nhaplaimatkhau1=edNhaplaiMatKhau.getText().toString();
                String sodienthoai1=edSoDienThoai.getText().toString();
                String ngaythangnam1=edNgayThangNam.getText().toString();
                String tien="0";
                Bundle bundle1=getIntent().getExtras();
                if(bundle1!=null)
                {
                    String id=uid;
                    User user=new User(id,hoten1,hochieu1,sodienthoai1,nhaplaimatkhau1,ngaythangnam1,email1,tien);
                }else {
                    String id = UUID.randomUUID().toString(); // random id
                    User user=new User(id,hoten1,hochieu1,sodienthoai1,nhaplaimatkhau1,ngaythangnam1,email1,tien);
                    initListener();
                    saveToFireStore(user);
                }


            }
        });
    }

    void anhxadulieu() {
        edHoTen = findViewById(R.id.edHoTen);
        edEmail = findViewById(R.id.edEmail);
        edHoChieu = findViewById(R.id.HoChieu);
        edMatKhau = findViewById(R.id.Matkhau);
        edSoDienThoai = findViewById(R.id.edSodienthoai);
        edNhaplaiMatKhau = findViewById(R.id.Nhaplaimatkhau);
        edNgayThangNam = findViewById(R.id.edNgayThangNam);

    }
    private void initListener(){
        String Email=edEmail.getText().toString().trim();
        String Password=edMatKhau.getText().toString().trim();
        FirebaseAuth auth= FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Thành Công", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(i);
                            finishAffinity();
                        }

                    }
                });
    }
    private void saveToFireStore(User user){
        if(!user.hoten.isEmpty() && !user.email.isEmpty()&&!user.hochieu.isEmpty()&& !user.ngaythangnam.isEmpty()&&!user.sodienthoai.isEmpty()&&!user.nhapmatkhau.isEmpty()){
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",user.id);
            map.put("hoten",user.hoten);
            map.put("email",user.email);
            map.put("hochieu",user.hochieu);
            map.put("ngaythangnam",user.ngaythangnam);
            map.put("sodienthoai",user.sodienthoai);
            map.put("nhapmatkhau",user.nhapmatkhau);
            map.put("tien","0");
            db.collection("Documents").document(user.id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(RegisterActivity.this,ThongBaoThanhCongNapTienActivity.class);
                                startActivity(i);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivity.this, "Lưu thất bại ", Toast.LENGTH_SHORT).show();
                        }
                    });



        }
        else{
            Toast.makeText(this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
        }
    }




}

