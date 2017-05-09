package com.example.rlawk.tremproject3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rlawk on 2017-05-09.
 */

public class CallListAdapter extends BaseAdapter{
    private ArrayList<CallListItem> callListItemsList = new ArrayList<CallListItem>();

    public CallListAdapter(){

    }

    @Override
    public int getCount(){
        return callListItemsList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.call_list_item, parent, false);
        }

        ImageView callIcon = (ImageView) convertView.findViewById(R.id.img_call);
        TextView callName = (TextView) convertView.findViewById(R.id.text_name);
        TextView callPhone = (TextView) convertView.findViewById(R.id.text_phone);

        CallListItem callListItem = callListItemsList.get(position);
        callIcon.setImageDrawable(callListItem.getIcon());
        callName.setText(callListItem.getName());
        callPhone.setText(callListItem.getPhone());

        return convertView;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return callListItemsList.get(position);
    }
    public void addItem(Drawable icon, String name, String phone){
        CallListItem callListItem = new CallListItem();

        callListItem.setIcon(icon);
        callListItem.setName(name);
        callListItem.setPhone(phone);

        callListItemsList.add(callListItem);
    }
}
