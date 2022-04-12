package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SuaThongTinNV extends AppCompatActivity {
    SQLiteDatabase database;
    EditText ed_manv, ed_tennv,ed_chucvu,ed_ngaysinh,ed_quequan,ed_phongban;
    Button button_suanv, button_quaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin_nv);
        database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String MaNV = bundle.getString("manv");
        String TenNV = bundle.getString("tennv");
        String ChucVu = bundle.getString("chucvu");
        String Ngaysinh = bundle.getString("ngaysinh");
        String Quequan = bundle.getString("quequan");
        String MaPhongBan =bundle.getString("maphongban");
        String TenPhongBan = bundle.getString("tenphongban");
        ed_manv = findViewById(R.id.ed_manv);
        ed_tennv = findViewById(R.id.ed_tennv);
        ed_chucvu = findViewById(R.id.ed_chucvu);
        ed_ngaysinh = findViewById(R.id.ed_ngaysinh);
        ed_quequan = findViewById(R.id.ed_quequan);
        ed_phongban = findViewById(R.id.ed_phongban);
        button_suanv = findViewById(R.id.button_suaNV);
        button_quaylai = findViewById(R.id.button_thoatsuaNV);
        ed_manv.setText(MaNV);
        ed_tennv.setText(TenNV);
        ed_chucvu.setText(ChucVu);
        ed_ngaysinh.setText(Ngaysinh);
        ed_quequan.setText(Quequan);
        ed_phongban.setText(MaPhongBan);

        button_suanv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String manv = ed_manv.getText().toString();
                String tennv = ed_tennv.getText().toString();
                String chucvu = ed_chucvu.getText().toString();
                String ngaysinh = ed_ngaysinh.getText().toString();
                String quequan = ed_quequan.getText().toString();
                String phongban = ed_phongban.getText().toString();
                String sql ="Update NhanVien set TenNV = '"+tennv+"',ChucVu = '"+chucvu+"',Ngaysinh = '"+ngaysinh+"',Quequan = '"+quequan+"',MaPhongBan ='"+phongban+"' where MaNV = '"+manv+"'";
                database.execSQL(sql);
                Toast.makeText(SuaThongTinNV.this,"Bạn đã sửa thông tin nhân viên thành công !",Toast.LENGTH_SHORT).show();
            }
        });
        button_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}