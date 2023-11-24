package com.example.baitap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static String DBName = "contactdb.db";
    private int version = 1;
    private String Table_Name = "Contact";
    private String Id = "_id";
    private String Ten = "_ten";
    private String SDT = "_sdt";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_Name + " (" +
                Id + " INTEGER PRIMARY KEY NOT NULL, " +
                Ten + " TEXT NOT NULL, " +
                SDT + " TEXT NOT NULL)";
        sqLiteDatabase.execSQL(query);
    }

    public void insert(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Id, contact.getMa());
        values.put(Ten, contact.getName());
        values.put(SDT, contact.getNumber());
        db.insert(Table_Name, null, values);
    }

    public List<Contact> getAll(){
        List<Contact> lst = new ArrayList<>();
        String qr = "Select * from " + Table_Name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qr, null);
        while(cursor.moveToNext()){
            Contact contact = new Contact();
            contact.setMa(cursor.getInt(0));
            contact.setName(cursor.getString(1));
            contact.setNumber(cursor.getString(2));
            lst.add(contact);
        }
        return lst;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
