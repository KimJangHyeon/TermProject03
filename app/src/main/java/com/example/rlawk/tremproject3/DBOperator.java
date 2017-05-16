package com.example.rlawk.tremproject3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rlawk on 2017-05-15.
 */

public class DBOperator {
    Context mContext;
    final SQLiteManager manager;
    public DBOperator(Context context) {
        mContext = context;
        manager = new SQLiteManager(mContext,"address.db", null, 1);
    }
    public List<PhoneListNode> getResultPhoneList(String table){
        return manager.getResultPhoneList(table);
    }
    public void insertPhoneList(String table, String name, String phone, String icon){
        manager.INSERT(table, name, phone, icon);
    }
    public void deletePhoneList(String table, String phone){
        manager.DELETE(table, phone);
    }

    public void insertCallList(int inOut, String date, String phone){
        //발신 -1
        manager.INSERT("CALLLIST", inOut, date, phone);
    }
    public List<CallListNode> getResultCallList(){
        return manager.getResultCallList();
    }
}
