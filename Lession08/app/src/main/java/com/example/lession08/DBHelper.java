package com.example.lession08;

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
    private String Sbd = "_sbd";
    private String Ten = "_ten";
    private String Toan = "_toan";
    private String Ly = "_ly";
    private String Hoa = "_hoa";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_Name + " (" +
                Sbd + " int PRIMARY KEY NOT NULL, " +
                Ten + " TEXT NOT NULL, " +
                Toan + " REAL NOT NULL, " +
                Ly + " REAL NOT NULL, " +
                Hoa + " REAL Not null)";
        sqLiteDatabase.execSQL(query);
    }

    public void insert(SinhVien sinhVien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Sbd, sinhVien.getSdb());
        values.put(Ten, sinhVien.getName());
        values.put(Toan, sinhVien.getToan());
        values.put(Ly, sinhVien.getLy());
        values.put(Hoa, sinhVien.getHoa());
        db.insert(Table_Name, null, values);
    }

    public List<SinhVien> getAll() {
        List<SinhVien> lst = new ArrayList<>();
        String qr = "Select * from " + Table_Name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qr, null);
        while (cursor.moveToNext()) {
            SinhVien sv = new SinhVien();
            sv.setSdb(cursor.getInt(0));
            sv.setName(cursor.getString(1));
            sv.setToan(cursor.getFloat(2));
            sv.setLy(cursor.getFloat(3));
            sv.setHoa(cursor.getFloat(4));
            lst.add(sv);
        }
        return lst;
    }

    public void update(SinhVien sinhVien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Sbd, sinhVien.getSdb());
        values.put(Ten, sinhVien.getName());
        values.put(Toan, sinhVien.getToan());
        values.put(Ly, sinhVien.getLy());
        values.put(Hoa, sinhVien.getHoa());
        String where = Sbd + " = " + sinhVien.getSdb();
        db.update(Table_Name, values, where, null);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
