package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ChuyenTienActivity extends AppCompatActivity {
    TextView tien1,dattien1;
    EditText nhapsothe,sotien,hotenchuthe;
    ImageButton quayve;
    private  String uid;
    Button nap100k, nap200k, nap300k, nap500k,nap1M,nap2M,nap5M,nap10M,xacnhan;
    private List<Money> list;
    private List<User>list1;
    private FirebaseFirestore db;
    private MoneyAdapter adapter;
    private UserAdapter adapter1;
    private NapTienActivity activity;
    private ThongTinCaNhanActivity activity4;
    private ThongBaoMoiActivity activity3;
    private ChuyenTienActivity activity2;
    private  MainActivity activity1;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuyen_tien);
        adapter=new MoneyAdapter(activity,list,activity1,this,activity3,activity4,activity5,activity6,activity7,activity8);
        adapter1= new UserAdapter(activity, list1,activity1,this,activity3,activity4,activity5,activity6,activity7);
        db = FirebaseFirestore.getInstance();
        nhapsothe=findViewById(R.id.nhapsothe1);
        sotien=findViewById(R.id.sotien1);
        quayve = findViewById(R.id.account12);
        hotenchuthe=findViewById(R.id.hotenchuthe1);
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>();
        tien1=findViewById(R.id.tien1);
        xacnhan=findViewById(R.id.xacnhan);
        nap100k = findViewById(R.id.nap100k);
        nap200k = findViewById(R.id.nap200k);
        nap300k = findViewById(R.id.nap300k);
        nap500k = findViewById(R.id.nap500k);
        nap1M = findViewById(R.id.nap1M);
        nap2M = findViewById(R.id.nap2M);
        nap5M = findViewById(R.id.nap5M);
        nap10M = findViewById(R.id.nap10M);
        dattien1 = findViewById(R.id.sotien1);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChuyenTienActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        nap100k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "100000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.parseColor("#810000"));
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.WHITE);
                nap100k.setTextColor(Color.WHITE);
                nap200k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap200k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "200000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.parseColor("#810000"));
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.WHITE);
                nap200k.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap300k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "300000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.parseColor("#810000"));
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.WHITE);
                nap300k.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap200k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap500k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "500000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.parseColor("#810000"));
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.WHITE);
                nap500k.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap200k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap1M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "1000000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.parseColor("#810000"));
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.WHITE);
                nap1M.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap200k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap2M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "2000000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.parseColor("#810000"));
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.WHITE);
                nap2M.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap200k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap5M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "5000000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.parseColor("#810000"));
                nap10M.setBackgroundColor(Color.WHITE);
                nap5M.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap200k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap10M.setTextColor(Color.BLACK);
            }
        });
        nap10M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dattien = "10000000";
                dattien1.setText(dattien);
                nap100k.setBackgroundColor(Color.WHITE);
                nap200k.setBackgroundColor(Color.WHITE);
                nap300k.setBackgroundColor(Color.WHITE);
                nap500k.setBackgroundColor(Color.WHITE);
                nap1M.setBackgroundColor(Color.WHITE);
                nap2M.setBackgroundColor(Color.WHITE);
                nap5M.setBackgroundColor(Color.WHITE);
                nap10M.setBackgroundColor(Color.parseColor("#810000"));
                nap10M.setTextColor(Color.WHITE);
                nap100k.setTextColor(Color.BLACK);
                nap200k.setTextColor(Color.BLACK);
                nap300k.setTextColor(Color.BLACK);
                nap500k.setTextColor(Color.BLACK);
                nap1M.setTextColor(Color.BLACK);
                nap2M.setTextColor(Color.BLACK);
                nap5M.setTextColor(Color.BLACK);

            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String nhapsothe1=nhapsothe.getText().toString().trim();
                String chuyentien=sotien.getText().toString().trim();
            String hotenchuthe1=hotenchuthe.getText().toString().trim();
              // String hotenchuthe1="";
                String tien="0";
                String soluongtktk1="0";
                String ngayketso="0";
                String ngaythangnam="0";
                String sodienthoai="0";
                String naptien="0";
                String email1= user.getEmail().toString();
                LocalDate dateTime=LocalDate.now();
                String ngaymoso=dateTime.toString();
                String daten="";
                String kyhan="";
                String laisuatnam="";
                String tonglaisuat="";
                Bundle bundle1=getIntent().getExtras();
                if(bundle1!=null)
                {
                    String id=uid;
                    Money money=new Money(naptien,tien,chuyentien,soluongtktk1,ngaymoso,ngayketso,email1,nhapsothe1,hotenchuthe1,id,ngaythangnam,sodienthoai,daten,kyhan,laisuatnam,tonglaisuat);
                }else {
                    String id = UUID.randomUUID().toString(); // random id
                    Money money=new Money(naptien,tien,chuyentien,soluongtktk1,ngaymoso,ngayketso,email1,nhapsothe1,hotenchuthe1,id,ngaythangnam,sodienthoai,daten,kyhan,laisuatnam,tonglaisuat);
                    save(money);
                }
            }
        });
        Sodukhadung();
    }
    public void Sodukhadung(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list.add(model1);
                            tien1.setText(model.getTien());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ChuyenTienActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void save(Money money)
    {
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot snapshot:task.getResult()) {
                    Money model = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"), snapshot.getString("laisuatnam"), snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                    list.add(model);
                    User model1 = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                    list1.add(model1);
                    do {
                        if (!money.tien.isEmpty() && !money.email.isEmpty() && !money.ngaymoso.isEmpty() && !money.hotenchuthe.isEmpty() && !money.naptien.isEmpty() && !money.soluongtktk.isEmpty()) {
                            HashMap<String, Object> map = new HashMap<>();
                            HashMap<String, Object> map1 = new HashMap<>();
                            Double tien12 = Double.parseDouble(model.getTien());
                            Double tien13 = Double.parseDouble(money.getChuyentien());
                            if (tien12 >= tien13) {
                                tien12 -= tien13;
                                String tong2 = String.valueOf(tien12);
                                String ThongBao = "Rút Tiền Thành Công";
                                map1.put("tien", tong2);
                                map.put("tien", tong2);
                                model1.setTien(tong2);
                                map.put("soluongtktk", ThongBao);

                                map.put("chuyentien", money.chuyentien);

                                map.put("ngaymoso", money.ngaymoso);
                                map.put("ngayketso", money.ngayketso);
                                map.put("email", model1.email);
                                map.put("nhapsothe", money.nhapsothe);
                                map.put("hotenchuthe", model1.getHoten());
                                map.put("sodienthoai", model1.getSodienthoai());
                                map.put("ngaythangnam", model1.getNgaythangnam());
                                map.put("id", model1.id);
                                hotenchuthe.setText(model1.getHoten());
                                tien1.setText(model1.getTien());
                                db.collection("RutTien").document(money.id).set(map)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {

                                                    Toast.makeText(ChuyenTienActivity.this, "Chuyển tiền thành công", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(ChuyenTienActivity.this, MainActivity.class);
                                                    startActivity(i);
                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(ChuyenTienActivity.this, "Chuyển tiền thất bại ", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                db.collection("Documents").document(model1.id).update("tien", tong2)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                } else {
                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() { // Khi lưu thất bại
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                            }
                                        });
                                db.collection("RutTien").document(money.id).update("hotenchuthe", model1.hoten)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(ChuyenTienActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(ChuyenTienActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show(); // Khi lưu thất bại
                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() { // Khi lưu thất bại
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(ChuyenTienActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });

                            }
                         else{
                                Toast.makeText(ChuyenTienActivity.this, "Tiền không đủ để chuyển", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                        while (user.getEmail() == model.getEmail() && model.getId() == model1.getId());
                    }

            }
        });
    }
}