package com.example.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityAdd extends AppCompatActivity {
    private EditText edtMa, edtTen, edtSDT;
    private Button btnThem, btnBack;

    DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        map();
        dbHelper = new DBHelper(ActivityAdd.this, "", null, 1);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString());
                String ten = edtTen.getText().toString();
                String sdt = edtSDT.getText().toString();
                Contact contact = new Contact(ma, ten, sdt);
                dbHelper.insert(contact);
                Intent intent = new Intent(ActivityAdd.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityAdd.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void map(){
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtName);
        edtSDT = findViewById(R.id.edtNumber);
        btnThem = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnQuayLai);
    }
}
