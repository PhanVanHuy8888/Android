package com.example.lession10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HoaDonAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    List<HoaDon> hoaDons;

    public HoaDonAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.hoaDons = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.activity_lsv, null);

        TextView tvTen = convertView.findViewById(R.id.itemTen);
        TextView tvSoPhong = convertView.findViewById(R.id.itemSoPhong);
        TextView tvTong = convertView.findViewById(R.id.itemTong);
        HoaDon hd = hoaDons.get(position);
        float sum = hd.getDonGia() * hd.getSoNgayLuuTru();
        tvTen.setText(hd.getHoTen());
        tvSoPhong.setText("Phòng: " +  hd.getSoPhong());
        tvTong.setText(sum +"");
        return convertView;
    }

}
