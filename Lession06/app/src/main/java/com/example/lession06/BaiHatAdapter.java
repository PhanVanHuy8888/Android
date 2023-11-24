package com.example.lession06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lession06.Object.BaiHat;

import java.util.List;

public class BaiHatAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<BaiHat> baiHats;
    public BaiHatAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.baiHats = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_lv_baihat, null);
        // Map
        TextView tvTen = convertView.findViewById(R.id.txtItemTenBH);
        TextView tvCaSi = convertView.findViewById(R.id.txtItemTenCaSi);
        TextView tvTime = convertView.findViewById(R.id.txtItemThoiLuong);
        BaiHat bh = baiHats.get(position);
        tvTen.setText(bh.getTenBH());
        tvCaSi.setText(bh.getTenCS());
        tvTime.setText(bh.getThoiLuong() + "");

        return convertView;
    }
}
