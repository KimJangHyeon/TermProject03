package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PhoneList extends AppCompatActivity {

    private ImageButton record, message, dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_list);

        addListenerOnButtonMessage();
        addListenerOnButtonDial();
        addListenerOnButtonRecord();
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