package com.example.lession08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AddActivity extends AppCompatActivity {
    private EditText edtSbd, edtTen, edtToan, edtHoa, edtLy;
    private Button btnThem, btnQuayLai;

    DBHelper dbHelper = new DBHelper(AddActivity.this, "", null, 2);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        map();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtSbd.getText().toString());
                String ten = edtTen.getText().toString();
                float toan = Float.parseFloat(edtToan.getText().toString());
                float ly = Float.parseFloat(edtLy.getText().toString());
                float hoa = Float.parseFloat(edtHoa.getText().toString());
                SinhVien sv = new SinhVien(ma, ten, toan, ly, hoa );
                dbHelper.insert(sv);
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    private void map(){
        edtSbd = findViewById(R.id.edtSBD);
        edtTen = findViewById(R.id.edtName);
        edtToan = findViewById(R.id.edtToan);
        edtLy = findViewById(R.id.edtLy);
        edtHoa = findViewById(R.id.edtHoa);
        btnThem = findViewById(R.id.btnThem);
        btnQuayLai = findViewById(R.id.btnBack);
    }
}
