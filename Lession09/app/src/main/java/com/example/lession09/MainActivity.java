package com.example.lession09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lsv;
    private Button btnThem;

    public static ArrayList<Taxi> taxis = new ArrayList<>();
    DbHelper dbHelper;
    TaxiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DbHelper(this, "", null, 1);
        map();
        taxis = (ArrayList<Taxi>) dbHelper.getAll();
        adapter = new TaxiAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, taxis);
        lsv.setAdapter(adapter);

        lsv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                bundle.putString("KEY_SOXE", taxis.get(i).getSoXe());
                bundle.putFloat("KEY_QD", taxis.get(i).getQuangDuong());
                bundle.putFloat("KEY_DONGIA", taxis.get(i).getDonGia());
                bundle.putFloat("KEY_SALE", taxis.get(i).getKhuyenMai());
                it.putExtras(bundle);
                startActivity(it);
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);
            }
        });
    }

    private void map() {
        lsv = findViewById(R.id.lsv);
        btnThem = findViewById(R.id.btnAdd);

    }
}