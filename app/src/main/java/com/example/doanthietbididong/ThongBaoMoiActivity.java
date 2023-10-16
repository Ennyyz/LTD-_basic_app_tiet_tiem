package com.example.doanthietbididong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoMoiActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<Money> list;
    private List<User>list1;
    private List<Model> list2;
    private MoneyAdapter adapter;
    private UserAdapter adapter1;
    private ThongBaoMoiAdapter adapter2;
    private NapTienActivity activity;
    TextView title,description;
    ImageButton account12;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchList;
    String[] NotiList = new String[]{"WARNING! Cảnh giác với hình thức lừa đảo", "⏰GIỜ VÀNG SĂN DEAL, ‘TÁO’ XỊN GIẢM SỐC TỚI 3 TRIỆU KHI MUA SẮM VNSHOP TRÊN SKY", "Làm sổ tiết kiệm cần gì? Cách mở sổ online 2023 & Kinh nghiệm gửi tiết kiệm sinh lời nhiều nhất", "ƯU ĐÃI CHO KHÁCH HÀNG VIP",
            "Liên kết SKY trên ví VNPAY"};

    String[] NotiDesc = new String[]{"Kính gửi: Quý Khách hàng!" +
            "\nTrong dịp lễ 30/4 - 1/5, SKY khuyến cáo Quý khách cảnh giác với các hình thức lừa đảo thông qua:\n" +
            "\n" +
            "-\tTin nhắn mạo danh SKY\n" +
            "-\tCuộc gọi giả mạo người thân, cán bộ ngân hàng hay cơ quan chức năng...\n" +
            "\n" +
            "Quý khách TUYỆT ĐỐI KHÔNG cung cấp thông tin cá nhân (tên truy cập, mật khẩu, OTP…) cho bất cứ ai, qua bất cứ hình thức nào.",
            "\uD83D\uDD25Duy nhất GIỜ VÀNG 12H | Các ngày 04, 05 & 06/05/2023 | Deal “Táo” GIẢM SỐC NGAY 03 TRIỆU khi áp dụng mã ưu đãi thành công.\n" +
                    "\n" +
                    "\uD83D\uDCCDNgày 04/05: Mã \uD835\uDC03\uD835\uDC04\uD835\uDC00\uD835\uDC0B\uD835\uDC12\uD835\uDC0E\uD835\uDC02\uD835\uDFD1\uD835\uDC13\uD835\uDFCF cho \uD835\uDC22\uD835\uDC0F\uD835\uDC1A\uD835\uDC1D \uD835\uDC0F\uD835\uDC2B\uD835\uDC28 \uD835\uDFCF\uD835\uDFCF \uD835\uDC22\uD835\uDC27\uD835\uDC1C\uD835\uDC21 \uD835\uDC0C\uD835\uDFD0 \uD835\uDC16\uD835\uDC22\uD835\uDC1F\uD835\uDC22 giảm chỉ còn 18.290.000 VND.\n" +
                    "\uD83D\uDCCDNgày 05/05: \n" +
                    "- Mã \uD835\uDC03\uD835\uDC04\uD835\uDC00\uD835\uDC0B\uD835\uDC12\uD835\uDC0E\uD835\uDC02\uD835\uDFD1\uD835\uDC13\uD835\uDFD0 cho \uD835\uDC22\uD835\uDC0F\uD835\uDC21\uD835\uDC28\uD835\uDC27\uD835\uDC1E \uD835\uDFCF\uD835\uDFD2 \uD835\uDC0F\uD835\uDC2B\uD835\uDC28 \uD835\uDC0C\uD835\uDC1A\uD835\uDC31 \uD835\uDFD0\uD835\uDFD3\uD835\uDFD4 \uD835\uDC06\uD835\uDC01 giảm còn 27.490.000 VND.\n" +
                    "- Mã \uD835\uDC03\uD835\uDC04\uD835\uDC00\uD835\uDC0B\uD835\uDC12\uD835\uDC0E\uD835\uDC02\uD835\uDFD1\uD835\uDC13\uD835\uDFD1 cho \uD835\uDC22\uD835\uDC0F\uD835\uDC21\uD835\uDC28\uD835\uDC27\uD835\uDC1E \uD835\uDFCF\uD835\uDFD2 \uD835\uDC0F\uD835\uDC2B\uD835\uDC28 \uD835\uDC0C\uD835\uDC1A\uD835\uDC31 \uD835\uDFCF\uD835\uDFD0\uD835\uDFD6 \uD835\uDC06\uD835\uDC01 giảm còn 24.790.000 VND.\n" +
                    "\uD83D\uDCCDNgày 06/05: Mã \uD835\uDC03\uD835\uDC04\uD835\uDC00\uD835\uDC0B\uD835\uDC12\uD835\uDC0E\uD835\uDC02\uD835\uDFD1\uD835\uDC13\uD835\uDFD2 cho \uD835\uDC0B\uD835\uDC1A\uD835\uDC29\uD835\uDC2D\uD835\uDC28\uD835\uDC29 \uD835\uDC00\uD835\uDC29\uD835\uDC29\uD835\uDC25\uD835\uDC1E \uD835\uDC0C\uD835\uDC1A\uD835\uDC1C\uD835\uDC01\uD835\uDC28\uD835\uDC28\uD835\uDC24 \uD835\uDC00\uD835\uDC22\uD835\uDC2B \uD835\uDC0C\uD835\uDFD0 giảm còn 25.890.000 VND.\n" +
                    "\n" +
                    "\uD83D\uDD25Từ 04 – 14/05/2023:\n" +
                    "⚡️Chọn mã \uD835\uDC15\uD835\uDC0D\uD835\uDC12\uD835\uDC07\uD835\uDC0E\uD835\uDC0F\uD835\uDFD3\uD835\uDFD3: Giảm ngay 55.000 VND cho đơn từ 300.000 VND\n" +
                    "⚡️Chọn mã \uD835\uDC15\uD835\uDC0D\uD835\uDC12\uD835\uDC07\uD835\uDC0E\uD835\uDC0F\uD835\uDFD3\uD835\uDFD3\uD835\uDFD3: Giảm ngay 555.000 VND cho đơn từ 3.000.000 VND\n" +
                    "⚡️Duy nhất 05/05 | FREESHIP 20.000VND cho đơn từ 200.000 VND\n" +
                    "\n" +
                    "Lưu ý: Mỗi mã khuyến mại khách hàng được sử dụng tối đa 01 lần trong suốt thời gian diễn ra chương trình.",
            "Bạn đang có một số tiền “nhàn rỗi” muốn đầu tư?\nHoặc đơn giản bạn muốn gửi tiết kiệm hàng tháng tích lũy cho những trường hợp cần thiết.\n Vậy giải pháp an toàn và ổn cho bạn là mở sổ tiết kiệm tại ngân hàng. Tuy nhiên, nếu bạn vẫn quan ngại về thủ tục, lãi suất, kỳ hạn và cách tất toán như thế nào?\n Sau đây, ngân hàng số Timo sẽ chia sẻ 7 điều cần biết khi làm sổ tiết kiệm giúp bạn gửi tiền tiết kiệm ngân hàng đúng cách, hiệu quả. Xem ngay nhé!",
            "\uD83C\uDFB6 ƯU ĐÃI ĐẶC QUYỀN KHÁCH SẠN/RESORT CÙNG SKY\n" +
                    "\n" +
                    "\uD83D\uDDFA Tận hưởng giá trị vượt trội tại hơn 900 khách sạn và resort trên toàn thế giới\n" +
                    "\n" +
                    "\uD83C\uDFC4  Cung cấp 7 lợi ích cao cấp trong bộ sưu tập khách sạn sang trọng của Visa\n" +
                    "- Đảm bảo giá phòng tốt nhất\n" +
                    "- Tự động nâng hạng phòng khi đến/khi có phòng\n" +
                    "- Wifi miễn phí trong phòng (nếu có)\n" +
                    "- Bữa sáng miễn phí hàng ngày\n" +
                    "- Quà tặng đồ ăn, uống trị giá $25\n" +
                    "- Trạng thái Khách VIP\n" +
                    "- Trả phòng lúc 15h00 theo yêu cầu (nếu có)\n" +
                    "\uD83D\uDCBB Kênh đặt phòng:\n" +
                    "Đặt phòng khách sạn trực tuyến tại https://www.visaluxuryhotels.com hoặc gọi Visa Concierge\n" +
                    "Thời gian chương trình: Từ nay đến ngày 31/12/2023",
            "Vì Deal 500K mà đến. Liên kết Ví VNPAY ngay \nMua sắm tẹt ga, di chuyển không lo giá khi Đăng ký Ví VNPAY, Định danh thông tin, Liên kết sổ tiết kiệm SKY. Nhận ngay:\n Gói Voucher 200.000 VND di chuyển.\n Gói Voucher 150.000 VND giải trí, đa năng.\n Gói Voucher 150.000 VND mua sắm, thanh toán.\n\n Thời gian: Từ nay đến ngày 31/05/2023\n Hotline: 0396524827 \n Mở Ví VNPAY liên kết SKY ngay: https://vidientuvnpay.vnpay.vn/lien-ket-SKY",
            };

    int[] imgList = new int[]{R.drawable.canhbaoluadao, R.drawable.sandeal, R.drawable.lamsotietkiemcangi, R.drawable.uudaikhachhang, R.drawable.lienketvivnpay};

    private ThongTinCaNhanActivity activity4;
    private ThongBaoMoiActivity activity3;
    private ChuyenTienActivity activity2;
    private  MainActivity activity1;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao_moi);

        // Ánh xạ
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        account12=findViewById(R.id.account12);

        db = FirebaseFirestore.getInstance(); // Khai báo database cloud fs
        list = new ArrayList<>(); // Khai báo mảng list
        list1 = new ArrayList<>(); // Khai báo mảng list
        list2 = new ArrayList<>(); // Khai báo mảng list
        adapter = new MoneyAdapter(activity, list,activity1,activity2,this,activity4,activity5,activity6,activity7,activity8);
        adapter1 = new UserAdapter(activity, list1,activity1,activity2,this,activity4,activity5,activity6,activity7);
        adapter2 = new ThongBaoMoiAdapter(list2, activity,activity1,activity2,this,activity4,activity5,activity6,activity7,list,activity8);
        searchView = findViewById(R.id.searchView);
        recyclerView.setAdapter(adapter2);
        title=findViewById(R.id.title_text);
        description=findViewById(R.id.desc_text);
account12.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(ThongBaoMoiActivity.this,MainActivity.class);
        startActivity(i);
    }
});
        for (int i = 0; i < NotiList.length; i++) {
            ModelClass modelClass = new ModelClass();
            modelClass.setNotiName(NotiList[i]);
            modelClass.setNotiNum(NotiDesc[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThongBaoMoiActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        NotificationAdapter notificationAdapter = new NotificationAdapter(ThongBaoMoiActivity.this, arrayList);
        recyclerView.setAdapter(notificationAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();

                if(query.length() > 0){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(arrayList.get(i).getNotiName().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setNotiName(arrayList.get(i).getNotiName());
                            modelClass.setNotiNum(arrayList.get(i).getNotiNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);

                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThongBaoMoiActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    NotificationAdapter notificationAdapter = new NotificationAdapter(ThongBaoMoiActivity.this, searchList);
                    recyclerView.setAdapter(notificationAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThongBaoMoiActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    NotificationAdapter notificationAdapter = new NotificationAdapter(ThongBaoMoiActivity.this, arrayList);
                    recyclerView.setAdapter(notificationAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();

                if(newText.length() > 0){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(arrayList.get(i).getNotiName().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setNotiName(arrayList.get(i).getNotiName());
                            modelClass.setNotiNum(arrayList.get(i).getNotiNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);

                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThongBaoMoiActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    NotificationAdapter notificationAdapter = new NotificationAdapter(ThongBaoMoiActivity.this, searchList);
                    recyclerView.setAdapter(notificationAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThongBaoMoiActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    NotificationAdapter notificationAdapter = new NotificationAdapter(ThongBaoMoiActivity.this, arrayList);
                    recyclerView.setAdapter(notificationAdapter);
                }
                return false;
            }
        });

        /*ItemTouchHelper touchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView);*/
        /*showData();*/
    }

   /* private void showData() {
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Model model = new Model(snapshot.getString("id"), snapshot.getString("title"), snapshot.getString("desc")); // Lưu ý phải trùng tên với key trong db
                            list2.add(model);
                            *//*Model model2 = new Model(snapshot.getString("id"), snapshot.getString("title"),snapshot.getString("desc"));
                            list2.add(model2);*//*
     *//*       title.setText("Nạp tiền thành công");
                               description.setText(model.getDesc());*//*


                        }
                        adapter2.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ThongBaoMoiActivity.this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                });
    }*/
}