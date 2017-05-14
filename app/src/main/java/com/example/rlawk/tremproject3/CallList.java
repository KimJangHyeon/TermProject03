package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CallList extends AppCompatActivity {

    private ImageButton dial, message, phoneList;
    private CallListAdapter adapter;
    private ListView callList;
    private ArrayList<CallListNode> arrListCall = new ArrayList<CallListNode>();
    private ArrayList<PhoneListNode> arrListPhone = new ArrayList<PhoneListNode>();

    //test
    private int[] inOutArr;
    private String[] dateArr;
    private String[] phoneArr;
    private String[] imageArr;

    private String[] p_nameArr;
    private String[] p_phoneArr;
    private String[] p_imageArr;
    //private SQLiteManager addressDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_list);

        addListenerOnButtonDial();
        addListenerOnButtonPhoneList();
        addListenerOnButtonMessage();

        callList = (ListView) findViewById(R.id.list_callList);

        //test
        inOutArr = new int[]{1, 0, -1, 1, 0, -1};
        dateArr = new String[] {"MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분", "MM월dd일hh시mm분"};
        phoneArr = new String[] {"010-9788-4541", "010-9788-4534", "010-9788-4546", "010-9588-4544", "010-9288-4544", "010-2788-4544"};

        p_phoneArr = new String[] {"010-9788-4541", "010-9788-4534"};
        p_nameArr = new String[] {"kim", "Park"};
        p_imageArr = new String[] {"man", "woman"};

        for(int i = 0;i< dateArr.length;i++){
            CallListNode node = new CallListNode(inOutArr[i], dateArr[i], phoneArr[i]);
            arrListCall.add(node);
        }
        for(int i = 0;i<p_nameArr.length;i++){
            PhoneListNode node = new PhoneListNode(p_nameArr[i], p_phoneArr[i], p_imageArr[i]);
            arrListPhone.add(node);
        }
        //_________________________________________________________________________________________________________________
        adapter = new CallListAdapter(this, arrListCall, arrListPhone);
        callList.setAdapter(adapter);
        //addressDB = new SQLiteManager(getApplicationContext(), "ADDRESS.db", null, 1);
    }


    public void setListWithAdapter(){
        //if(addressDB !=null) adapter = new CallListAdapter(this, addressDB.getResult());
        //else{
        //    List<PhoneListNode> listNull = new ArrayList<PhoneListNode>();
        //    adapter = new CallListAdapter(this, listNull);
        //}
        //callList =(ListView)findViewById(R.id.list_callList);
        //callList.setAdapter(adapter);
    }

    public void addListenerOnButtonDial(){
        dial = (ImageButton) findViewById(R.id.btn_record);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonMessage(){
        message = (ImageButton) findViewById(R.id.btn_message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallList.this, MessageList.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonPhoneList(){
        phoneList= (ImageButton) findViewById(R.id.btn_phoneList);
        phoneList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallList.this, PhoneList.class);
                startActivity(intent);
            }
        });
    }

}
