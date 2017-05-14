package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PhoneList extends AppCompatActivity {
    private ImageButton record, message, dial;


    private ListView listView;
    private PhoneListAdapter adapter;
    private EditText searchView;

    //test
    String[] name;
    String[] phone;
    String[] image;

    //list 넣어서 찾아보기
    private List<PhoneListNode> dbPhoneList;
    //private DBOperator operator;
    private ArrayList<PhoneListNode> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_list);

        addListenerOnButtonMessage();
        addListenerOnButtonDial();
        addListenerOnButtonRecord();

        arrayList = new ArrayList<PhoneListNode>();
        //operator = new DBOperator();
        listView = (ListView)findViewById(R.id.listView);

        //test
        name = new String[] {"kjh", "ifj", "wpj", "iwu", "qpi", "iue"};
        phone = new String[] {"010-3233-2221","010-3233-2222","010-3233-2223","010-3233-2224","010-3233-2225","010-3233-2226"};
        image = new String[] {"man", "woman", "else", "man", "woman", "else"};
        for(int i = 0;i<name.length;i++){
            PhoneListNode pn = new PhoneListNode(name[i], phone[i], image[i]);
            arrayList.add(pn);
        }
        adapter = new PhoneListAdapter(this, arrayList);
        listView.setAdapter(adapter);

        searchView = (EditText) findViewById(R.id.searchView);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                String text = searchView.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }


    public void addListenerOnButtonRecord(){
        record = (ImageButton) findViewById(R.id.btn_record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneList.this, CallList.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonMessage(){
        message = (ImageButton) findViewById(R.id.btn_message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneList.this, MessageList.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonDial(){
        dial= (ImageButton) findViewById(R.id.btn_phoneList);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}