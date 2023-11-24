package com.example.lession09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TaxiAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Taxi> taxis;

    public TaxiAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.taxis = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_lv_taxi, null);
        TextView tvSoXe = convertView.findViewById(R.id.txtItemSoXe);
        TextView tvQD = convertView.findViewById(R.id.txtItemQD);
        TextView tvTongTien = convertView.findViewById(R.id.txtItemTongTien);
        Taxi taxi = taxis.get(position);
        float sum = taxi.getDonGia() * taxi.getQuangDuong() * ((100 - taxi.getKhuyenMai())/100);
        tvSoXe.setText(taxi.getSoXe());
        tvQD.setText("Quãng đường: " + (int)taxi.getQuangDuong() + " km");
        tvTongTien.setText(String.valueOf((int) sum));
        return convertView;
    }
}
