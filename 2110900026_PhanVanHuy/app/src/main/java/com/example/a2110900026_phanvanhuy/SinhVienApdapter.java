package com.example.a2110900026_phanvanhuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SinhVienApdapter  extends ArrayAdapter {
    private Context context;
    private int resource;
    List<SinhVien> sinhViens;

    public SinhVienApdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.sinhViens = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.activity_lsv, null);

        TextView tvTen = convertView.findViewById(R.id.txtName);
        TextView tvMonHoc = convertView.findViewById(R.id.txtMonHoc);
        TextView tvDiem = convertView.findViewById(R.id.txtDiem);
        SinhVien sinhVien = sinhViens.get(position);
        float diem = (sinhVien.getDiemCC() + 3*sinhVien.getDiemKT() + 6*sinhVien.getDiemThi())/10;
        tvTen.setText(sinhVien.getHoTen());
        tvMonHoc.setText("Môn học: " +  sinhVien.getMonHoc());
        tvDiem.setText("Điểm môn học: " + diem +"");
        return convertView;
    }
}
