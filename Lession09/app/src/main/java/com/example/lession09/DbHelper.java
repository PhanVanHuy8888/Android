package com.example.lession09;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static String DBName ="taxidb.db";
    private int version = 1;
    private String Table_name = "Taxi";
    private String soXe ="_soXe";
    private String quangDuong ="_QD";
    private String donGia ="_DG";
    private String sale ="_KM";


    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBName, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_name + " (" +
                soXe + " STRING PRIMARY KEY NOT NULL, " +
                quangDuong + " REAL NOT NULL, " +
                donGia + " REAL NOT NULL, " +
                sale + " REAL NOT NULL)";
        sqLiteDatabase.execSQL(query);
    }

    public void insert(Taxi taxi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(soXe, taxi.getSoXe());
        values.put(quangDuong, taxi.getQuangDuong());
        values.put(donGia, taxi.getDonGia());
        values.put(sale, taxi.getKhuyenMai());
        db.insert(Table_name, null, values);
    }

    public List<Taxi> getAll(){
        List<Taxi> lst = new ArrayList<>();
        String qr = "Select * from " + Table_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qr, null);
        while(cursor.moveToNext()){
            Taxi taxi = new Taxi();
            taxi.setSoXe(cursor.getString(0));
            taxi.setQuangDuong(cursor.getFloat(1));
            taxi.setDonGia(cursor.getFloat(2));
            taxi.setKhuyenMai(cursor.getFloat(2));
            lst.add(taxi);
        }
        return lst;
    }

    public void update(Taxi taxi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(soXe, taxi.getSoXe());
        values.put(quangDuong, taxi.getQuangDuong());
        values.put(donGia, taxi.getDonGia());
        values.put(sale, taxi.getKhuyenMai());
        String where = soXe + " = " + taxi.getSoXe();
        db.update(Table_name, values, where, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
