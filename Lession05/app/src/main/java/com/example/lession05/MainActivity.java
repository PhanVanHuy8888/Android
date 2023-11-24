package com.example.lession05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edtGia, edtSL, edtTong, edtSale;
    Spinner spBook;
    RadioButton rdTienMat, rdATM;
    Button btnThanhToan;
    ArrayList<String> lstSach = new ArrayList<>();
    ArrayAdapter<String> adapter;
    private Map<String, Double> book = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstSach.add("tin đại cương");
        lstSach.add("LT hướng đối tượng");
        book.put("tin đại cương", (double)200000);
        book.put("LT hướng đối tượng", (double)260000);
        adapter = new ArrayAdapter<>(MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lstSach);
        spBook.setAdapter(adapter);
        map();
        spBook.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String ten = lstSach.get(position);
                edtGia.setText(String.valueOf(book.get(ten)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        if (rdATM != null) {
            rdATM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edtSale.setText("10");
                }
            });
        }

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double gia = Double.parseDouble(edtGia.getText().toString());
                double sl = Double.parseDouble(edtSL.getText().toString());
                double sale = Double.parseDouble(edtSale.getText().toString());
                double tien = (gia * sl * sale)/100;
                edtTong.setText(tien + "");
            }
        });
    }

    private void map() {
        rdTienMat = findViewById(R.id.rdMoney);
        rdATM = findViewById(R.id.rdATM);
        edtGia = findViewById(R.id.edtPrice);
        edtSL = findViewById(R.id.edtQuantity);
        edtTong = findViewById(R.id.edtSum);
        btnThanhToan = findViewById(R.id.btnThanhToan);
        spBook = findViewById(R.id.spBook);
        edtSale = findViewById(R.id.edtSale);
    }
}