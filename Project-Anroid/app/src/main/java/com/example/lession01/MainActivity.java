package com.example.lession01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtsoA, edtsoB, edtKQ, edtBanKinh, edtChuVi, edtS;
    Button btnTong, btnHieu, btnThuong, btnTich, btnTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tong);
        map();
//        btnTong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                float soA = Float.parseFloat(edtsoA.getText().toString());
//                float soB = Float.parseFloat(edtsoB.getText().toString());
//                float t = soB + soA;
//                edtKQ.setText(t+"");
//            }
//        });
//        btnHieu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                float soA = Float.parseFloat(edtsoA.getText().toString());
//                float soB = Float.parseFloat(edtsoB.getText().toString());
//                float t = soB - soA;
//                edtKQ.setText(t+"");
//            }
//        });
//        btnThuong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                float soA = Float.parseFloat(edtsoA.getText().toString());
//                float soB = Float.parseFloat(edtsoB.getText().toString());
//                float t = soB/soA;
//                edtKQ.setText(t+"");
//            }
//        });
//        btnTich.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                float soA = Float.parseFloat(edtsoA.getText().toString());
//                float soB = Float.parseFloat(edtsoB.getText().toString());
//                float t = soB * soA;
//                edtKQ.setText(t+"");
//            }
//        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float pi = 3.14f;
                float banKinh = Float.parseFloat(edtBanKinh.getText().toString());
                float chuVi = banKinh * 2 * pi;
                float dienTich = banKinh * banKinh * pi;
                edtChuVi.setText(chuVi + "");
                edtS.setText(dienTich + "");
            }

        });
    }

    private void map() {
        edtBanKinh = findViewById(R.id.edtBanKinh);
        edtChuVi = findViewById(R.id.edtChuVi);
        edtS = findViewById(R.id.edtS);
//        edtsoA = findViewById(R.id.edtSoA);
//        edtsoB = findViewById(R.id.edtSoB);
//        edtKQ = findViewById(R.id.edtKQ);
//        btnTong = findViewById(R.id.btnTong);
//        btnTich = findViewById(R.id.btnTich);
//        btnThuong = findViewById(R.id.btnThuong);
//        btnHieu = findViewById(R.id.btnHieu);
        btnTinh = findViewById(R.id.btnTinh);
    }
}