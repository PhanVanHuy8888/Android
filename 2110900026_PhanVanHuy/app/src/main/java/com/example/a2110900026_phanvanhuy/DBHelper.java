package com.example.a2110900026_phanvanhuy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static String DBName = "sinhviendb.db";
    private int version = 1;
    private String Table_Name = "SinhVien";
    private String id = "id";
    private String HoTen = "hoTen";
    private String image = "image";
    private String tenMonHoc = "tenMonHoc";
    private String diemCC = "diemCC";
    private String diemKT = "diemKT";
    private String diemThi = "diemThi";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_Name + " ( " +
                id + " INTEGER PRIMARY KEY NOT NULL, " +
                HoTen + " TEXT NOT NULL, " +
                image + " TEXT NOT NULL, " +
                tenMonHoc + " TEXT NOT NULL, " +
                diemCC + " FLOAT NOT NULL, " +
                diemKT + " FLOAT NOT NULL, " +
                diemThi + " FLOAT NOT NULL ) ";
        sqLiteDatabase.execSQL(query);
    }

    public void insert(SinhVien sinhVien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id, sinhVien.getId());
        values.put(HoTen, sinhVien.getHoTen());
        values.put(image, sinhVien.getImage());
        values.put(tenMonHoc, sinhVien.getMonHoc());
        values.put(diemCC, sinhVien.getDiemCC());
        values.put(diemKT, sinhVien.getDiemKT());
        values.put(diemThi, sinhVien.getDiemThi());
        db.insert(Table_Name, null, values);
    }

    public List<SinhVien> getAll() {
        List<SinhVien> lst = new ArrayList<>();
        String qr = "select * from " + Table_Name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qr, null);
        while (cursor.moveToNext()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.getId(cursor.getInt(0));
            sinhVien.setHoTen(cursor.getString(1));
            sinhVien.setMonHoc(cursor.getString(2));
            sinhVien.getDiemCC(cursor.getFloat(3));
            sinhVien.getDiemKT(cursor.getFloat(4));
            sinhVien.getDiemThi(cursor.getFloat(5));
            lst.add(sinhVien);
        }
        return lst;
    }

    public void update(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(image, sv.getId());
        values.put(HoTen, sv.getHoTen());
        values.put(tenMonHoc, sv.getMonHoc());
        values.put(diemCC, sv.getDiemCC());
        values.put(diemKT, sv.getDiemKT());
        values.put(diemThi, sv.getDiemThi());
        String where = id + " = " + sv.getId();
        db.update(Table_Name, values, where, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
