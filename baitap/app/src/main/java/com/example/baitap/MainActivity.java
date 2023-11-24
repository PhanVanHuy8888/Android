package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView lsv;
    private Button btnThem;
    public static ArrayList<Contact> contacts = new ArrayList<>();
    DBHelper dbHelper;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        dbHelper = new DBHelper(this, "contactdb.db", null, 1);
        contacts.clear();
        contacts.addAll(dbHelper.getAll());
        adapter = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, contacts);
        lsv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ActivityAdd.class);
                startActivity(it);
            }
        });
    }

    private void map(){
        btnThem = findViewById(R.id.btnThem);
        lsv = findViewById(R.id.lsvContact);
    }
}