package com.example.lession10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private ListView lsv;

    HoaDonAdapter hoaDonAdapter;
    DbHelper dbHelper;
    public static ArrayList<HoaDon> hoaDons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        dbHelper = new DbHelper(this, "", null, 1);

        hoaDons = (ArrayList<HoaDon>) dbHelper.getAll();
        hoaDonAdapter = new HoaDonAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, hoaDons);
        lsv.setAdapter(hoaDonAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);
            }
        });
        lsv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("SO_PHONG", hoaDons.get(i).getSoPhong());
                bundle.putFloat("DON_GIA", hoaDons.get(i).getDonGia());
                bundle.putString("HO_TEN", hoaDons.get(i).getHoTen());
                bundle.putInt("LUU_TRU", hoaDons.get(i).getSoNgayLuuTru());
                it.putExtras(bundle);
                startActivity(it);
                return false;
            }
        });
    }

    private void map() {
        btnThem = findViewById(R.id.btnThem);
        lsv = findViewById(R.id.lsv);
    }
}