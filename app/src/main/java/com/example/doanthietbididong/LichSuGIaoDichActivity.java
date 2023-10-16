package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LichSuGIaoDichActivity extends AppCompatActivity {

   /* private FirebaseFirestore db;
  *//*  private RecyclerView recyclerView1;*//*

    private List<Money> list;
    private List<User>list1;
    private List<Model> list2;
    private MoneyAdapter adapter;
    private UserAdapter adapter1;
    private ThongBaoMoiAdapter adapter2;

    TextView title,description;*/

   /* private NapTienActivity activity;
    private ThongTinCaNhanActivity activity4;
    private ThongBaoMoiActivity activity3;
    private ChuyenTienActivity activity2;
    private MainActivity activity1;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;*/

    Button btnnaptien, btnchuyentien,btn1,btn2,btn3,btn4;
    ImageButton quayve;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_giao_dich);

        btn1 = findViewById(R.id.btnn1);
        btn2 = findViewById(R.id.btnn2);
        btn3 = findViewById(R.id.btnn3);
        btn2.setBackgroundColor(Color.RED);
        btn4 = findViewById(R.id.btnn4);
        quayve = findViewById(R.id.account12);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuGIaoDichActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuGIaoDichActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuGIaoDichActivity.this, ChartActivity.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuGIaoDichActivity.this, ThongTinCaNhanActivity.class);
                startActivity(i);
            }
        });
        // Ánh xạ
      /*  recyclerView1 = findViewById(R.id.rvList);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));*/
       /* db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list

        list2 = new ArrayList<>(); // Khai báo mảng list*/
        /*adapter = new MoneyAdapter(activity, list,activity1,activity2,activity3,activity4,activity5,activity6,activity7,this);
       *//* adapter1 = new UserAdapter(activity, list1,activity1,activity2,activity3,activity4,activity5,activity6,activity7);*//*
        adapter2 = new ThongBaoMoiAdapter(list2, activity,activity1,activity2,activity3,activity4,activity5,activity6,activity7,list,this);*/
       /* recyclerView1.setAdapter(adapter2);*/
      /*  title=findViewById(R.id.title_text);
        description=findViewById(R.id.desc_text);*/

        btnnaptien = findViewById(R.id.btnnaptien);
        btnchuyentien = findViewById(R.id.btnchuyentien);
        btnnaptien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuGIaoDichActivity.this, LichSuNapTienActivity.class);
                startActivity(i);
            }
        });
        btnchuyentien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LichSuGIaoDichActivity.this, LichSuChuyenTienActivity.class);
                startActivity(i);
            }
        });
        /*ItemTouchHelper touchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView);*/
        /*showData1();*/
    }
  /*  public void showData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Model model = new Model(snapshot.getString("id"), snapshot.getString("title"), snapshot.getString("desc")); // Lưu ý phải trùng tên với key trong db
                            list2.add(model);
                            *//*Model model2 = new Model(snapshot.getString("id"), snapshot.getString("title"),snapshot.getString("desc"));
                            list2.add(model2);*//*
                        *//*       title.setText("Nạp tiền thành công");
                               description.setText(model.getDesc());*//*
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list.add(model1);
                          title.setText("Nạp tiền thành công");
                        }
                       *//* adapter2.notifyDataSetChanged();*//*
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LichSuGIaoDichActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });*/
    /*public void showData1() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("GiaoDich").whereEqualTo("email", user.getEmail()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list2.clear();
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Model model = new Model(snapshot.getString("id"), snapshot.getString("title"), snapshot.getString("desc")); // Lưu ý phải trùng tên với key trong db
                            list2.add(model);
                        }
                        adapter2.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LichSuGIaoDichActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }*/
}

