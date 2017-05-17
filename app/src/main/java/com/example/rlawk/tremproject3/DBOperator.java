package com.example.rlawk.tremproject3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlawk on 2017-05-15.
 */

public class DBOperator {
    Context mContext;
    final SQLiteManager manager;
    public DBOperator(Context context) {
        mContext = context;
        manager = new SQLiteManager(mContext,"/storage/emulated/0/address.db", null, 1);
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
        manager.INSERT("CALLLIST", inOut, phone, date);
    }
    public List<CallListNode> getResultCallList(){
        return manager.getResultCallList();
    }
    public void deleteCallList(String date){
        manager.DELETE("CALLLIST", date);
    }
    public void insertMessageMainList(int inOut, String phone, String content, String date){
        manager.DELETEBYPHONE("MESSAGEMAIN", phone);
        manager.INSERT("MESSAGEMAIN", inOut, phone, content, date);
    }
    public void insertMessageAllList(int inOut, String phone, String content, String date){
        manager.INSERT("MESSAGEALL", inOut, phone, content, date);
    }
    public List<MessageNode> getResultMessageList(){
        return manager.getResultMessageMainList();
    }
    public void deleteMessageMainList(String phone){
        manager.DELETE("MESSAGEMAIN", phone);
        manager.DELETE("MESSAGEALL", phone);
    }

    public void deleteMessageChatList(String phone, String date, List<MessageNode> list){
        ArrayList<MessageNode> arrayList = new ArrayList<>();
        manager.DELETECHAT(date, phone);
        arrayList.addAll(manager.getResultMessageSomeList(phone));
        manager.DELETE("MESSAGEMAIN", phone);

        if(arrayList.size()!=0){
            MessageNode node = arrayList.get(arrayList.size()-1);
            insertMessageMainList(node.getInOut(), node.getPhone(), node.getContent(), node.getDate());
        }

    }

    public List<MessageNode> getResultMessageSomeList(String phone){
        return manager.getResultMessageSomeList(phone);
    }
}
