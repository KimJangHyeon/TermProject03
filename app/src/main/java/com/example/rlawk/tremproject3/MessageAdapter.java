package com.example.rlawk.tremproject3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlawk on 2017-05-11.
 */

//DBOperator에서 mainMessage리스트를 받아와서 리스트에 맞는 item을 출력

//전화번호부를 받아오는 파라미터는 namePhoneList


public class MessageAdapter extends BaseAdapter{
    Context mContext;
    LayoutInflater inflater;
    private List<MessageNode> messageNodeList = null;
    private ArrayList<MessageNode> arrayList;
    private List<PhoneListNode> namePhoneList = null;
    //private List<PhoneListNode> phoneListNodeList = null;
    //private ArrayList<PhoneListNode> arrayPhoneList;

    public MessageAdapter(Context context, List<MessageNode> messageNodeList){
        mContext = context;
        this.messageNodeList = messageNodeList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<MessageNode>();
        this.arrayList.addAll(messageNodeList);
        //this.namePhoneList에 db에 있는 mainMessage 넣기
    }

    public class ViewHolder{
        TextView content;
        ImageView icon;
        TextView phoneOrName;
        TextView date;
    }

    @Override
    public int getCount() { return messageNodeList.size();}

    @Override
    public MessageNode getItem(int position){ return  messageNodeList.get(position);}

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String isAddress(List<PhoneListNode> list, String phoneNumber){
        for(PhoneListNode node:list){
            //IntoPhoneFilter filter = new IntoPhoneFilter();
            if(node.getPhone().equals(phoneNumber)) return node.getName();
        }
        return "^&*13@*&";
    }

    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();

            view  = inflater.inflate(R.layout.message_item, null);

            holder.phoneOrName = (TextView)view.findViewById(R.id.text_name);
            holder.content = (TextView) view.findViewById(R.id.text_content);
            holder.icon = (ImageView) view.findViewById(R.id.img_icon);
            holder.date = (TextView) view.findViewById(R.id.text_date);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.content.setText(messageNodeList.get(position).getContent());
        holder.date.setText(messageNodeList.get(position).getDate());

        //이미지 icon
        if(messageNodeList.get(position).getIcon().equals("man")){
            holder.icon.setImageResource(R.drawable.number0);
        }else if(messageNodeList.get(position).getIcon().equals("woman")){
            holder.icon.setImageResource(R.drawable.number1);
        }else{
            holder.icon.setImageResource(R.drawable.number2);
        }

        //이름이 있으면 이름입력
        String toName = isAddress(namePhoneList, messageNodeList.get(position).getPhone());
        if(!toName.equals("^&*13@*&")) holder.phoneOrName.setText(toName);
        else holder.phoneOrName.setText(messageNodeList.get(position).getPhone());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MessagePerPerson.class);
                intent.putExtra("phoneNumber", (messageNodeList.get(position).getPhone()));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    //filter Class

}
