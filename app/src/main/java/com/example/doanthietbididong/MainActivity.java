package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton btnMotktk, btnNaptien, btnRuttien,listLogined1;
    private UserAdapter adapter;
    private MoneyAdapter adapter1;
    private ThongBaoMoiAdapter adapter2;
    private List<Money> list1;
    private List<User> list;
    private List<Model> list2;
    Button btn2,btn3,btn4;
    private static final String TAG = "MainActivity";

    private FirebaseFirestore db;
    private NapTienActivity activity;
    private MainActivity activity1;
    private ChuyenTienActivity activity2;
    private ThongBaoMoiActivity activity3;
    private ThongTinCaNhanActivity activity4;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
    Button  btnGttn,btnn1,btnn2,btnn3,btnn4,btnn5;
    TextView ten,tienchinh;
    BottomNavigationView mnBottom;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMotktk = findViewById(R.id.tktkLogined);
        btnNaptien = findViewById(R.id.naptienLogined);
      btnRuttien=findViewById(R.id.ruttienLogined);
        btnGttn = findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btnn1=findViewById(R.id.btnn1);
        btnn1.setBackgroundColor(Color.RED);
        btnn2=findViewById(R.id.btnn2);
        btnn3=findViewById(R.id.btnn3);
        listLogined1=findViewById(R.id.listLogined1);
        btnn4=findViewById(R.id.btnn4);
        btnn5=findViewById(R.id.btnn5);
        tienchinh=findViewById(R.id.tienchinh);
        ten=findViewById(R.id.ten);
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>(); // Khai báo mảng list
        adapter = new UserAdapter(activity,list,this,activity2,activity3,activity4,activity5,activity6,activity7);
        adapter1 = new MoneyAdapter(activity,list1,this,activity2,activity3,activity4,activity5,activity6,activity7,activity8);
        adapter2 = new ThongBaoMoiAdapter(list2,activity,this,activity2,activity3,activity4,activity5,activity6,activity7,list1,activity8);
        listLogined1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,KhiChonKhongCamOnActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,HuongDanSuDungActivity.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,BangLaiSuat1Activity.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ThongTinChungActivity.class);
                startActivity(i);
            }
        });
        btnn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ThongBaoMoiActivity.class);
                startActivity(i);
            }
        });
        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,LichSuGIaoDichActivity.class);
                startActivity(i);
            }
        });
        btnRuttien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ChuyenTienActivity.class);
                startActivity(i);
            }
        });
        btnn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ThongTinCaNhanActivity.class);
                startActivity(i);
            }
        });
        btnMotktk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BangLaiSuatActivity.class);
                startActivity(i);
            }
        });
        btnNaptien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NapTienActivity.class);
                startActivity(i);
            }
        });
        btnGttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,GiaiThichThuatNguActivity.class);
                startActivity(i);
            }
        });
        btnn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ChartActivity.class);
                startActivity(i);
            }
        });
        showData();
    }
    public void showData(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").whereEqualTo("email",user.getEmail()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"),snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            do{
                                tienchinh.setText(model.tien);
                                if(model.hoten!=null){
                                    ten.setText(model.hoten);
                                }
                                else {
                                    ten.setText(model1.hotenchuthe);
                                }
                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }



}

