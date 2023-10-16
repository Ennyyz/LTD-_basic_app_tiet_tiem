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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoiNgayThangNamActivity extends AppCompatActivity {
    EditText doi;
    Button btnxacnhan;
    private List<Money> list;
    private List<User> list1;
    private DoiAdapter doiAdapter;
    private DoiSoDienThoaiActivity activity;
    private DoiHoChieuActivity activity3;
    private DoiNgayThangNamActivity activity2;
    String uid;
    private FirebaseFirestore db;
    ImageButton account12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_ngay_thang_nam);
        doi = findViewById(R.id.doi);
        btnxacnhan = findViewById(R.id.btnxacnhan);
        account12=findViewById(R.id.account12);
        account12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DoiNgayThangNamActivity.this,ThongTinCaNhanActivity.class);
                startActivity(i);
            }
        });
        list = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        list1 = new ArrayList<>();
        doiAdapter = new DoiAdapter(activity, list, list1, activity2, activity3);
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ngaythangnam1 = doi.getText().toString();
                Update(ngaythangnam1);
            }
        });
    }

    public void Update(String ngaythangnam) {
        Map<String, Object> map = new HashMap<>();
        map.put("sodienthoai", ngaythangnam);
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model);
                            db.collection("Documents").document(model.id).update("ngaythangnam", ngaythangnam)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(DoiNgayThangNamActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
                                                Intent i=new Intent(DoiNgayThangNamActivity.this,ThongTinCaNhanActivity.class);
                                                startActivity(i);
                                            } else {
                                                Toast.makeText(DoiNgayThangNamActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() { // Khi lưu thất bại
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(DoiNgayThangNamActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DoiNgayThangNamActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}