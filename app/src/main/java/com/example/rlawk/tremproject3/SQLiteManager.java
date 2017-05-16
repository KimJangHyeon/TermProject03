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
        db.execSQL("CREATE TABLE ADDRESSBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, icon TEXT);");
        db.execSQL("CREATE TABLE MESSAGEMAIN (_id INTEGER PRIMARY KEY AUTOINCREMENT, inOut TEXT, phone TEXT, content TEXT, date TEXT);");
        db.execSQL("CREATE TABLE MESSAGEALL (_id INTEGER PRIMARY KEY AUTOINCREMENT, inOut TEXT, phone TEXT, content TEXT, date TEXT);");
        db.execSQL("CREATE TABLE CALLLIST (_id INTEGER PRIMARY KEY AUTOINCREMENT, inOut TEXT, phone TEXT, date TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    //case of table == MESSAGEMAIN, MESSAGEALL
    public void INSERT(String table, boolean inOut, String phone, String content, String date){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO " + table + " VALUES(null, "+inOut+", '"+phone+"', '"+content+"', '"+date+"');");
        db.close();
    }

    public void INSERT(String table, int inOut, String phone, String date){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO " + table + " VALUES(null, "+inOut+", '"+phone+"', '"+date+"');");
        db.close();
    }

    //case of table == ADDRESSBOOK
    public void INSERT(String table, String name, String phone, String icon){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO " + table + " VALUES(null, '" + name + "', '" + phone + "', '" + icon + "');");
        db.close();

    }
    public void UPDATE(String table, String name, String phone){
        SQLiteDatabase db = getWritableDatabase();
        if(table.equals("ADDRESSBOOK")) {
            db.execSQL("UPDATE " + table + " SET phone='" + phone + "' WHERE name='" + name + "';");
            db.close();
        }
    }
    public void DELETEBYPHONE(String table, String phone){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE "+table+" WHERE phone = '" + phone + "';");
    }
    //case of all
    public void DELETE(String table, String phone){
        SQLiteDatabase db = getWritableDatabase();
        if(table.equals("ADDRESSBOOK")) {
            db.execSQL("DELETE FROM " + table + " WHERE phone = '" + phone + "';");
            db.close();
        } else {
            db.execSQL("DELETE FROM " + table + " WHERE date = '" + phone + "';");
            db.close();
        }
    }

    public List<PhoneListNode> getResultPhoneList(String table){
        SQLiteDatabase db = getReadableDatabase();
        List<PhoneListNode> result = new ArrayList<PhoneListNode>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + table, null);
        while(cursor.moveToNext()){
            PhoneListNode node = new PhoneListNode(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            result.add(node);
        }
        return result;
    }

    public List<CallListNode> getResultCallList(){
        SQLiteDatabase db = getReadableDatabase();
        List<CallListNode> result = new ArrayList<CallListNode>();

        Cursor cursor  = db.rawQuery("SELECT * FROM CALLLIST", null);
        while(cursor.moveToNext()){
            CallListNode node = new CallListNode(cursor.getInt(1), cursor.getString(2), cursor.getString(3));
            result.add(node);
        }
        return result;
    }
}
