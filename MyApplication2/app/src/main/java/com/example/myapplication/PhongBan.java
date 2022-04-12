package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PhongBan extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase database;
    ArrayList<PB> listPB = new ArrayList<>();
    AdapterPB adapterPB;
    Button button_themnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);
        listView = findViewById(R.id.lv_phongban);
        database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("Select * from PhongBan",null);
        while (!cursor.isLast()){
            cursor.moveToNext();
            String maPhongBan = cursor.getString(0);
            String tenPhongBan = cursor.getString(1);
            PB pb = new PB(maPhongBan,tenPhongBan);
            listPB.add(pb);
        }
        adapterPB = new AdapterPB(this,R.layout.listview_pb,listPB);
        listView.setAdapter(adapterPB);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PhongBan.this,DSNhanVien.class);
                Bundle bundle = new Bundle();
                bundle.putString("MaPhongBan",listPB.get(i).maPhongBan);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        button_themnv = findViewById(R.id.bt_themNV);
        button_themnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhongBan.this,ThemNhanVien.class);
                startActivity(intent);
            }
        });
    }
}