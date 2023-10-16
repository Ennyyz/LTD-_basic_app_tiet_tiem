package com.example.doanthietbididong;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private TKTKTaiTucActivity activity;
    private KhiChonKhongCamOnActivity khichonkhongcamon;
    private List<Money> mList;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MyAdapter(TKTKTaiTucActivity activity, List<Money> mList,KhiChonKhongCamOnActivity khichonkhongcamon) {
        this.activity = activity;
        this.mList = mList;
        this.khichonkhongcamon = khichonkhongcamon;
    }
    public void deleteData(int position) {
        Money item = mList.get(position);
        db.collection("MoTaiKhoangTietKiem").document(item.getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            notifyRemove(position);
                            Toast.makeText(khichonkhongcamon, "xóa thành công", Toast.LENGTH_SHORT).show();
                            Double tien3= Double.parseDouble(item.getTien())+Double.parseDouble(item.getNaptien());
                            String tientong=String.valueOf(tien3);
                            db.collection("Documents").document(item.getId()).update("tien",tientong)
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
                        } else {
                            Toast.makeText(khichonkhongcamon, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Hàm cảnh báo trước khi xóa
    private void notifyRemove(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        /* activity.showData();*/
        khichonkhongcamon.showData();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(khichonkhongcamon).inflate(R.layout.itemdanhsachtktkthemxoasua, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TienNapVao.setText(mList.get(position).getNaptien());
        holder.NgayThangNam.setText((mList.get(position).getNgayketso()));
        holder.LaiSuat.setText(mList.get(position).getLaisuatnam());
        holder.ivDelete.setOnClickListener(v -> deleteData(position));
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView TienNapVao, NgayThangNam, LaiSuat;
        ImageView ivEdit, ivDelete;
        public MyViewHolder(@NonNull View   itemView) {
            super(itemView);
            // Ánh Xạ
            TienNapVao = itemView.findViewById(R.id.TienNap);
            NgayThangNam = itemView.findViewById(R.id.ngayhethanitem);
            LaiSuat = itemView.findViewById(R.id.LaiSuat);
            ivDelete = itemView.findViewById(R.id.xoa);
        }
    }
}