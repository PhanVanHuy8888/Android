package com.example.lession04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lession04.Object.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtMa, edtTen, edtDiem;
    private Button  btnThem, btnHienThi;
    private TextView txtDDSV;
    ArrayList<SinhVien> lstSV = new ArrayList<SinhVien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString());
                String ten = edtTen.getText().toString();
                float diem = Float.parseFloat(edtDiem.getText().toString());
                SinhVien sinhVien = new SinhVien(ma, ten, diem);
                lstSV.add(sinhVien);
            }
        });

        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(SinhVien sv : lstSV){
                    txtDDSV.setText(sv.getMaSV() + "\n" + sv.getTenSV() + "\n" + sv.getPoint());

                }
            }
        });
    }


    private void map() {
        edtMa = findViewById(R.id.edtMaSV);
        edtDiem = findViewById(R.id.edtPoint);
        edtTen = findViewById(R.id.detTenSV);
        btnThem = findViewById(R.id.btnAdd);
        btnHienThi = findViewById(R.id.btnDisplay);
        txtDDSV = findViewById(R.id.txtListSV);
    }

}