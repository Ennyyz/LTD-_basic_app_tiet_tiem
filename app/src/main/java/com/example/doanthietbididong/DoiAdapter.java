package com.example.doanthietbididong;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class DoiAdapter {
    private DoiSoDienThoaiActivity activity1;
    private DoiNgayThangNamActivity activity2;
    private  DoiHoChieuActivity activity3;
    private List<Money> moneyList;
    private List<User> userList;
    private FirebaseFirestore db= FirebaseFirestore.getInstance();
    public DoiAdapter(DoiSoDienThoaiActivity activity1,List<Money>moneyList,List<User>userList,DoiNgayThangNamActivity activity2,DoiHoChieuActivity activity3){
        this.activity1=activity1;
        this.moneyList=moneyList;
        this.userList=userList;
        this.activity2=activity2;
        this.activity3=activity3;
    }
}
