package com.example.lession03_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtSo, edtKQ;
    Button btnNhap, btnKQ;
    RadioButton rdHienThi, rdTong, rdTBC;
    ArrayList<Float> list = new ArrayList<Float>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSo.length() == 0) {
                    Toast.makeText(MainActivity.this, "lỗi rồi", Toast.LENGTH_SHORT).show();
                }
                list.add(Float.parseFloat(edtSo.getText().toString()));
            }
        });
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                int sum = 0;
                if (rdHienThi.isChecked()) {
                    for (float i : list) {
                        s = s + i + ", ";
                    }
                    edtKQ.setText(s);
                }else if(rdTong.isChecked()){
                    for(float i : list) {
                        sum += i;
                    }
                    s = s + sum;
                    edtKQ.setText(s);
                }else if(rdTBC.isChecked()){
                    for(float i : list) {
                        sum += i;
                    }
                    sum = sum/list.size();
                    s = s + sum;
                    edtKQ.setText(s);
                }
            }
        });
    }

    private void map() {
        edtSo = findViewById(R.id.edtDay);
        btnNhap = findViewById(R.id.btnNhap);
        rdHienThi = findViewById(R.id.rdDay);
        rdTong = findViewById(R.id.rdTong);
        rdTBC = findViewById(R.id.rdTBC);
        edtKQ = findViewById(R.id.edtKQ);
        btnKQ = findViewById(R.id.btnKQ);
    }
}