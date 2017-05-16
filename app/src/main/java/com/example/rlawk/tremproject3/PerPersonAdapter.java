package com.example.rlawk.tremproject3;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlawk on 2017-05-16.
 */

public class PerPersonAdapter extends BaseAdapter {
    Context mContext;
    String phone;
    LayoutInflater inflater;
    private List<MessageNode> messageNodeList =null;
    private ArrayList<MessageNode> arrayList;
    DBOperator dbOperator;

    public PerPersonAdapter(Context context, List<MessageNode> messageNodeList, String phone){
        mContext = context;
        this.messageNodeList = messageNodeList;
        this.phone = phone;
        dbOperator = new DBOperator(mContext);
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<MessageNode>();
        this.arrayList.addAll(messageNodeList);
    }

    @Override
    public int getCount(){return messageNodeList.size();}

    @Override
    public MessageNode getItem(int position){return messageNodeList.get(position);}

    @Override
    public long getItemId(int position){return position;}

    public class ViewHolder{

    }
}
