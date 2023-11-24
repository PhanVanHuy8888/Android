package com.example.lesson0402;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lesson0402.obj.MonHoc;
import com.example.lesson0402.obj.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText edtMa,edtTen;
    private Button btDK, btTraCuu;
    private TextView tvTienTra;
    private CheckBox cbTa,cbLT,cbHTT;

    ArrayList<SinhVien> listSv=new ArrayList<>();
    ArrayList<MonHoc> listMonHoc=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        btDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int ma=Integer.parseInt(edtMa.getText().toString());
                    String ten=edtTen.getText().toString();
                    if(cbTa.isChecked()){
                       MonHoc Ta=new MonHoc(1,"TiengAnh",1);
                        listMonHoc.add(Ta);
                    }
                    if(cbTa.isChecked()){
                        MonHoc Lt=new MonHoc(2,"LapTrinh",2);
                        listMonHoc.add(Lt);
                    }
                    if(cbTa.isChecked()){
                        MonHoc HTT=new MonHoc(3,"HTTT",3);
                        listMonHoc.add(HTT);
                    }
                    MonHoc[] monHocArray=listMonHoc.toArray(new MonHoc[listMonHoc.size()]);
                    SinhVien sv=new SinhVien(ma,ten,monHocArray);

            }
        });


        btTraCuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTienTra.setText(listSv.toString());
            }
        });
    }


    private void map(){
        edtMa=findViewById(R.id.edtMaSv);
        edtTen=findViewById(R.id.edtTenSv);
        btDK=findViewById(R.id.btDK);
        btTraCuu=findViewById(R.id.btTraCuu);
        cbHTT=findViewById(R.id.cbHTTT);
        cbLT=findViewById(R.id.cbLT);
        cbTa=findViewById(R.id.cbTA);

    }
}