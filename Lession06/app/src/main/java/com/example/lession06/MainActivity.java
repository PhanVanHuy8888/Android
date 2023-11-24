package com.example.lession06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lession06.Object.BaiHat;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtMa, edtTenBH, edtTenCS, edtThoiLuong;
    private Button btnThem, btnSua;
    private ListView lstBH;

    public static ArrayList<BaiHat> baiHats = new ArrayList<>();

    DbHelper dbHelper;
    BaiHatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        dbHelper = new DbHelper(MainActivity.this, "", null, 2);
        dbHelper.insert(new BaiHat(8, "Gấp đôi yêu thương","Tuấn Hưng", 10));
        dbHelper.insert(new BaiHat(9, "Tìm lại bầu trời","Tuấn Hưng", 15));
        dbHelper.insert(new BaiHat(10, "Yêu lại từ đâu","Khắc Viet", 15));

        baiHats = (ArrayList<BaiHat>) dbHelper.getAll();
        adapter = new BaiHatAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, baiHats);
        lstBH.setAdapter(adapter);
        lstBH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("KEY_MA", baiHats.get(i).getMaBH());
                bundle.putString("KEY_TENBH", baiHats.get(i).getTenBH());
                bundle.putString("KEY_TENCS", baiHats.get(i).getTenCS());
                bundle.putFloat("KEY_THOILUONG", baiHats.get(i).getThoiLuong());
                it.putExtras(bundle);
                startActivity(it);
                return false;
            }
        });
    }

    private void map() {
        edtMa = findViewById(R.id.edtMaBH);
        edtTenBH = findViewById(R.id.edtTenBH);
        edtTenCS = findViewById(R.id.edtTenCS);
        edtThoiLuong = findViewById(R.id.edtTime);
        btnSua = findViewById(R.id.btnEdit);
        btnThem = findViewById(R.id.btnThem);
        lstBH = findViewById(R.id.lstBH);
    }
}

