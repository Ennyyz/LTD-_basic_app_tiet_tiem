package com.example.doanthietbididong;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MoneyAdapter {
    private NapTienActivity activity;
    private MainActivity activity1;
    private ChuyenTienActivity activity2;
    private ThongBaoMoiActivity activity3;
    private ThongTinCaNhanActivity activity4;
    private ChartActivity activity5;

    private ItemSanPhamActivity activity6;
    private MoTaiKhoanTietKiemActivity activity7;
    private LichSuGIaoDichActivity activity8;
    private List<Money>list;
    private FirebaseFirestore db= FirebaseFirestore.getInstance();
    public MoneyAdapter(NapTienActivity activity,List<Money>list,MainActivity activity1,ChuyenTienActivity activity2,ThongBaoMoiActivity activity3,ThongTinCaNhanActivity activity4, ChartActivity activity5, ItemSanPhamActivity activity6, MoTaiKhoanTietKiemActivity activity7,LichSuGIaoDichActivity activity8)
    {
        this.activity=activity;
        this.list=list;
        this.activity1=activity1;
        this.activity2=activity2;
        this.activity3=activity3;
        this.activity4=activity4;
        this.activity5=activity5;
        this.activity6=activity6;
        this.activity7=activity7;
        this.activity8=activity8;

    }
}
