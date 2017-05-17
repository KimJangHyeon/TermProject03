package com.example.rlawk.tremproject3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.R.drawable;
/**
 * Created by rlawk on 2017-05-11.
 */

public class PhoneListAdapter extends BaseAdapter{
    Context mContext;
    LayoutInflater inflater;
    private List<PhoneListNode> phoneListNodeList = null;
    private ArrayList<PhoneListNode> arraylist;
    DBOperator dbOperator;

    //DBOperator로부터 받는 파라미터

    public PhoneListAdapter(Context context, List<PhoneListNode> phoneListNodeList) {
        mContext = context;
        this.phoneListNodeList = phoneListNodeList;
        dbOperator = new DBOperator(mContext);
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<PhoneListNode>();
        this.arraylist.addAll(phoneListNodeList);
    }

    @Override
    public int getCount() {
        return phoneListNodeList.size();
    }


    @Override
    public PhoneListNode getItem(int position) {
        return phoneListNodeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewHolder{
        TextView name;
        TextView phone;
        ImageView icon;
    }

    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.phone_list_item, null);

            holder.name = (TextView) view.findViewById(R.id.text_name);
            holder.phone = (TextView) view.findViewById(R.id.text_phone);
            holder.icon = (ImageView) view.findViewById(R.id.img_icon);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(phoneListNodeList.get(position).getName());
        holder.phone.setText(phoneListNodeList.get(position).getPhone());
        //icon의 종류에 따른 icon
        if (phoneListNodeList.get(position).getImage().equals("man")) {
            holder.icon.setImageResource(R.drawable.user_help);
        }else if (phoneListNodeList.get(position).getImage().equals("woman")){
            holder.icon.setImageResource(R.drawable.number1);
        }else{
            holder.icon.setImageResource(R.drawable.user_help);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddPerson.class);
                intent.putExtra("NAME", (phoneListNodeList.get(position).getName()));
                intent.putExtra("PHONE", (phoneListNodeList.get(position).getPhone()));
                intent.putExtra("IMAGE", (phoneListNodeList.get(position).getImage()));
                intent.putExtra("FROM", "PhoneList");
                mContext.startActivity(intent);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dbOperator.deletePhoneList("ADDRESSBOOK", phoneListNodeList.get(position).getPhone().toString());
                phoneListNodeList.clear();
                phoneListNodeList.addAll(dbOperator.getResultPhoneList("ADDRESSBOOK"));
                notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        phoneListNodeList.clear();
        if(arraylist.size()==0) arraylist.addAll(dbOperator.getResultPhoneList("ADDRESSBOOK"));
        if(charText.length() == 0){
            Log.d("arrayList", "0");
            phoneListNodeList.addAll(arraylist);
        }else{
            for(PhoneListNode node: arraylist){
                Log.d("ADD", "node");
                if(node.getName().toLowerCase(Locale.getDefault()).contains(charText)) {

                    phoneListNodeList.add(node);
                }
            }
        }
        notifyDataSetChanged();
    }
}
