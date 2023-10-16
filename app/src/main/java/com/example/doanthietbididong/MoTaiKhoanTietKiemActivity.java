package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MoTaiKhoanTietKiemActivity extends AppCompatActivity {
    Button Cancel,thang1,thang3,thang6,thang12,thang18,Motktk;
    TextView text1,TienLai,Ngaymotk,Ngayhethan,TongSoTien,Sodukhadung;
    ImageButton Back;
    EditText Datten, SoTien;
    private List<User> list;
    private  List<Money>list1;
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

    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_tai_khoan_tiet_kiem);
        Back=findViewById(R.id.account12);
        thang1=findViewById(R.id.btn1);
        Sodukhadung=findViewById(R.id.tvSoDuKhaDung);
        thang3=findViewById(R.id.btn3);
        thang6=findViewById(R.id.btn6);
        thang12=findViewById(R.id.btn12);
        thang18=findViewById(R.id.btn18);
        text1=findViewById(R.id.tvLaisuatnam);
        Cancel = findViewById(R.id.cancel);
        Datten = findViewById(R.id.edDatTen);
        SoTien = findViewById(R.id.edNapTien);
        Motktk = findViewById(R.id.btnMotktk);
        TienLai = findViewById(R.id.tvTongTienLai);
        Ngaymotk = findViewById(R.id.tvNgayMoTk);
        Ngayhethan = findViewById(R.id.tvNgayHetHan);
        TongSoTien = findViewById(R.id.tvTongSoTien);
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>(); // Khai báo mảng list
        adapter = new UserAdapter(activity, list,activity1,activity2,activity3,activity4,activity5,activity6,activity7);
        adapter1=new MoneyAdapter(activity, list1,activity1,activity2,activity3,activity4,activity5,activity6,activity7,activity8);
        /*double valuetien = Double.parseDouble(sotien1);*/
        Sodukhadung();

        thang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("6%");
                thang1.setBackgroundColor(Color.parseColor("#810000"));
                thang3.setBackgroundColor(Color.WHITE);
                thang6.setBackgroundColor(Color.WHITE);
                thang12.setBackgroundColor(Color.WHITE);
                thang18.setBackgroundColor(Color.WHITE);
                thang1.setTextColor(Color.WHITE);
                thang3.setTextColor(Color.BLACK);
                thang6.setTextColor(Color.BLACK);
                thang12.setTextColor(Color.BLACK);
                thang18.setTextColor(Color.BLACK);
                Tien1();
            /*    LocalDate date = LocalDate.now();
                Ngaymotk.setText(date.toString());
                Ngayhethan.setText(date.plusMonths(1).toString());*/
            }
        });
        thang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("6%");
                thang1.setBackgroundColor(Color.WHITE);
                thang3.setBackgroundColor(Color.parseColor("#810000"));
                thang6.setBackgroundColor(Color.WHITE);
                thang12.setBackgroundColor(Color.WHITE);
                thang18.setBackgroundColor(Color.WHITE);
                thang1.setTextColor(Color.BLACK);
                thang3.setTextColor(Color.WHITE);
                thang6.setTextColor(Color.BLACK);
                thang12.setTextColor(Color.BLACK);
                thang18.setTextColor(Color.BLACK);
                //LÝ DO KHÁC NHAU CÁI THÁNG
                Tien11();
               /* LocalDate date = LocalDate.now();
                Ngaymotk.setText(date.toString());
                Ngayhethan.setText(date.plusMonths(3).toString());*/
            }
        });
        thang6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thang1.setBackgroundColor(Color.WHITE);
                thang3.setBackgroundColor(Color.WHITE);
                thang6.setBackgroundColor(Color.parseColor("#810000"));
                thang12.setBackgroundColor(Color.WHITE);
                thang18.setBackgroundColor(Color.WHITE);
                text1.setText("7.9%");
                thang1.setTextColor(Color.BLACK);
                thang3.setTextColor(Color.BLACK);
                thang6.setTextColor(Color.WHITE);
                thang12.setTextColor(Color.BLACK);
                thang18.setTextColor(Color.BLACK);
                Tien2();
              /*  LocalDate date = LocalDate.now();
                Ngaymotk.setText(date.toString());
                Ngayhethan.setText(date.plusMonths(6).toString());*/
            }
        });
        thang12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thang1.setBackgroundColor(Color.WHITE);
                thang3.setBackgroundColor(Color.WHITE);
                thang6.setBackgroundColor(Color.WHITE);
                thang12.setBackgroundColor(Color.parseColor("#810000"));
                thang18.setBackgroundColor(Color.WHITE);
                text1.setText("8.5%");
                thang1.setTextColor(Color.BLACK);
                thang3.setTextColor(Color.BLACK);
                thang6.setTextColor(Color.BLACK);
                thang12.setTextColor(Color.WHITE);
                thang18.setTextColor(Color.BLACK);
                Tien3();
                /*LocalDate date = LocalDate.now();
                Ngaymotk.setText(date.toString());
                Ngayhethan.setText(date.plusMonths(12).toString());*/
            }
        });
        thang18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("8.9%");
                thang1.setBackgroundColor(Color.WHITE);
                thang3.setBackgroundColor(Color.WHITE);
                thang6.setBackgroundColor(Color.WHITE);
                thang12.setBackgroundColor(Color.WHITE);
                thang18.setBackgroundColor(Color.parseColor("#810000"));
                thang1.setTextColor(Color.BLACK);
                thang3.setTextColor(Color.BLACK);
                thang6.setTextColor(Color.BLACK);
                thang12.setTextColor(Color.BLACK);
                thang18.setTextColor(Color.WHITE);
                Tien4();
               /* LocalDate date = LocalDate.now();
                Ngaymotk.setText(date.toString());
                Ngayhethan.setText(date.plusMonths(18).toString());*/
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MoTaiKhoanTietKiemActivity.this,KhiChonKhongCamOnActivity.class);
                startActivity(i);
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MoTaiKhoanTietKiemActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        Motktk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MoTaiKhoanTietKiemActivity.this,ThongBaoThanhCongTaiTucActivity.class);
                startActivity(i);
            }
        });

    }
    void ShowData(double rs){
        TienLai.setText(String.valueOf(rs));
    }
    void Sodukhadung(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            Sodukhadung.setText(model.getTien());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    public void Tien1() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            String sotien1 = SoTien.getText().toString();
                            String lai="6%";
                            text1.setText("6%");
                            String tentktk=Datten.getText().toString().trim();
                            double valuetien = Double.parseDouble(sotien1);
                            String sotien2=String.valueOf(valuetien);
                            double tienlai = valuetien * 0.06;
                            double tienchinh = Double.parseDouble(model.getTien());
                            double tienchinh1 = tienchinh + tienlai;
                            String tienchinh2 = String.valueOf(tienchinh1);
                            ShowData(tienlai);
                            LocalDate date = LocalDate.now();
                            Ngaymotk.setText(date.toString());
                            Ngayhethan.setText(date.plusMonths(1).toString());
                            TongSoTien.setText(tienchinh2);
                            do{
                                HashMap<String,Object> map=new HashMap<>();
                                Double tien12=Double.parseDouble(model.getTien());
                                Double tien13=valuetien;
                                tien12-=tien13;
                                String tong2=String.valueOf(tien12);
                                map.put("naptien",sotien2);
                                map.put("tien",tong2);
                                map.put("soluongtktk","0");
                                map.put("ngaymoso",date.toString());
                                map.put("ngayketso",date.plusMonths(1).toString());
                                map.put("email",model1.email);
                                map.put("nhapsothe",model1.getNhapsothe());
                                map.put("hotenchuthe",model.getHoten());
                                map.put("sodienthoai",model1.getSodienthoai());
                                map.put("ngaythangnam",model.getNgaythangnam());
                                map.put("id",model1.id);
                                model1.setTien(tong2);
                                map.put("tenTkTk",tentktk);
                                map.put("laisuatnam",lai);
                                map.put("tonglaisuat",tienchinh2);
                                db.collection("MoTaiKhoangTietKiem").document(model1.id).set(map)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){


                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lưu thất bại ", Toast.LENGTH_SHORT).show();
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
                                            }
                                        });

                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });

    }//6
    public void Tien11() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            String sotien1 = SoTien.getText().toString();
                            String lai="6%";
                            text1.setText("6%");
                            String tentktk=Datten.getText().toString().trim();
                            double valuetien = Double.parseDouble(sotien1);
                            String sotien2=String.valueOf(valuetien);
                            double tienlai = valuetien * 0.06;
                            double tienchinh = Double.parseDouble(model.getTien());
                            double tienchinh1 = tienchinh + tienlai;
                            String tienchinh2 = String.valueOf(tienchinh1);
                            ShowData(tienlai);
                            LocalDate date = LocalDate.now();
                            Ngaymotk.setText(date.toString());
                            Ngayhethan.setText(date.plusMonths(3).toString());
                            TongSoTien.setText(tienchinh2);
                            do{
                                HashMap<String,Object> map=new HashMap<>();
                                Double tien12=Double.parseDouble(model.getTien());
                                Double tien13=valuetien;
                                tien12-=tien13;
                                String tong2=String.valueOf(tien12);
                                map.put("naptien",sotien2);
                                map.put("tien",tong2);
                                map.put("soluongtktk","0");
                                map.put("ngaymoso",date.toString());
                                map.put("ngayketso",date.plusMonths(3).toString());
                                map.put("email",model1.email);
                                map.put("nhapsothe",model1.getNhapsothe());
                                map.put("hotenchuthe",model1.getHotenchuthe());
                                map.put("sodienthoai",model1.getSodienthoai());
                                map.put("ngaythangnam",model.getNgaythangnam());
                                map.put("id",model1.id);
                                model1.setTien(tong2);
                                map.put("tenTkTk",tentktk);
                                map.put("laisuatnam",lai);
                                map.put("tonglaisuat",tienchinh2);
                                db.collection("MoTaiKhoangTietKiem").document(model1.id).set(map)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){

                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lưu thất bại ", Toast.LENGTH_SHORT).show();
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
                                            }
                                        });

                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });

    }//6
    public void Tien2() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            String sotien1 = SoTien.getText().toString();
                            String tentktk=Datten.getText().toString().trim();
                            double valuetien = Double.parseDouble(sotien1);
                            String sotien2=String.valueOf(valuetien);
                            String lai="7.9%";
                            double tienlai = valuetien * 0.079;
                            double tienchinh = Double.parseDouble(model.getTien());
                            double tienchinh1 = tienchinh + tienlai;
                            String tienchinh2 = String.valueOf(tienchinh1);
                            ShowData(tienlai);
                            TongSoTien.setText(tienchinh2);
                            LocalDate date = LocalDate.now();
                            Ngaymotk.setText(date.toString());
                            Ngayhethan.setText(date.plusMonths(6).toString());
                            do{
                                HashMap<String,Object> map=new HashMap<>();
                                Double tien12=Double.parseDouble(model.getTien());
                                Double tien13=valuetien;
                                tien12-=tien13;
                                String tong2=String.valueOf(tien12);
                                map.put("naptien",sotien2);
                                map.put("tien",tong2);
                                map.put("soluongtktk","0");
                                map.put("ngaymoso",date.toString());
                                map.put("ngayketso",date.plusMonths(6).toString());
                                map.put("email",model1.email);
                                map.put("nhapsothe",model1.getNhapsothe());
                                map.put("hotenchuthe",model1.getHotenchuthe());
                                map.put("sodienthoai",model1.getSodienthoai());
                                map.put("ngaythangnam",model.getNgaythangnam());
                                map.put("id",model1.id);
                                model1.setTien(tong2);
                                map.put("tenTkTk",tentktk);
                                map.put("laisuatnam",lai);
                                map.put("tonglaisuat",tienchinh2);
                                db.collection("MoTaiKhoangTietKiem").document(model1.id).set(map)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lưu thất bại ", Toast.LENGTH_SHORT).show();
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
                                            }
                                        });

                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }//7.9
    public void Tien3() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            String sotien1 = SoTien.getText().toString();
                            double valuetien = Double.parseDouble(sotien1);
                            String sotien2=String.valueOf(sotien1);
                            double tienlai = valuetien * 0.085;
                            double tienchinh = Double.parseDouble(model.getTien());
                            double tienchinh1 = tienchinh + tienlai;
                            String tienchinh2 = String.valueOf(tienchinh1);
                            ShowData(tienlai);
                            String tentktk=Datten.getText().toString().trim();
                            TongSoTien.setText(tienchinh2);
                            String lai="8.5%";
                            LocalDate date = LocalDate.now();
                            Ngaymotk.setText(date.toString());
                            Ngayhethan.setText(date.plusMonths(12).toString());
                            do{
                                HashMap<String,Object> map=new HashMap<>();
                                Double tien12=Double.parseDouble(model.getTien());
                                Double tien13=valuetien;
                                tien12-=tien13;
                                String tong2=String.valueOf(tien12);
                                map.put("naptien",sotien2);
                                map.put("tien",tong2);
                                map.put("soluongtktk","0");
                                map.put("ngaymoso",date.toString());
                                map.put("ngayketso",date.plusMonths(12).toString());
                                map.put("email",model1.email);
                                map.put("nhapsothe",model1.getNhapsothe());
                                map.put("hotenchuthe",model1.getHotenchuthe());
                                map.put("sodienthoai",model1.getSodienthoai());
                                map.put("ngaythangnam",model.getNgaythangnam());
                                map.put("id",model1.id);
                                model1.setTien(tong2);
                                map.put("tenTkTk",tentktk);
                                map.put("laisuatnam",lai);
                                map.put("tonglaisuat",tienchinh2);
                                db.collection("MoTaiKhoangTietKiem").document(model1.id).set(map)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){

                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lưu thất bại ", Toast.LENGTH_SHORT).show();
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
                                            }
                                        });

                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }//8.5
    public void Tien4() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot snapshot : task.getResult()) {
                            User model = new User(snapshot.getString("id"), snapshot.getString("hoten"), snapshot.getString("hochieu"), snapshot.getString("sodienthoai"), snapshot.getString("nhapmatkhau"), snapshot.getString("ngaythangnam"), snapshot.getString("email"), snapshot.getString("tien")); // Lưu ý phải trùng tên với key trong db
                            list.add(model);
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list1.add(model1);
                            String sotien1 = SoTien.getText().toString();
                            double valuetien = Double.parseDouble(sotien1);
                            double tienlai = valuetien * 0.089;
                            double tienchinh = Double.parseDouble(model.getTien());
                            double tienchinh1 = tienchinh + tienlai;
                            String tienchinh2 = String.valueOf(tienchinh1);
                            String tentktk=Datten.getText().toString().trim();
                            ShowData(tienlai);
                            TongSoTien.setText(tienchinh2);
                            String lai="8.9%";
                            String sotien2=String.valueOf(sotien1);
                            LocalDate date = LocalDate.now();
                            Ngaymotk.setText(date.toString());
                            Ngayhethan.setText(date.plusMonths(18).toString());
                            do{
                                HashMap<String,Object> map=new HashMap<>();
                                Double tien12=Double.parseDouble(model.getTien());
                                Double tien13=valuetien;
                                tien12-=tien13;
                                String tong2=String.valueOf(tien12);
                                map.put("naptien",sotien2);
                                map.put("tien",tong2);
                                map.put("soluongtktk","0");
                                map.put("ngaymoso",date.toString());
                                map.put("ngayketso",date.plusMonths(18).toString());
                                map.put("email",model1.email);
                                map.put("nhapsothe",model1.getNhapsothe());
                                map.put("hotenchuthe",model1.getHotenchuthe());
                                map.put("sodienthoai",model1.getSodienthoai());
                                map.put("ngaythangnam",model.getNgaythangnam());
                                map.put("id",model1.id);
                                model1.setTien(tong2);
                                map.put("tenTkTk",tentktk);
                                map.put("laisuatnam",lai);
                                map.put("tonglaisuat",tienchinh2);
                                db.collection("MoTaiKhoangTietKiem").document(model1.id).set(map)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                }
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lưu thất bại ", Toast.LENGTH_SHORT).show();
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
                                            }
                                        });
                            }while (user.getEmail()==model.getEmail());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MoTaiKhoanTietKiemActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }//8.9
}