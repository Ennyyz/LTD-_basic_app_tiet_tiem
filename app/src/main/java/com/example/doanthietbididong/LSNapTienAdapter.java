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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class LSNapTienAdapter extends RecyclerView.Adapter<LSNapTienAdapter.MyViewHolder> {

    private LichSuNapTienActivity activity9;
    private List<Money> list4;


    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public LSNapTienAdapter(LichSuNapTienActivity activity9, List<Money> list4){
        this.activity9 = activity9;
        this.list4 = list4;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity9).inflate(R.layout.activity_item_ls_nap_tien, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("NapTien").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() { // sự kiện get data thành công
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            Money model1 = new Money(snapshot.getString("naptien"), snapshot.getString("tien"), snapshot.getString("chuyentien"), snapshot.getString("soluongtktk"), snapshot.getString("ngaymoso"), snapshot.getString("ngayketso"), snapshot.getString("email"), snapshot.getString("nhapsothe"), snapshot.getString("hotenchuthe"), snapshot.getString("id"), snapshot.getString("ngaythangnam"), snapshot.getString("sodienthoai"), snapshot.getString("tenTkTk"), snapshot.getString("kyhan"),snapshot.getString("laisuatnam"),snapshot.getString("tonglaisuat")); // Lưu ý phải trùng tên với key trong db
                            list4.add(model1);
                                holder.title.setText("Nạp tiền thành công");
                                holder.desc.setText((model1.getNaptien()));
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
        return list4.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, time;


        public MyViewHolder(@NonNull View   itemView) {
            super(itemView);

            // Ánh Xạ
            title = itemView.findViewById(R.id.title_text1);
            desc = itemView.findViewById(R.id.desc_text1);
            time = itemView.findViewById(R.id.timenaptien);
        }
    }
}
