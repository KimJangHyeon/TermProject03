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

/**
 * Created by rlawk on 2017-05-11.
 */

//DBOperator에서 mainMessage리스트를 받아와서 리스트에 맞는 item을 출력

//전화번호부를 받아오는 파라미터는 namePhoneList


public class MessageAdapter extends BaseAdapter{
    Context mContext;
    LayoutInflater inflater;
    private List<MessageNode> messageNodeList = null;
    private ArrayList<MessageNode> messageArrayList;
    private List<PhoneListNode> dbPhoneList = null;

    public MessageAdapter(Context context, List<MessageNode> messageNodeList, List<PhoneListNode> dbPhoneList){
        mContext = context;
        this.messageNodeList = messageNodeList;
        inflater = LayoutInflater.from(mContext);
        this.dbPhoneList = dbPhoneList;
        this.messageArrayList = new ArrayList<MessageNode>();
        this.messageArrayList.addAll(messageNodeList);
    }
    public class ViewHolder{
        TextView name;
        TextView content;
        ImageView image;
        TextView date;
    }

    @Override
    public int getCount(){ return messageNodeList.size();}
    @Override
    public MessageNode getItem(int position){ return messageNodeList.get(position);}
    @Override
    public long getItemId(int position) { return position;}

    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.message_item, null);

            holder.name = (TextView)view.findViewById(R.id.text_name);
            holder.content = (TextView)view.findViewById(R.id.text_content);
            holder.image = (ImageView)view.findViewById(R.id.img_image);
            holder.date = (TextView)view.findViewById(R.id.text_date);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        String[] nameOrPhone = nameOrPhone(messageNodeList.get(position).getPhone());
        holder.name.setText(nameOrPhone[0]);
        holder.content.setText(messageNodeList.get(position).getContent());
        holder.date.setText(messageNodeList.get(position).getDate());
        if(nameOrPhone[1].equals("man")){
            holder.image.setImageResource(R.drawable.number0);
        }else if(nameOrPhone[1].equals("woman")){
            holder.image.setImageResource(R.drawable.number1);
        }else{
            holder.image.setImageResource(R.drawable.number2);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MessagePerPerson.class);
                intent.putExtra("PHONE", messageNodeList.get(position).getPhone());
                mContext.startActivity(intent);
            }
        });
        return view;
    }
    String[] nameOrPhone(String phone){
        String[] result = new String[2];
        for(PhoneListNode node: dbPhoneList){
            if(node.getPhone().equals(phone)) {
                result[0] = node.getName();
                result[1] = node.getImage();
                return result;
            }
        }
        result[0] = phone;
        result[1] = "else";
        return result;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        Log.d("FILTER", "ENTER");
        messageNodeList.clear();
        if(charText.length() == 0){
            Log.d("START", "length == 0");
            messageNodeList.addAll(messageArrayList);
        }else{
            for(MessageNode node:messageArrayList){
                if(nameOrPhone(node.getPhone())[0].toLowerCase(Locale.getDefault()).contains(charText)){
                    messageNodeList.add(node);
                }
            }
        }
        notifyDataSetChanged();
    }
}
