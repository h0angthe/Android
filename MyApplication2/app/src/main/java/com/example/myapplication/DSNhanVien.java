package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DSNhanVien extends AppCompatActivity {

    ImageButton bt_timkiem;
    EditText edT_timkiem;
    SQLiteDatabase database;
    ListView listView;
    ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
    AdapterNV adapterNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsnhan_vien);
        edT_timkiem = findViewById(R.id.edT_timkiem);
        listView = (ListView) findViewById(R.id.listviewNV);
        bt_timkiem = findViewById(R.id.bt_TimKiem);
        database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String maPhongBan = bundle.getString("MaPhongBan");
        String sql = "select * from NhanVien where MaPhongBan = '"+maPhongBan+"'";
        Cursor cursor = database.rawQuery(sql,null);
        while (!cursor.isLast()){
            cursor.moveToNext();
            String maNV = cursor.getString(0);
            String tenNV = cursor.getString(1);
            String Chucvu = cursor.getString(2);
            String Ngaysinh = cursor.getString(3);
            String Quequan = cursor.getString(4);
            String MaPhongBan = cursor.getString(5);
            NhanVien nhanVien = new NhanVien(maNV,tenNV,Chucvu,Ngaysinh, Quequan,MaPhongBan);
            nhanVienArrayList.add(nhanVien);
        }
        adapterNV = new AdapterNV(this,R.layout.listview_nv,nhanVienArrayList);
        listView.setAdapter(adapterNV);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent intent1 = new Intent(DSNhanVien.this,ThongTinNV.class);
            Bundle bundle1 = new Bundle();
            bundle1.putString("MaNV",nhanVienArrayList.get(i).MaNV);
            bundle1.putString("TenNV",nhanVienArrayList.get(i).TenNV);
            bundle1.putString("ChucVu",nhanVienArrayList.get(i).ChucVu);
            bundle1.putString("Ngaysinh",nhanVienArrayList.get(i).Ngaysinh);
            bundle1.putString("QueQuan",nhanVienArrayList.get(i).Quequan);
            bundle1.putString("MaPhongBan",nhanVienArrayList.get(i).MaPhongBan);
            intent1.putExtras(bundle1);
            startActivity(intent1);
            }
        });
        bt_timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timkiem = edT_timkiem.getText().toString();
                String sql1 = "Select * from NhanVien where TenNV like '" + timkiem + "'";
                Cursor cursor1 = database.rawQuery(sql1, null);
                nhanVienArrayList = new ArrayList<>();
                while (!cursor1.isLast()) {
                    cursor1.moveToNext();
                    String maNV = cursor1.getString(0);
                    String tenNV = cursor1.getString(1);
                    String Chucvu = cursor1.getString(2);
                    String Ngaysinh = cursor1.getString(3);
                    String Quequan = cursor1.getString(4);
                    String MaPhongBan = cursor1.getString(5);
                    NhanVien nhanVien = new NhanVien(maNV, tenNV, Chucvu, Ngaysinh, Quequan, MaPhongBan);
                    nhanVienArrayList.add(nhanVien);
                }
                adapterNV = new AdapterNV(DSNhanVien.this, R.layout.listview_nv, nhanVienArrayList);
                listView.setAdapter(adapterNV);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent1 = new Intent(DSNhanVien.this, ThongTinNV.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("MaNV", nhanVienArrayList.get(i).MaNV);
                        bundle1.putString("TenNV", nhanVienArrayList.get(i).TenNV);
                        bundle1.putString("ChucVu", nhanVienArrayList.get(i).ChucVu);
                        bundle1.putString("Ngaysinh", nhanVienArrayList.get(i).Ngaysinh);
                        bundle1.putString("QueQuan", nhanVienArrayList.get(i).Quequan);
                        bundle1.putString("MaPhongBan", nhanVienArrayList.get(i).MaPhongBan);
                        intent1.putExtras(bundle1);
                        startActivity(intent1);
                    }
                });
            }
        });
    }
}