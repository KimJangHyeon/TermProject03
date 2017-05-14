package com.example.rlawk.tremproject3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlawk on 2017-05-09.
 */

public class SQLiteManager extends SQLiteOpenHelper{
   public SQLiteManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
     super(context, name, factory, version);
   }

    @Override
   public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite", "ADDRESSBOOK Table created");
        db.execSQL("CREATE TABLE ADDRESSBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, icon TEXT);");
        //db.execSQL("CREATE TABLE  (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, icon TEXT);");
        //db.execSQL("CREATE TABLE ADDRESSBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, icon TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void INSERT(String name, String phone, String icon){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO ADDRESSBOOK VALUES(null, '"+name+"', '"+phone+"', '"+icon+"');");
        db.close();
    }
    public void UPDATE(String name, String phone){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE ADDRESSBOOK SET phone='" + phone + "' WHERE name='"+name+"';");
        db.close();
    }

    public void DELETE(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE ADDRESSBOOK WHERE name = '" + name + "' WHERE name='" + name + "';");
        db.close();
    }

    public List<PhoneListNode> getResult(){
        SQLiteDatabase db = getReadableDatabase();
        List<PhoneListNode> result = new ArrayList<PhoneListNode>();

        Cursor cursor = db.rawQuery("SELECT * FROM ADDRESSBOOK", null);
        while(cursor.moveToNext()){
            PhoneListNode node = new PhoneListNode(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            result.add(node);
        }
        return result;
    }
}
