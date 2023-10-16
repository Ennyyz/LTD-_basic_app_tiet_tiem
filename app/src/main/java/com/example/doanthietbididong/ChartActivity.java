package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChartActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private  MoneyAdapter adapter1;
    private NapTienActivity activity;
    private ThongTinCaNhanActivity activity4;
    private ThongBaoMoiActivity activity3;
    private ChuyenTienActivity activity2;
    private  MainActivity activity1;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
    private List<User> list1;
    Context context;
    private  List<Money>list;
    Button btn1,btn2,btn3,btn4;
    ImageButton quayve;
    private ChuyenTienActivity chuyenTienActivity;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>(); // Khai báo mảng list
        adapter = new UserAdapter(activity,list1,activity1,activity2,activity3,activity4,this,activity6,activity7);
        adapter1=new MoneyAdapter(activity,list,activity1,activity2,activity3,activity4,this,activity6,activity7,activity8);
        ShowData1();
        btn1 = findViewById(R.id.btnn1);
        btn2 = findViewById(R.id.btnn2);
        btn3 = findViewById(R.id.btnn3);
        btn4 = findViewById(R.id.btnn4);
        btn3.setBackgroundColor(Color.RED);
        quayve = findViewById(R.id.account12);
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChartActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChartActivity.this, LichSuGIaoDichActivity.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChartActivity.this, ThongTinCaNhanActivity.class);
                startActivity(i);
            }
        });

    }
    public void ShowData1(){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            db.collection("MoTaiKhoangTietKiem").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            list.clear();
                            for (DocumentSnapshot snapshot : task.getResult()) {
                                User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"),snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                                list1.add(model);
                                Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                                list.add(model1);
                                String tien1=model1.getNaptien();
                                float tien2=(Float.parseFloat(tien1)*6)/100;
                                String tien31="7.9";
                                float tien3=(Float.parseFloat(tien1)*Float.parseFloat(tien31))/100;
                                String tien4="8.5";
                                float tien41 =(Float.parseFloat(tien1)*Float.parseFloat(tien4))/100;
                                String tien5="8.9";
                                float tien51 =(Float.parseFloat(tien1)*Float.parseFloat(tien5))/100;
                                    BarChart barChart=findViewById(R.id.barchart);
                                    ArrayList<BarEntry>visitors=new ArrayList<>();
                                    visitors.add(new BarEntry(1,tien2));
                                    visitors.add(new BarEntry(3,tien2));
                                    visitors.add(new BarEntry(6,tien3));
                                    visitors.add(new BarEntry(12,tien41));
                                    visitors.add(new BarEntry(18,tien51));
                                    BarDataSet barDataSet=new BarDataSet(visitors,"Là số tổng số tiền mà khách hàng đã nạp vào theo từng kỳ hạn");
                                    barDataSet.setColors(Color.parseColor("#810000"));
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);
                                    BarData barData=new BarData(barDataSet);
                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Kỳ hạn");
                                    barChart.animateY(2000);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ChartActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

