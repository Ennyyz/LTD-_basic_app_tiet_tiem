package com.example.doanthietbididong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ThongBaoMoiAdapter extends RecyclerView.Adapter<ThongBaoMoiAdapter.MyViewHolder> {


    private NapTienActivity activity;
    private MainActivity activity1;
    private ChuyenTienActivity activity2;
    private ThongBaoMoiActivity activity3;
    private ThongTinCaNhanActivity activity4;
    private ChartActivity activity5;

    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
    private List<Model> list2;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Money>list3;
    private NapTien1Activity activity11;
    public ThongBaoMoiAdapter(List<Model> list2,NapTienActivity activity, MainActivity activity1,ChuyenTienActivity activity2,ThongBaoMoiActivity activity3,ThongTinCaNhanActivity activity4, ChartActivity activity5, ItemSanPhamActivity activity6, MoTaiKhoanTietKiemActivity activity7,List<Money>list3,LichSuGIaoDichActivity activity8) {

        this.list2 = list2;
        this.activity=activity;
        this.activity1 = activity1;
        this.activity2=activity2;
        this.activity3 = activity3;
        this.activity4 = activity4;
        this.activity5 = activity5;
        this.activity6 = activity6;
        this.activity7 = activity7;
        this.list3=list3;
        this.activity8 = activity8;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity11).inflate(R.layout.activity_item_san_pham, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongBaoMoiAdapter.MyViewHolder holder, int position) {
        db.collection("GiaoDich").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list3.add(model1);
                            db.collection("GiaoDich").whereEqualTo("naptien",model1.naptien!=null).get()
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            for (DocumentSnapshot snapshot : task.getResult()) {
                                                Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                                                list3.add(model1);
                                                holder.title.setText(model1.getSoluongtktk());
                                                holder.desc.setText(model1.getNaptien());
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                        }
                                    });
                            db.collection("GiaoDich").whereEqualTo("chuyentien",model1.chuyentien!=null).get()
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            for (DocumentSnapshot snapshot : task.getResult()) {
                                                Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                                                list3.add(model1);
                                                holder.title.setText(model1.getSoluongtktk());
                                                holder.desc.setText(model1.getNaptien());
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                                        @Override
                                        public void onFailure(@NonNull Exception e) {

                                        }
                                    });
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
        db.collection("GiaoDich").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list3.add(model1);
                            if (model1.soluongtktk=="Rút Tiền Thành Công") {
                                holder.title.setText("Chuyển Tiền Thành Công");
                                holder.desc.setText((model1.naptien));
                            }
                            else  {
                                holder.title.setText("Nạp Tiền Thành Công");
                                holder.desc.setText((model1.chuyentien));
                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // Lấy data không thành công
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc;
        ImageView coin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Ánh Xạ
            title = itemView.findViewById(R.id.title_text);
            desc = itemView.findViewById(R.id.desc_text);
            coin = itemView.findViewById(R.id.ivCoin);
        }
    }
}
