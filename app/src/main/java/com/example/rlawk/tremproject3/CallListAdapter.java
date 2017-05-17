package com.example.rlawk.tremproject3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.R.drawable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlawk on 2017-05-09.
 */

/*
* 파라미터: list<inOut, date, phone, icon>
*           list 전화번호부
*           */

public class CallListAdapter extends BaseAdapter{

    Context mContext;
    LayoutInflater inflater;
    private DBOperator dbOperator;

    //요기에 db에서 받아온 list넣을거@@
    private List<CallListNode> callListNodeList = null;
    private List<PhoneListNode> dbPhoneList = null;
    public CallListAdapter(Context context, List<CallListNode> callListNodeList, List<PhoneListNode> dbPhoneList){
        mContext = context;
        this.callListNodeList = callListNodeList;
        this.dbPhoneList = dbPhoneList;
        inflater = LayoutInflater.from(mContext);
    }
    public class ViewHolder{
        TextView name;
        TextView phone;
        TextView date;
        ImageView inOut;
    }

    @Override
    public int getCount(){ return callListNodeList.size();}

    @Override
    public CallListNode getItem(int position) { return callListNodeList.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.call_list_item, null);
            holder.name = (TextView) view.findViewById(R.id.text_name);
            holder.date = (TextView) view.findViewById(R.id.text_date);
            holder.phone = (TextView) view.findViewById(R.id.text_phone);
            holder.inOut = (ImageView) view.findViewById(R.id.img_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
            //수신1, 발신-1, ?0
        holder.date.setText(callListNodeList.get(position).getDate());
        holder.phone.setText(callListNodeList.get(position).getPhone());
        final String[] address = isInAddress(callListNodeList.get(position).getPhone());
        if(address[0].equals("()@&$&*&")){
            holder.name.setText("Unknown");
        }else{
            holder.name.setText(address[0]);
        }
        if(callListNodeList.get(position).getInOut() == 1){
            holder.inOut.setImageResource(drawable.sym_call_outgoing);
        } else if (callListNodeList.get(position).getInOut() == 0 ){
            holder.inOut.setImageResource(drawable.sym_call_missed);
        }else {
            holder.inOut.setImageResource(drawable.sym_call_outgoing);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CallListSingleItem.class);
                intent.putExtra("NAME", address[0]);
                intent.putExtra("DATE", callListNodeList.get(position).getDate());
                Log.d("DATE", callListNodeList.get(position).getDate());
                intent.putExtra("INOUT", callListNodeList.get(position).getInOut());
                intent.putExtra("PHONE", callListNodeList.get(position).getPhone());
                intent.putExtra("IMAGE", address[1]);

                mContext.startActivity(intent);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("DATE:", callListNodeList.get(position).getDate().toString());

                //??error
                dbOperator = new DBOperator(mContext);

                Log.d("size", callListNodeList.size()+"");
                dbOperator.deleteCallList(callListNodeList.get(position).getDate().toString());
                //=-------------delete가 안됨----------------------
                //dbOperator.deleteCallList(position);
                callListNodeList.clear();
                Log.d("size", callListNodeList.size()+"");
                callListNodeList.addAll(dbOperator.getResultCallList());
                Log.d("size", callListNodeList.size()+"");
                notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }
    public String[] isInAddress(String phone){
        String[] result = new String[2];
        for(PhoneListNode node:dbPhoneList){
            if(node.getPhone().equals(phone)) {
                result[0] = node.getName();
                result[1] = node.getImage();
                return result;
            }
        }
        result[0] = "()@&$&*&";
        result[1] = "()@&$&*&";
        return result;
    }

}
