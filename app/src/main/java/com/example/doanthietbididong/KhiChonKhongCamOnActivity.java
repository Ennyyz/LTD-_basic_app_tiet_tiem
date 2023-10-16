package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KhiChonKhongCamOnActivity extends AppCompatActivity {
    ImageButton back;
    Button addDSTK;
    private RecyclerView recyclerView1;
    private FirebaseFirestore db;
    private MyAdapter adapter;
    TextView SoduKhaDung;
    private List<Money> list;
    private TKTKTaiTucActivity tktktaituc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khi_chon_khong_cam_on);
        back = findViewById(R.id.account12);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KhiChonKhongCamOnActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        addDSTK = findViewById(R.id.addTKTK);
        addDSTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KhiChonKhongCamOnActivity.this, MoTaiKhoanTietKiemActivity.class);
                startActivity(i);
            }
        });
        recyclerView1 = findViewById(R.id.ListDstk);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        adapter = new MyAdapter(tktktaituc, list, this);
        SoduKhaDung = findViewById(R.id.SoduKhaDung);
        recyclerView1.setAdapter(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView1);
        showData();
        showData1();
    }

    public void showData() {
        db.collection("MoTaiKhoangTietKiem").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"), snapshot.getString("laisuatnam"), snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list.add(model1);
                            SoduKhaDung.setText(model1.tien);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(KhiChonKhongCamOnActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    public void showData1() {
        db.collection("GiaoDich").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"), snapshot.getString("laisuatnam"), snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list.add(model1);
                            SoduKhaDung.setText(model1.tien);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(KhiChonKhongCamOnActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}