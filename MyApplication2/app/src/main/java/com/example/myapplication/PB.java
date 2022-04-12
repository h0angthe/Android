package com.example.myapplication;

public class PB {
    String maPhongBan, TenPhongBan;

    public PB() {
    }

    public PB(String maPhongBan, String tenPhongBan) {
        this.maPhongBan = maPhongBan;
        TenPhongBan = tenPhongBan;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return TenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        TenPhongBan = tenPhongBan;
    }
}
