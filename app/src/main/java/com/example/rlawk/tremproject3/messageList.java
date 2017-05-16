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
    private ImageButton record, dial, phoneList, send;
    private ListView messageList;
    private MessageAdapter adapter;
    private EditText search;
    private ArrayList<MessageNode> msgArrayList = new ArrayList<MessageNode>();
    private ArrayList<PhoneListNode> phoneArrayList = new ArrayList<PhoneListNode>();
    private DBOperator dbOperator;
    //test
    private String[] dateArr;
    private String[] phoneArr;
    private String[] contentArr;
    private boolean[] inOutArr;


    private String[] p_phoneArr;
    private String[] p_nameArr;
    private String[] p_imageArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbOperator  = new DBOperator(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);
        msgArrayList.addAll(dbOperator.getResultMessageList());
        phoneArrayList.addAll(dbOperator.getResultPhoneList("ADDRESSBOOK"));
        messageList = (ListView) findViewById(R.id.list_message);

        addListenerOnButtonDial();
        addListenerOnButtonPhoneList();
        addListenerOnButtonRecord();
        addListenerOnButtonSend();
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
    public void addListenerOnButtonSend(){
        send = (ImageButton) findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageList.this, SendMessage.class);
                startActivity(intent);
            }
        });
    }

}