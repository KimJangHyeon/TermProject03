package com.example.rlawk.tremproject3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(messageNodeList);
    }

    @Override
    public int getCount(){return messageNodeList.size();}

    @Override
    public MessageNode getItem(int position){return messageNodeList.get(position);}

    @Override
    public long getItemId(int position){return position;}

    public class ViewHolder{
        ImageView img_chat;
        TextView txt_content;
        TextView txt_date;
    }

    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if(view == null){
            holder= new ViewHolder();
            if(messageNodeList.get(position).getInOut()>0){
                view = inflater.inflate(R.layout.per_person_item, null);
            }else{
                view = inflater.inflate(R.layout.per_person_item2, null);
            }
            holder.img_chat = (ImageView) view.findViewById(R.id.img_chat);
            holder.txt_content = (TextView) view.findViewById(R.id.txt_content);
            holder.txt_date = (TextView) view.findViewById(R.id.txt_date);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.txt_content.setText(messageNodeList.get(position).getContent());
        if(messageNodeList.get(position).getInOut()>0){
            holder.img_chat.setImageResource(R.drawable.chat_box1);
        }else{
            holder.img_chat.setImageResource(R.drawable.chat_box);
        }
        holder.txt_date.setText(messageNodeList.get(position).getDate());
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dbOperator.deleteMessageChatList(messageNodeList.get(position).getPhone(), messageNodeList.get(position).getDate(), messageNodeList);
                messageNodeList.clear();
                messageNodeList.addAll(dbOperator.getResultMessageSomeList(phone));
                notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }

    public  void update(){
        notifyDataSetChanged();
    }
}
