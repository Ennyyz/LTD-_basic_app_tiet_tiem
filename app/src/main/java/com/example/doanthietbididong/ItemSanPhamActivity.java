package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class ItemSanPhamActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private ThongBaoMoiAdapter adapter2;
    private MoneyAdapter adapter;
    private List<Money> list;
    private List<User>list1;
    private List<Model> list2;

    private NapTienActivity activity;
    private ThongTinCaNhanActivity activity4;
    private ThongBaoMoiActivity activity3;
    private ChuyenTienActivity activity2;
    private  MainActivity activity1;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;

    TextView title,description;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_san_pham);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs

        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>(); // Khai báo mảng list
        list2 = new ArrayList<>(); // Khai báo mảng list

        adapter = new MoneyAdapter(activity, list,activity1,activity2,activity3,activity4,activity5,activity6,activity7,activity8);
        adapter2 = new ThongBaoMoiAdapter(list2, activity,activity1,activity2,activity3,activity4,activity5, this,activity7,list,activity8);

        searchView = findViewById(R.id.searchView);
        recyclerView.setAdapter(adapter2);
        title=findViewById(R.id.title_text);
        description=findViewById(R.id.desc_text);
        title.setText("Nạp thành công");
        showData();
    }
    private void showData() {
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Model model = new Model(snapshot.getString("id"), snapshot.getString("title"), snapshot.getString("desc")); // Lưu ý phải trùng tên với key trong db
                            list2.add(model);
                            /*Model model2 = new Model(snapshot.getString("id"), snapshot.getString("title"),snapshot.getString("desc"));
                            list2.add(model2);*/
                            title.setText("Nạp tiền thành công");
                            description.setText(model.getDesc());
                        }
                        adapter2.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ItemSanPhamActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}