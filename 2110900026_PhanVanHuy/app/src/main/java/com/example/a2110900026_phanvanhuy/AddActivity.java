package com.example.a2110900026_phanvanhuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText edtTen, edtMonHoc, edtCC, edtKT, edtThi;
    private Button btnSave, btnSua, btnCancel;
    DBHelper dbHelper = new DBHelper(this, "", null, 1);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        map();

        Intent it = getIntent();
        if(it != null) {
            Bundle bundle = it.getExtras();
            if(bundle != null) {
                String hoTen = bundle.getString("HO_TEN");
                String monHoc = bundle.getString("MON_HOC");
                edtTen.setText(hoTen);
                edtMonHoc.setText(monHoc);

            }
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtTen.getText().toString();
                String monHoc = edtMonHoc.getText().toString();
                Float diemCC = Float.valueOf(edtCC.getText().toString());
                Float diemKT = Float.valueOf(edtKT.getText().toString());
                Float diemThi = Float.valueOf(edtThi.getText().toString());


                SinhVien sinhVien = new SinhVien(hoTen, "image", monHoc, diemCC, diemKT, diemThi);
                dbHelper.insert(sinhVien);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtTen.getText().toString();
                String monHoc = edtMonHoc.getText().toString();
                Float diemCC = Float.valueOf(edtCC.getText().toString());
                Float diemKT = Float.valueOf(edtKT.getText().toString());
                Float diemThi = Float.valueOf(edtThi.getText().toString());
                SinhVien sinhVien = new SinhVien(hoTen, "image", monHoc, diemCC, diemKT, diemThi);
                dbHelper.update(sinhVien);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }



    private void map() {
        edtTen = findViewById(R.id.edtName);
        edtMonHoc = findViewById(R.id.edtMonHoc);
        edtCC = findViewById(R.id.edtCC);
        edtThi = findViewById(R.id.edtThi);
        edtKT = findViewById(R.id.edtKT);
        btnSave = findViewById(R.id.btnLuu);
        btnCancel = findViewById(R.id.btnCancel);
        btnSua = findViewById(R.id.btnEdit);

    }

}
