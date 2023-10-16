package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class TKTKTaiTucActivity extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private FirebaseFirestore db;
    private MyAdapter adapter;
    private KhiChonKhongCamOnActivity khichonkhongcamon;
    private List<Money> list;
    Button khongcamon,taituc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tktktai_tuc);

        recyclerView1 = findViewById(R.id.rvList);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        adapter = new MyAdapter(this, list,khichonkhongcamon);
        khongcamon=findViewById(R.id.khongcamon);
        taituc=findViewById(R.id.taituc);
        khongcamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TKTKTaiTucActivity.this,KhiChonKhongCamOnActivity.class);
                startActivity(i);
            }
        });
        taituc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TKTKTaiTucActivity.this,ThongBaoThanhCongNapTienActivity.class);
                startActivity(i);
            }
        });

      /*  recyclerView1.setAdapter(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView1);
        showData();*/
    }
    // Hàm get danh sách data từ Firebase
   /* public void showData(){
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list.add(model1);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(TKTKTaiTucActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });

    }*/
}