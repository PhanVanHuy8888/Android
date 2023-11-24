package com.example.lession04_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lession04_2.Object.MonHoc;
import com.example.lession04_2.Object.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtTen, edtMa;
    private Button btnDangKy, btnTraCuu;
    private CheckBox cbTA, cbNET, cbDiDong;
    private TextView txtHienThi;

    ArrayList<SinhVien> lst = new ArrayList<SinhVien>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString());
                String ten = edtTen.getText().toString();

                ArrayList<MonHoc> monHocs = new ArrayList<>();

                if(cbTA.isChecked()){
                    MonHoc ta = new MonHoc(1, "Tiếng Anh", 2);
                    monHocs.add(ta);

                }
                if(cbDiDong.isChecked()){
                    MonHoc dd = new MonHoc(2, "Lập trình di động", 3);
                    monHocs.add(dd);

                }
                if(cbNET.isChecked()){
                    MonHoc net = new MonHoc(3, "ASP .NET", 4);
                    monHocs.add(net);

                }

                int tongSoTin = 0;
                for (MonHoc monHoc : monHocs) {
                    tongSoTin += monHoc.getSoTin();
                }

                int tongTien = tongSoTin * 600;

                SinhVien sv = new SinhVien(ma, ten, monHocs, tongTien);
                lst.add(sv);
            }
        });

        btnTraCuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString());

                boolean found = false;

                for (SinhVien sv : lst) {
                    if (sv.getMa() == ma) {
                        txtHienThi.setText(sv.toString());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    txtHienThi.setText("Không có sinh viên nào!");
                }
            }
        });

    }

    private void map() {
        edtMa = findViewById(R.id.edtMaSV);
        edtTen = findViewById(R.id.edtTenSV);
        btnDangKy = findViewById(R.id.btnSub);
        btnTraCuu = findViewById(R.id.btnTraCuu);
        txtHienThi = findViewById(R.id.txtDisplay);
        cbNET = findViewById(R.id.cbNET);
        cbTA = findViewById(R.id.cbTA);
        cbDiDong = findViewById(R.id.cbDiDong);
    }
}