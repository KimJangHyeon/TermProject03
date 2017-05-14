package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MessageList extends AppCompatActivity {
    private ImageButton record, dial, phoneList;
    private ListView messageList;
    private MessageAdapter adapter;
    private EditText search;
    private ArrayList<MessageNode> msgArrayList = new ArrayList<MessageNode>();
    private ArrayList<PhoneListNode> phoneArrayList = new ArrayList<PhoneListNode>();

    //test
    private String[] dateArr;
    private String[] phoneArr;
    private String[] contentArr;

    private String[] p_phoneArr;
    private String[] p_nameArr;
    private String[] p_imageArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        messageList = (ListView) findViewById(R.id.list_message);

        addListenerOnButtonDial();
        addListenerOnButtonPhoneList();
        addListenerOnButtonRecord();

        //test
        dateArr = new String[] {"MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분"};
        phoneArr = new String[] {"010-9788-4541", "010-9788-4534", "010-9788-4546", "010-9588-4544", "010-9288-4544", "010-2788-4544"};
        contentArr = new String[] {"안녕하세요", "안녕", "메롱", "하핳하하", "ㅋㅋㅋㅋ", "재댜ㅓㄹ"};
        p_phoneArr = new String[] {"010-9788-4541", "010-9788-4534"};
        p_nameArr = new String[] {"kim", "Park"};
        p_imageArr = new String[] {"man", "woman"};

        for(int i = 0;i< dateArr.length;i++){
            MessageNode mn = new MessageNode(dateArr[i], phoneArr[i], contentArr[i]);
            msgArrayList.add(mn);
        }
        for(int i = 0;i<p_nameArr.length;i++){
            PhoneListNode node = new PhoneListNode(p_nameArr[i], p_phoneArr[i], p_imageArr[i]);
            phoneArrayList.add(node);
        }
        //-----------------------------------------------------------------------------------
        adapter = new MessageAdapter(this, msgArrayList, phoneArrayList);
        messageList.setAdapter(adapter);
        search =(EditText)findViewById(R.id.ed_search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = search.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }

    public void addListenerOnButtonRecord(){
        record = (ImageButton) findViewById(R.id.btn_record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageList.this, CallList.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonDial(){
        dial = (ImageButton) findViewById(R.id.btn_dial);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonPhoneList(){
        phoneList= (ImageButton) findViewById(R.id.btn_phoneList);
        phoneList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageList.this, PhoneList.class);
                startActivity(intent);
            }
        });
    }

}