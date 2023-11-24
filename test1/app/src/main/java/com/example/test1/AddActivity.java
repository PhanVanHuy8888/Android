package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private EditText edtTen, edtTuoi, edtDiaChi, edtGioiTinh;
    private Button btnThem, btnSua, btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        map();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    private void map() {
        edtTen = findViewById(R.id.edtName);
        edtTuoi = findViewById(R.id.edtAge);
        edtDiaChi = findViewById(R.id.edtAddress);
        edtGioiTinh = findViewById(R.id.edtGender);
        btnThem = findViewById(R.id.btnAdd);
        btnSua = findViewById(R.id.btnEdit);
        btnBack = findViewById(R.id.btnBack);
    }
}
