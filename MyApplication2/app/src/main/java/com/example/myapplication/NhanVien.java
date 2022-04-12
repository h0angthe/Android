package com.example.myapplication;

public class NhanVien {
    String MaNV, TenNV, ChucVu, Ngaysinh, Quequan, MaPhongBan;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String chucVu, String ngaysinh, String quequan, String maPhongBan) {
        MaNV = maNV;
        TenNV = tenNV;
        ChucVu = chucVu;
        Ngaysinh = ngaysinh;
        Quequan = quequan;
        MaPhongBan = maPhongBan;
    }
    //get
    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public String getQuequan() {
        return Quequan;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    //set
    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public void setNgaysinh(String ngaysinh) {
        Ngaysinh = ngaysinh;
    }

    public void setQuequan(String quequan) {
        Quequan = quequan;
    }

    public void setMaPhongBan(String maPhongBan) {
        MaPhongBan = maPhongBan;
    }
}
