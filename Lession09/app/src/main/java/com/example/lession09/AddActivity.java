package com.example.lession09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private EditText edtSoXe, edtQD, edtDG, edtSale;
    private Button btnThem, btnSua, btnQuayLai;
    DbHelper dbHelper = new DbHelper(this, "", null, 1);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        map();

        Intent it = getIntent();
        if (it != null) {
            Bundle bundle = it.getExtras();
            if(bundle != null){
                String soXe = bundle.getString("KEY_SOXE");
                Float quangDuong = bundle.getFloat("KEY_QD");
                Float donGia = bundle.getFloat("KEY_DONGIA");
                Float khuyenMai = bundle.getFloat("KEY_SALE");
                edtSoXe.setText(soXe);
                edtQD.setText(quangDuong + "");
                edtDG.setText(donGia + "");
                edtSale.setText(khuyenMai + "");
            }

        }



        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soXe = edtSoXe.getText().toString();
                Float quangDuong = Float.parseFloat(edtQD.getText().toString());
                Float donGia = Float.parseFloat(edtDG.getText().toString());
                Float khuyenMai = Float.parseFloat(edtSale.getText().toString());
                Taxi taxi = new Taxi(soXe, quangDuong, donGia, khuyenMai);
                dbHelper.insert(taxi);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soXe = edtSoXe.getText().toString();
                Float quangDuong = Float.parseFloat(edtQD.getText().toString());
                Float donGia = Float.parseFloat(edtDG.getText().toString());
                Float khuyenMai = Float.parseFloat(edtSale.getText().toString());
                Taxi taxi = new Taxi(soXe, quangDuong, donGia, khuyenMai);
                dbHelper.update(taxi);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    private void map() {
        edtSoXe = findViewById(R.id.edtSoXe);
        edtQD = findViewById(R.id.edtQD);
        edtDG = findViewById(R.id.edtDG);
        edtSale = findViewById(R.id.edtKM);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnQuayLai = findViewById(R.id.btnBack);
    }
}
