package com.example.lession10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static String DBName = "hoadondb.db";
    private int version = 1;
    private String Table_Name = "HoaDon";
    private String soPhong = "soPhong";
    private String HoTen = "hoTen";
    private String DonGia = "donGia";
    private String SoNgayLuuTru = "soNgayLuuTru";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBName, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_Name + " (" +
                soPhong + " INTEGER PRIMARY KEY NOT NULL, " +
                HoTen + " TEXT NOT NULL, " +
                DonGia + " REAL NOT NULL, " +
                SoNgayLuuTru + " INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(query);

    }


    public void insert(HoaDon hoaDon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(soPhong, hoaDon.getSoPhong());
        values.put(HoTen, hoaDon.getHoTen());
        values.put(DonGia, hoaDon.getDonGia());
        values.put(SoNgayLuuTru, hoaDon.getSoNgayLuuTru());
        db.insert(Table_Name, null, values);
    }

    public List<HoaDon> getAll() {
        List<HoaDon> lst = new ArrayList<>();
        String qr = "select * from " + Table_Name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qr, null);
        while (cursor.moveToNext()) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setSoPhong(cursor.getInt(0));
            hoaDon.setHoTen(cursor.getString(1));
            hoaDon.setDonGia(cursor.getFloat(2));
            hoaDon.setSoNgayLuuTru(cursor.getInt(3));
            lst.add(hoaDon);
        }
        return lst;
    }

    public void update(HoaDon hd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(soPhong, hd.getSoPhong());
        values.put(HoTen, hd.getHoTen());
        values.put(DonGia, hd.getDonGia());
        values.put(SoNgayLuuTru, hd.getSoNgayLuuTru());
        String where = soPhong + " = " + hd.getSoPhong();
        db.update(Table_Name, values, where, null);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
