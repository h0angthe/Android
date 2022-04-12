package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
//        String sql = " ALTER TABLE TaiKhoan ADD QuyenHan nvarchar(20)";
//        database.execSQL(sql);
//        database.execSQL("Update TaiKhoan Set QuyenHan = 'admin' where MaNV = 'NV01'");
//        database.execSQL("Update TaiKhoan Set QuyenHan = 'admin' where MaNV = 'NV02'");
//        database.execSQL("Update TaiKhoan Set QuyenHan = 'nhanvien' where MaNV = 'NV03'");
//        database.execSQL("Update TaiKhoan Set QuyenHan = 'nhanvien' where MaNV = 'NV04'");
//        database.execSQL("Update TaiKhoan Set QuyenHan = 'nhanvien' where MaNV = 'NV05'");
//        Toast.makeText(Home.this,"Thêm thành công ",Toast.LENGTH_SHORT).show();
    }
}