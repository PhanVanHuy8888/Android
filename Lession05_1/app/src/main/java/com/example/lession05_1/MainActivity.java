package com.example.lession05_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTen;
    ListView lsv;
    Button btnThem, btnSua;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    int viTri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        list.add("Minh");
        list.add("Huy");
        adapter = new ArrayAdapter<>(MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        lsv.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                list.add(ten);
                // Update
                adapter.notifyDataSetChanged();
            }
        });
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ten = list.get(i);
                edtTen.setText(ten);
                viTri = i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.set(viTri, edtTen.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        lsv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    private void map() {
        lsv = findViewById(R.id.lsvSV);
        btnThem = findViewById(R.id.btnThem);
        edtTen = findViewById(R.id.edtTen);
        btnSua = findViewById(R.id.btnEdit);
    }
}