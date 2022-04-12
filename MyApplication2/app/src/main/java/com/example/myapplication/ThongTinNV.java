package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ThongTinNV extends AppCompatActivity {
    SQLiteDatabase database;
    TextView tv_manv,tv_tennv,tv_chucvu,tv_ngaysinh,tv_quequan,tv_phongban;
    Button btsuaNV,btxoaNV,bthuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_nv);
        database = openOrCreateDatabase("QLNhanVien.db",MODE_PRIVATE,null);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String MaNV = bundle.getString("MaNV");
        String TenNV = bundle.getString("TenNV");
        String ChucVu = bundle.getString("ChucVu");
        String Ngaysinh = bundle.getString("Ngaysinh");
        String Quequan = bundle.getString("QueQuan");
        String MaPhongBan =bundle.getString("MaPhongBan");

        String sql = "select TenPhongBan from PhongBan where MaPhongBan = '"+MaPhongBan+"'";
        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToNext();
        String tenphongban = cursor.getString(0);
        tv_manv = findViewById(R.id.tv_manv);
        tv_tennv = findViewById(R.id.tv_tennv);
        tv_chucvu = findViewById(R.id.tv_ChucVu);
        tv_ngaysinh = findViewById(R.id.tv_Ngaysinh);
        tv_quequan = findViewById(R.id.tv_Quequan);
        tv_phongban = findViewById(R.id.tv_phongban);

        tv_manv.setText(MaNV);
        tv_tennv.setText(TenNV);
        tv_chucvu.setText(ChucVu);
        tv_ngaysinh.setText(Ngaysinh);
        tv_quequan.setText(Quequan);
        tv_phongban.setText(tenphongban);

        bthuy =findViewById(R.id.bt_thoatNV);
        btsuaNV = findViewById(R.id.bt_sua);
        btxoaNV = findViewById(R.id.bt_xoa);

        bthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btsuaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent1 =new Intent(ThongTinNV.this,SuaThongTinNV.class);
            Bundle bundle1 = new Bundle();
            bundle1.putString("manv",MaNV);
            bundle1.putString("tennv",TenNV);
            bundle1.putString("chucvu",ChucVu);
            bundle1.putString("ngaysinh",Ngaysinh);
            bundle1.putString("quequan",Quequan);
            bundle1.putString("maphongban",MaPhongBan);
            bundle1.putString("tenphongban",tenphongban);
            intent1.putExtras(bundle1);
            startActivity(intent1);
            }
        });
        btxoaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder aldialog = new AlertDialog.Builder(ThongTinNV.this);
                aldialog.setMessage("Bạn có muốn xóa nhân viên này? ").setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String sql1 = "Delete from NhanVien where MaNV = '"+MaNV+"'";
                                database.execSQL(sql1);
                                Intent intent1 = new Intent(ThongTinNV.this,DSNhanVien.class);
                                startActivity(intent1);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = aldialog.create();
                alertDialog.setTitle("Xác nhận xóa ");
                alertDialog.show();
            }
        });
    }
}