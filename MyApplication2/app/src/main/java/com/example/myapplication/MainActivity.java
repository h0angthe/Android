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

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    Button b1,b2;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= findViewById(R.id.bt_dangnhap);
        b2 = findViewById(R.id.bt_test);
        ed1 = findViewById(R.id.edT_taikhoan);
        ed2 = findViewById(R.id.edT_matkhau);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openOrCreateDatabase("QLNhanVien.db", MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("select * from TaiKhoan", null);
                if (ed1.getText().length()== 0 || ed2.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                while(!cursor.isLast()) {
                    cursor.moveToNext();
                    String taikhoan = cursor.getString(1);
                    String matkhau = cursor.getString(2);
                    String quyenhan = cursor.getString(3);
                    if (ed1.getText().toString().equals(taikhoan) && ed2.getText().toString().equals(matkhau)) {
                        if(quyenhan.equals("admin")){
                            Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, PhongBan.class);
                            startActivity(intent);
                            return;
                        }else {
                            Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Home.class);
                            startActivity(intent);
                            return;
                        }

                    }
                }
                    Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Home.class);
                startActivity(intent);
            }
        });
    }
}