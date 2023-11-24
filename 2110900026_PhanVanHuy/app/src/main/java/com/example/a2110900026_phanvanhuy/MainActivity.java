package com.example.a2110900026_phanvanhuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lsv;
    private Button btnThem;
    DBHelper dbHelper;
    SinhVienApdapter sinhVienApdapter;
    public static ArrayList<SinhVien> sinhViens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        dbHelper = new DBHelper(this, "", null, 1);

        sinhViens = (ArrayList<SinhVien>) dbHelper.getAll();
        sinhVienApdapter = new SinhVienApdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, sinhViens);
        lsv.setAdapter(sinhVienApdapter);

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
                bundle.putString("HO_TEN", sinhViens.get(i).getHoTen());
                bundle.putString("MON_HOC", sinhViens.get(i).getMonHoc());
                it.putExtras(bundle);
                startActivity(it);
                return false;
            }
        });
    }
    private void map() {
        btnThem = findViewById(R.id.btnAdd);
        lsv = findViewById(R.id.lsv);
    }
}