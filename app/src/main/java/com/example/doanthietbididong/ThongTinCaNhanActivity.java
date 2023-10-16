package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ThongTinCaNhanActivity extends AppCompatActivity {
    Button dangxuat,btnn4,btnn1,update1,update2,update3;
    public String hoten;
    private UserAdapter adapter;
    private  MoneyAdapter adapter1;
    private NapTienActivity activity;
    private  MainActivity activity1;
    private ChuyenTienActivity activity2;
    private  ThongBaoMoiActivity activity3;
    private ThongTinCaNhanActivity activity4;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
    private List<User> list;
    private  List<Money>list1;
    private ChartActivity chartActivity;
    TextView TenUser, SDTUser, DateUser, CMNDUser, EmailUser;
    private FirebaseAuth mAuth;
    private ChuyenTienActivity chuyenTienActivity;

    Button btn3,btn2,UpdateMK;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        dangxuat=findViewById(R.id.dangxuat);
        TenUser = findViewById(R.id.tenUser);
        SDTUser = findViewById(R.id.sodienthoaiUser);
        DateUser = findViewById(R.id.ngaythangnamUser);
        CMNDUser = findViewById(R.id.cmndUser);
        EmailUser = findViewById(R.id.emailUser);
        UpdateMK=findViewById(R.id.updateMk);
        update1=findViewById(R.id.update1);
        update2=findViewById(R.id.update2);
        update3=findViewById(R.id.update3);
        btnn4=findViewById(R.id.btnn4);
        btn3=findViewById(R.id.btnn3);
        btn2=findViewById(R.id.btnn2);
        btnn4.setBackgroundColor(Color.RED);
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>(); // Khai báo mảng list
        mAuth=FirebaseAuth.getInstance();
        adapter = new UserAdapter(activity, list,activity1,activity2,activity3,this,activity5,activity6,activity7);
        adapter1=new MoneyAdapter(activity, list1,activity1,activity2,activity3,this,activity5,activity6,activity7,activity8);
update2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent intent=new Intent(ThongTinCaNhanActivity.this,DoiNgayThangNamActivity.class);
startActivity(intent);
    }
});
update3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent intent=new Intent(ThongTinCaNhanActivity.this,DoiHoChieuActivity.class);
startActivity(intent);
    }
});
        btnn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ThongTinCaNhanActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        btnn1=findViewById(R.id.btnn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongTinCaNhanActivity.this,LichSuGIaoDichActivity.class);
                startActivity(i);
            }
        });
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ThongTinCaNhanActivity.this,DoiSoDienThoaiActivity.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongTinCaNhanActivity.this,ChartActivity.class);
                startActivity(i);
            }
        });

        UpdateMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongTinCaNhanActivity.this,DoiMatKhauActivity.class);
                startActivity(i);
            }
        });

        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnn1.setBackgroundColor(Color.RED);
                Intent i=new Intent(ThongTinCaNhanActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
               Intent i = new Intent(ThongTinCaNhanActivity.this,ChinhActivity.class);
               startActivity(i);
                Toast.makeText(ThongTinCaNhanActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            }
        });
        //  showinformation1();
        showData();
    }
    private void showimformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        String emailNguoiDung = user.getEmail();
        EmailUser.setText(emailNguoiDung);
    }
    public void showData(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").whereEqualTo("email", user.getEmail()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"),snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            do {
                                TenUser.setText(model.getHoten());
                                EmailUser.setText(model.getEmail());
                                SDTUser.setText(model.getSodienthoai());
                                SDTUser.setText(model1.getSodienthoai());
                                CMNDUser.setText(model.getHochieu());
                                DateUser.setText(model.getNgaythangnam());
                                DateUser.setText(model1.getNgaythangnam());
                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ThongTinCaNhanActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}