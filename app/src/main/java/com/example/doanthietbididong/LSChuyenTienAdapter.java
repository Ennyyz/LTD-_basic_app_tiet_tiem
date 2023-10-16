package com.example.doanthietbididong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class LSChuyenTienAdapter extends RecyclerView.Adapter<LSChuyenTienAdapter.MyViewHolder> {

    private LichSuChuyenTienActivity activity10;
    private List<Money> list5;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public LSChuyenTienAdapter(LichSuChuyenTienActivity activity10, List<Money> list5){
        this.activity10 = activity10;
        this.list5 = list5;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity10).inflate(R.layout.activity_item_ls_chuyen_tien, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("RutTien").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list5.add(model1);
                                holder.title1.setText("Chuyển tiền thành công");
                                holder.desc1.setText((model1.getChuyentien()));
                                holder.time.setText(model1.getNgaymoso());

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
        return list5.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title1, desc1, time;


        public MyViewHolder(@NonNull View   itemView) {
            super(itemView);

            // Ánh Xạ
            title1 = itemView.findViewById(R.id.title_text2);
            desc1 = itemView.findViewById(R.id.desc_text2);
            time = itemView.findViewById(R.id.timechuyentien);
        }
    }
}
