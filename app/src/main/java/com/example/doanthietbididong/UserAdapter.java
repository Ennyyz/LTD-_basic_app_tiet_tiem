package com.example.doanthietbididong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {
    private NapTienActivity activity;
    private ThongTinCaNhanActivity activity4;
    private ThongBaoMoiActivity activity3;
    private ChuyenTienActivity activity2;
    private  MainActivity activity1;
    private ChartActivity activity5;
    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private List<User>list1;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    public  UserAdapter(NapTienActivity activity,List<User>list1,MainActivity activity1,ChuyenTienActivity activity2,ThongBaoMoiActivity activity3,ThongTinCaNhanActivity activity4,ChartActivity activity5,ItemSanPhamActivity activity6,MoTaiKhoanTietKiemActivity activity7)
    {
        this.activity=activity;
        this.list1=list1;
        this.activity1=activity1;
        this.activity2=activity2;
        this.activity3=activity3;
        this.activity4=activity4;
        this.activity5=activity5;
        this.activity6=activity6;
        this.activity7=activity7;

    }


}
