package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LichSuNapTienActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private LSNapTienAdapter adapter3;
    private List<Money> list4;

    Button btn1,btn2,btn3,btn4;
    ImageButton quayve;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_nap_tien);

        //ánh xạ
        recyclerView = findViewById(R.id.recyclerView11);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list4 = new ArrayList<>(); // Khai báo mảng list
        adapter3 = new LSNapTienAdapter(this, list4);
        recyclerView.setAdapter(adapter3);
        showData();
        btn1 = findViewById(R.id.btnn1);
        btn2 = findViewById(R.id.btnn2);
        btn3 = findViewById(R.id.btnn3);
        btn4 = findViewById(R.id.btnn4);
        quayve = findViewById(R.id.account12);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuNapTienActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuNapTienActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuNapTienActivity.this, LichSuGIaoDichActivity.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuNapTienActivity.this, ChartActivity.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuNapTienActivity.this, ThongTinCaNhanActivity.class);
                startActivity(i);
            }
        });
    }
    public void showData(){
        db.collection("NapTien").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot snapshot : task.getResult()) {
                           /* Model1 model = new Model1(snapshot.getString("id"), snapshot.getString("title"), snapshot.getString("desc")); // Lưu ý phải trùng tên với key trong db
                            list4.add(model);*/
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list4.add(model1);
                        }
                        adapter3.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LichSuNapTienActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}