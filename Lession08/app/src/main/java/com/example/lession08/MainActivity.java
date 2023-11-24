package com.example.lession08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lsv;
    private Button btnThem;

    public static ArrayList<SinhVien> lstSV = new ArrayList<>();
    ArrayAdapter adapter;
    DBHelper dbHelper = new DBHelper(MainActivity.this, "", null, 2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        lstSV = (ArrayList<SinhVien>) dbHelper.getAll();
        adapter =new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lstSV);
        lsv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);

            }
        });
    }

    private void map(){
        lsv = findViewById(R.id.lsv);
        btnThem = findViewById(R.id.btnAdd);
    }
}