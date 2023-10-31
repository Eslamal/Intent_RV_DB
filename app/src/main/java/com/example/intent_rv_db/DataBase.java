package com.example.intent_rv_db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table ident (id integer primary key autoincrement , name text , age real , address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ident");
        onCreate(db);
    }
    public boolean insert(Infos infos){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",infos.getName());
        contentValues.put("age",infos.getAge());
        contentValues.put("address",infos.getAddress());
        database.execSQL("delete from ident");
        long result=database.insert("ident",null,contentValues);
        return result != -1 ;
    }
    public ArrayList<Infos> retrive(){
        SQLiteDatabase database=getReadableDatabase();
        ArrayList<Infos>arrayList=new ArrayList<>();
        Cursor cursor=database.rawQuery("select * from ident ",null);
        if(cursor != null && cursor.moveToFirst()){
            do{
                @SuppressLint("Range") int id=cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name =cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") double age =cursor.getDouble(cursor.getColumnIndex("age"));
                @SuppressLint("Range") String address =cursor.getString(cursor.getColumnIndex("address"));
                Infos info=new Infos(id,name,age,address);
                arrayList.add(info);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return arrayList ;
    }
}
