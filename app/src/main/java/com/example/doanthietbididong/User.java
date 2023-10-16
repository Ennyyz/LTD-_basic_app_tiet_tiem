package com.example.doanthietbididong;

import java.io.Serializable;

public class User {
   String id;
    String hoten;
    String hochieu;
    String sodienthoai;
    String nhapmatkhau;
    String ngaythangnam;
    String email;
    String tien;


 public User(){
 }
    public User(String id, String hoten, String hochieu, String sodienthoai, String nhapmatkhau, String ngaythangnam, String email,String tien) {
        this.id = id;
        this.hoten = hoten;
        this.hochieu = hochieu;
        this.sodienthoai = sodienthoai;
        this.nhapmatkhau = nhapmatkhau;
        this.ngaythangnam = ngaythangnam;
        this.email = email;
        this.tien=tien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getHochieu() {
        return hochieu;
    }

    public void setHochieu(String hochieu) {
        this.hochieu = hochieu;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getNhapmatkhau() {
        return nhapmatkhau;
    }

    public void setNhapmatkhau(String nhapmatkhau) {
        this.nhapmatkhau = nhapmatkhau;
    }

    public String getNgaythangnam() {
        return ngaythangnam;
    }

    public void setNgaythangnam(String ngaythangnam) {
        this.ngaythangnam = ngaythangnam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTien() {
        return tien;
    }
    public void setTien(String tien) {
        this.tien = tien;
    }

}
