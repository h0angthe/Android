package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterNV extends BaseAdapter {
    Context context;
    int layout;
    List<NhanVien> list;

    public AdapterNV(Context context, int layout, List<NhanVien> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);
        NhanVien dbNV = list.get(i);
        TextView tv1 = view.findViewById(R.id.tv_tenNV);
        TextView tv2 = view.findViewById(R.id.tv_chucvu);
        tv1.setText(dbNV.getTenNV());
        tv2.setText(dbNV.getChucVu());
        return view ;
    }
}
