package com.example.lession06;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lession06.Object.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static String DBName = "songdb.db";
    private int version = 1;
    private String Table_Name = "Song";
    private String Id = "_id";
    private String TenBH = "_tenbh";
    private String TenCS = "_tencs";
    private String TL = "_tl";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_Name + " (" +
                Id + " int PRIMARY KEY NOT NULL, " +
                TenBH + " TEXT NOT NULL, " +
                TenCS + " TEXT NOT NULL, " +
                TL + " REAL)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(BaiHat baiHat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Id, baiHat.getMaBH());
        values.put(TenBH, baiHat.getTenBH());
        values.put(TenCS, baiHat.getTenCS());
        values.put(TL, baiHat.getThoiLuong());
        db.insert(Table_Name, null, values);
    }

    public List<BaiHat> getAll(){
        List<BaiHat> lst = new ArrayList<>();
        String qr = "Select * from " + Table_Name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qr, null);
        while(cursor.moveToNext()){
            BaiHat bh = new BaiHat();
            bh.setMaBH(cursor.getInt(0));
            bh.setTenBH(cursor.getString(1));
            bh.setTenCS(cursor.getString(2));
            bh.setThoiLuong(cursor.getFloat(3));
            lst.add(bh);
        }
        return lst;

    }

    public  void update(BaiHat bh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Id, bh.getMaBH());
        values.put(TenBH, bh.getTenBH());
        values.put(TenCS, bh.getTenCS());
        values.put(TL, bh.getThoiLuong());
        String where =  Id + " = " + bh.getMaBH();
        db.update(Table_Name, values, where, null);
    }
}
