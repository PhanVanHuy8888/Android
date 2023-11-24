package com.example.lession06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lession06.Object.BaiHat;

public class AddActivity extends AppCompatActivity {
    private EditText edtMa, edtTenCS, edtTenBH, edtTL;
    private Button btnEdit;

    DbHelper dbHelper ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dbHelper = new DbHelper(AddActivity.this, "", null, 2);
        map();
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String tenCs = bundle.getString("KEY_TENCS");
        String tenBH = bundle.getString("KEY_TENBH");
        Float tl = bundle.getFloat("KEY_THOILUONG");
        Integer ma = bundle.getInt("KEY_MA");
        edtMa.setText(ma +"");
        edtTenCS.setText(tenCs);
        edtTenBH.setText(tenBH);
        edtTL.setText(tl + "");

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString());
                String tenBH = edtTenBH.getText().toString();
                String tenCS = edtTenCS.getText().toString();
                float tl = Float.parseFloat(edtTL.getText().toString());
                BaiHat bh = new BaiHat(ma, tenBH, tenCS, tl);
                dbHelper.update(bh);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }



    private void map(){
        edtMa = findViewById(R.id.edt_Ma);
        edtTenCS = findViewById(R.id.edt_TenCS);
        edtTenBH = findViewById(R.id.edt_TenBH);
        edtTL = findViewById(R.id.edt_TL);
        btnEdit = findViewById(R.id.btnSua);
    }

}
