package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
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

public class NapTienActivity extends AppCompatActivity {
    ImageButton back;
    private FirebaseFirestore db;

    private String uid;


    private MoneyAdapter adapter;
    private UserAdapter adapter1;
    private ThongBaoMoiAdapter adapter2;
    private NapTienActivity activity;
    private MainActivity activity1;
    private ChuyenTienActivity activity2;
    private ThongBaoMoiActivity activity3;
    private ThongTinCaNhanActivity activity4;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
   private List<Model>list2;
    private List<Money> list;
    private List<User>list1;
    EditText datien,dattien1,nhapsothe,hotenchuthe;
    Button nap100k, nap200k, nap300k, nap500k,nap1M,nap2M,nap5M,nap10M,tieptuc1;
    private  String tien12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nap_tien);
        back = findViewById(R.id.account12);
        nap100k = findViewById(R.id.nap100k);
        nap200k = findViewById(R.id.nap200k);
        db = FirebaseFirestore.getInstance();
        nap300k = findViewById(R.id.nap300k);
        nap500k = findViewById(R.id.nap500k);
        nap1M = findViewById(R.id.nap1M);
        nap2M = findViewById(R.id.nap2M);
        nap5M = findViewById(R.id.nap5M);
        nap10M = findViewById(R.id.nap10M);
        tieptuc1 = findViewById(R.id.tieptuc);
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>();
        adapter = new MoneyAdapter(this, list,activity1,activity2,activity3,activity4,activity5,activity6,activity7,activity8);
        adapter1 = new UserAdapter(this, list1,activity1,activity2,activity3,activity4,activity5,activity6,activity7);
        adapter2=new ThongBaoMoiAdapter(list2,this,activity1,activity2,activity3,activity4,activity5,activity6,activity7,list,activity8);
        nhapsothe = findViewById(R.id.nhapsothe);
        hotenchuthe = findViewById(R.id.hotenchuthe);
        dattien1 = findViewById(R.id.datten1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NapTienActivity.this, MainActivity.class);
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
        tieptuc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String datten1=dattien1.getText().toString().trim();
                String daten="";
                String nhapsothe1=nhapsothe.getText().toString().trim();
                String hotenchuthe1=hotenchuthe.getText().toString().trim();
                String tien1=datten1;
               // String tien1="";
                String chuyentien1="";
                String soluongtktk1="0";
                String ngayketso="0";
                String email1=user.getEmail();
                String ngaythangnam="";
                String sodienthoai="";
                LocalDate dateTime=LocalDate.now();
                String ngaymoso=dateTime.toString();
                String kyhan="";
                String laisuatnam="";
                String tonglaisuat="";
               /* String title = datien.getText().toString(); // gán dữ liệu nhập ở ô title vào biến title
                String desc = nhapsothe.getText().toString().trim();*/
                Bundle bundle1=getIntent().getExtras();
                if(bundle1!=null)
                {
                    String id=uid;
                    Money money=new Money(datten1,tien1,chuyentien1,soluongtktk1,ngaymoso,ngayketso,email1,nhapsothe1,hotenchuthe1,id,ngaythangnam,sodienthoai,daten,kyhan,laisuatnam,tonglaisuat);
                }else {
                    String id = UUID.randomUUID().toString();
                    Money money=new Money(datten1,tien1,chuyentien1,soluongtktk1,ngaymoso,ngayketso,email1,nhapsothe1,hotenchuthe1,id,ngaythangnam,sodienthoai,daten,kyhan,laisuatnam,tonglaisuat);
                    save(money);
                }
            }
        });

    }


  public void save(Money money)
  {
      FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
      db.collection("Documents").get()
              .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                  @Override
                  public void onComplete(@NonNull Task<QuerySnapshot> task) {
                      for (DocumentSnapshot snapshot : task.getResult()) {
                          Money model = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                          list.add(model);
                          User model1 = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"),snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                          list1.add(model1);
                          do {
                              if(!money.tien.isEmpty()&&!money.email.isEmpty()&&!money.ngaymoso.isEmpty()&&!money.hotenchuthe.isEmpty()&&!money.naptien.isEmpty()&&!money.soluongtktk.isEmpty()) {
                                  HashMap<String,Object> map=new HashMap<>();
                                  HashMap<String,Object> map1=new HashMap<>();
                                  Double tien12=Double.parseDouble(model.getTien());
                                  Double tien13=Double.parseDouble(money.getNaptien());
                                  tien12+=tien13;
                                  String tong2=String.valueOf(tien12);
                                  String Thongbao ="Nạp Tiền Thành Công";
                                  map1.put("tien",tong2);
                                  map.put("naptien",money.naptien);
                                  map.put("tien",tong2);
                                  map.put("soluongtktk",Thongbao);
                                  map.put("ngaymoso",money.ngaymoso);
                                  map.put("ngayketso",money.ngayketso);
                                  map.put("email",model1.email);
                                  map.put("nhapsothe",money.nhapsothe);
                                  map.put("hotenchuthe",model1.getHoten());
                                  map.put("sodienthoai",model1.getSodienthoai());
                                  map.put("ngaythangnam",model.getNgaythangnam());
                                  map.put("id",model1.id);
                                  hotenchuthe.setText(model1.getHoten());
                                  model1.setTien(tong2);
                                  db.collection("NapTien").document(money.id).set(map)
                                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                                              @Override
                                              public void onComplete(@NonNull Task<Void> task) {
                                                  if(task.isSuccessful()){

                                                      Toast.makeText(NapTienActivity.this, "Nạp thành công", Toast.LENGTH_SHORT).show();
                                                        Intent i=new Intent(NapTienActivity.this,MainActivity.class);
                                                        startActivity(i);
                                                  }
                                              }
                                          }).addOnFailureListener(new OnFailureListener() {
                                              @Override
                                              public void onFailure(@NonNull Exception e) {
                                                  Toast.makeText(NapTienActivity.this, "Nạp thất bại ", Toast.LENGTH_SHORT).show();
                                              }
                                          });
                                  db.collection("Documents").document(model1.id).update("tien",tong2)
                                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                                              @Override
                                              public void onComplete(@NonNull Task<Void> task) {
                                                  if(task.isSuccessful()) {
                                                  } else {
                                                  }
                                              }
                                          }).addOnFailureListener(new OnFailureListener() { // Khi lưu thất bại
                                              @Override
                                              public void onFailure(@NonNull Exception e) {
                                                  Toast.makeText(NapTienActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                              }
                                          });
                                  db.collection("NapTien").document(model1.id).update("hotenchuthe",model1.hoten)
                                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                                              @Override
                                              public void onComplete(@NonNull Task<Void> task) {
                                                  if(task.isSuccessful()) {
                                                  } else {
                                                  }
                                              }
                                          }).addOnFailureListener(new OnFailureListener() { // Khi lưu thất bại
                                              @Override
                                              public void onFailure(@NonNull Exception e) {
                                                  Toast.makeText(NapTienActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                              }
                                          });
                              }
                          }while (user.getEmail()==model.getEmail());
                      }
                  }
              }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText(NapTienActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                  }
              });
  }
}