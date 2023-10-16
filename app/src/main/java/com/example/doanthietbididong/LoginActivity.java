package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText edUsernameC, edPasswordC;
    private FirebaseFirestore db;
    private List<User> list;
private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    Button btnLonginC,register,quenmatkhau;
    ImageButton account12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ánh xạ
        mAuth=FirebaseAuth.getInstance();
        quenmatkhau=findViewById(R.id.quenmatkhau);
        progressDialog=new ProgressDialog(this);
        account12=findViewById(R.id.account12);
        edUsernameC = findViewById(R.id.username); //username là id của layout bên xml
        edPasswordC = findViewById(R.id.password); //password cx thế
        btnLonginC = findViewById(R.id.loginbt); // login btn này cx z luôn
        register=findViewById(R.id.register1);
       quenmatkhau.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String username=edUsernameC.getText().toString().trim();
        onClickForgotPassword(username);
    }
});
        account12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,ChinhActivity.class);
                startActivity(i);
            }
        });
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i= new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(i);
           }
       });
btnLonginC.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        login();
    }
});

    }
    private  void login(){
        String email,pass;
        email=edUsernameC.getText().toString();
        pass=edPasswordC.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Vui lòng nhập pass", Toast.LENGTH_SHORT).show();
            return;
        }
mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
        }
        else {
            Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
        }
    }
});
    }
    private void onClickForgotPassword(String username){
        progressDialog.show();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String emailaddress=user.getEmail().toString().trim();
        auth.sendPasswordResetEmail(username).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
           progressDialog.dismiss();
           if(task.isSuccessful()){
               Toast.makeText(LoginActivity.this, "Email send", Toast.LENGTH_SHORT).show();
           }
            }
        });

    }

}