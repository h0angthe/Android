package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemNhanVien extends AppCompatActivity {
    Button btthem,bthuy;
    EditText edT_manv,edT_ten,edT_chucvu,edT_ngaysinh,edT_quequan,edT_maphongban;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);
        btthem = findViewById(R.id.bt_them);
        bthuy = findViewById(R.id.bt_huythem);
        edT_manv = findViewById(R.id.edT_MaNV);
        edT_ten = findViewById(R.id.edT_HovaTen);
        edT_chucvu = findViewById(R.id.edT_chucvu);
        edT_ngaysinh= findViewById(R.id.edT_Ngaysinh);
        edT_quequan = findViewById(R.id.edT_quequan);
        edT_maphongban = findViewById(R.id.edT_maphongban);
        bthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
                if (edT_manv.getText().length()== 0 || edT_ten.getText().length() == 0 || edT_chucvu.getText().length() == 0 || edT_ngaysinh.getText().length() == 0 || edT_quequan.getText().length() == 0 || edT_maphongban.getText().length() == 0) {
                    Toast.makeText(ThemNhanVien.this, "Bạn chưa nhập đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                    return;
                }
                        String maNV = edT_manv.getText().toString();
                        String ten = edT_ten.getText().toString();
                        String chucvu = edT_chucvu.getText().toString();
                        String ngaysinh = edT_ngaysinh.getText().toString();
                        String quequan = edT_quequan.getText().toString();
                        String maphongban = edT_maphongban.getText().toString();
                        String sql = "Insert into NhanVien values ('"+maNV+"','"+ten+"','"+chucvu+"', '"+ngaysinh+"','"+quequan+"','"+maphongban+"')";
                        database.execSQL(sql);
                        Toast.makeText(ThemNhanVien.this,"Bạn đã thêm thành công",Toast.LENGTH_SHORT).show();
                        edT_manv.setText("");
                        edT_ten.setText("");
                        edT_chucvu.setText("");
                        edT_ngaysinh.setText("");
                        edT_quequan.setText("");
                        edT_maphongban.setText("");
                    }
        });
    }
}