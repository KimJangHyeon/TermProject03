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
    private DBOperator dbOperator;
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
        dbOperator = new DBOperator(this);
        setContentView(R.layout.phone_list);

        addListenerOnButtonMessage();
        addListenerOnButtonDial();
        addListenerOnButtonRecord();

        arrayList = new ArrayList<PhoneListNode>();
        listView = (ListView)findViewById(R.id.listView);

        adapter = new PhoneListAdapter(this, arrayList);
        arrayList.addAll(dbOperator.getResultPhoneList("ADDRESSBOOK"));

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

    @Override
    protected void onResume() {
        super.onResume();
        //왜 여기서 안되지;;
        adapter.notifyDataSetChanged();
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