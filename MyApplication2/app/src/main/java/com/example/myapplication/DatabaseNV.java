package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class DatabaseNV extends AppCompatActivity {
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_nv);

        database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
        String sql = "Create table if not exists PhongBan(MaPhongBan nvarchar(20) primary key,TenPhongBan nvarchar(50))";
        database.execSQL(sql);
        database.execSQL("create table if not exists NhanVien(MaNV nvarchar(20) primary key,TenNV nvarchar(50),ChucVu nvarchar(50),Ngaysinh date,Quequan nvarchar(20),MaPhongBan nvarchar(20) references PhongBan(MaPhongBan))");
        database.execSQL("create table if not exists TaiKhoan(MaNV nvarchar(20) references NhanVien(MaNV),TaiKhoan nvarchar(50),MatKhau nvarchar(50),QuyenHan nvarchar(20))");
        database.execSQL("create table if not exists SuKien(MaSK nvarchar(20) primary key,TenSK nvarchar(50),Ngaydienra date)");


        database.execSQL("Insert into PhongBan values ('PB01','Nhân sự')");
        database.execSQL("Insert into PhongBan values ('PB02','Kinh doanh')");
        database.execSQL("Insert into PhongBan values ('PB03','Marketting')");
        database.execSQL("Insert into PhongBan values ('PB04','Kế toán')");
        database.execSQL("Insert into PhongBan values ('PB05','Bảo vệ')");

        database.execSQL("Insert into NhanVien values ('NV01','Lê Hoàng Dương','Nhân viên', '2001/08/13','Hà nội','PB01')");
        database.execSQL("Insert into NhanVien values ('NV02','Trần Thanh Nam','Nhân viên', '2001/01/12','Nam Định','PB03')");
        database.execSQL("Insert into NhanVien values ('NV03','Hồ Hiển Vinh','Nhân viên', '2001/09/13','Hà nội','PB02')");
        database.execSQL("Insert into NhanVien values ('NV04','Trần Quốc Toản','Nhân viên', '2001/04/04','Ninh Bình','PB04')");
        database.execSQL("Insert into NhanVien values ('NV05','Nguyễn Xuân Trường','Nhân viên', '2001/11/18','Thái Nguyên','PB05')");

        database.execSQL("Insert into TaiKhoan values ('NV01','leduong','duong01','admin')");
        database.execSQL("Insert into TaiKhoan values ('NV02','namtran','nam123','admin')");
        database.execSQL("Insert into TaiKhoan values ('NV03','vinhho','lake','nhanvien')");
        database.execSQL("Insert into TaiKhoan values ('NV04','toanct','toan01','nhanvien')");
        database.execSQL("Insert into TaiKhoan values ('NV05','xuantruong','98765','nhanvien')");

        database.execSQL("Insert into SuKien values ('SK01','nghỉ lễ','2022/04/30')");
        database.execSQL("Insert into SuKien values ('SK02','Lễ Khai Mạc Dự Án ABC','2022/04/20')");
        database.execSQL("Insert into SuKien values ('SK03','Lễ Bế Mạc Dự Án ABC','2022/08/10')");

    }
}