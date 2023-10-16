package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class QuenMatKhauActivity extends AppCompatActivity {

    EditText email, matkhaumoi,nhaplaimatkhaumoi;
    Button xacnhan;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    ImageButton quayve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);
        email = findViewById(R.id.edEmailquenmatkhau);
        xacnhan = findViewById(R.id.xacnhanquenmatkhau);
        quayve = findViewById(R.id.account12);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuenMatKhauActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quenmatkhau();
            }
        });
    }
    private void Quenmatkhau() {
        String email1 = email.getText().toString().trim();
        if(TextUtils.isEmpty(email1) && !Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            Toast.makeText(this, "vui lòng nhập email", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.sendPasswordResetEmail(email1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(QuenMatKhauActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(QuenMatKhauActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(QuenMatKhauActivity.this, "Đổi mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}