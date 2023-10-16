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

public class DoiHoChieuActivity extends AppCompatActivity {
    EditText doi;
    Button btnxacnhan;
    private List<Money> list;
    private List<User> list1;
    private DoiAdapter doiAdapter;
    private DoiSoDienThoaiActivity activity;
    private DoiNgayThangNamActivity activity2;
    ImageButton account12;
    String uid;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_ho_chieu);
        doi = findViewById(R.id.doi);
        btnxacnhan = findViewById(R.id.btnxacnhan);
        list = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        account12=findViewById(R.id.account12);
        account12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(DoiHoChieuActivity.this,ThongTinCaNhanActivity.class);
                startActivity(i);
            }
        });
        list1 = new ArrayList<>();
        doiAdapter = new DoiAdapter(activity, list, list1, activity2, this);
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hochieu1 = doi.getText().toString();
                Update(hochieu1);
            }
        });
    }
    public void Update(String hochieu) {
        Map<String, Object> map = new HashMap<>();
        map.put("sodienthoai", hochieu);
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model);
                            db.collection("Documents").document(model.id).update("hochieu", hochieu)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(DoiHoChieuActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
                                                Intent i=new Intent(DoiHoChieuActivity.this,ThongTinCaNhanActivity.class);
                                                startActivity(i);
                                            } else {
                                                Toast.makeText(DoiHoChieuActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() { // Khi lưu thất bại
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(DoiHoChieuActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DoiHoChieuActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}