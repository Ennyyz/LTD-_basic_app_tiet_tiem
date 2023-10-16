package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DoiMatKhauActivity extends AppCompatActivity {
    EditText email, matkhaucu, matkhaumoi, nhaplaimatkhau;
    Button Xacnhan;
    ImageButton account12;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        email = findViewById(R.id.edEmail);
        matkhaucu = findViewById(R.id.Matkhau1);
        matkhaumoi = findViewById(R.id.Matkhau);
        nhaplaimatkhau = findViewById(R.id.Nhaplaimatkhau);
        Xacnhan = findViewById(R.id.xacnhan);
        account12=findViewById(R.id.account12);
        /*db = FirebaseFirestore.getInstance();*/
account12.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(DoiMatKhauActivity.this,ThongTinCaNhanActivity.class);
        startActivity(i);
    }
});
        Xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matkhaucu1 = matkhaucu.getText().toString().trim();
                String matkhaumoi1 = matkhaumoi.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String nhaplaimatkhau1 = nhaplaimatkhau.getText().toString().trim();
                matkhaucu.setText(" ");
                matkhaumoi.setText(" ");
                email.setText(" ");
                Updatedata(matkhaumoi1);
            }
        });

    }
    private void Updatedata(String matkhaumoi1) {
        user.updatePassword(matkhaumoi1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(DoiMatKhauActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(DoiMatKhauActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(DoiMatKhauActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}