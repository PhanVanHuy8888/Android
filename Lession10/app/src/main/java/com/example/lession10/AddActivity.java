package com.example.lession10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private EditText edtHoTen, edtDonGia, edtLuuTru, edtSoPhong;
    private Button btnThem, btnBack, btnSua;
    DbHelper dbHelper = new DbHelper(this, "", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        map();
        Intent it = getIntent();
        if(it != null) {
            Bundle bundle = it.getExtras();
            if(bundle != null) {
                String hoTen = bundle.getString("HO_TEN");
                String soPhong = String.valueOf(bundle.getInt("SO_PHONG"));
                String donGia = String.valueOf(bundle.getFloat("DON_GIA"));
                String luuTru = String.valueOf(bundle.getInt("LUU_TRU"));
                edtHoTen.setText(hoTen);
                edtDonGia.setText(donGia);
                edtSoPhong.setText(soPhong);
                edtLuuTru.setText(luuTru);
            }
        }
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString();
                Integer soPhong = Integer.parseInt(edtSoPhong.getText().toString());
                Integer luuTru = Integer.parseInt(edtLuuTru.getText().toString());
                Float donGia = Float.parseFloat(edtLuuTru.getText().toString());

                HoaDon hoaDon = new HoaDon(hoTen, soPhong, donGia, luuTru);
                dbHelper.insert(hoaDon);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soPhong = Integer.parseInt(edtSoPhong.getText().toString());
                String hoTen = edtHoTen.getText().toString();
                int luuTru = Integer.parseInt(edtLuuTru.getText().toString());
                float donGia = Float.parseFloat(edtDonGia.getText().toString());
                HoaDon hd = new HoaDon(hoTen, soPhong, donGia, luuTru);
                dbHelper.update(hd);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

    private void map() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoPhong = findViewById(R.id.edtSoPhong);
        edtDonGia = findViewById(R.id.edtDonGia);
        edtLuuTru = findViewById(R.id.edtLuuTru);
        btnThem = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);
        btnSua = findViewById(R.id.btnEdit);
    }

}
