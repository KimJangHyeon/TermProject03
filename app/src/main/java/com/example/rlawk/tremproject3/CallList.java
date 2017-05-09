package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class CallList extends AppCompatActivity {

    private ImageButton dial, message, phoneList;
    private CallListAdapter adapter;
    private ListView callList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_list);

        addListenerOnButtonDial();
        addListenerOnButtonPhoneList();
        addListenerOnButtonMessage();

        setListWithAdapter();
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mail), "kjh", "010-0000-0000");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mail), "kjh", "010-0000-0000");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mail), "kjh", "010-0000-0000");
    }

    public void setListWithAdapter(){
        adapter = new CallListAdapter();

        callList =(ListView)findViewById(R.id.list_callList);
        callList.setAdapter(adapter);
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
