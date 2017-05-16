package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MessagePerPerson extends AppCompatActivity {
    private String name = "";
    private String phone = "";
    private ImageButton btn_next;
    private ListView listView;
    private ImageButton btn_send;
    private EditText contents;
    private DBOperator dbOperator;
    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbOperator = new DBOperator(getApplicationContext());
        super.onCreate(savedInstanceState);
        contents = (EditText)findViewById(R.id.ed_sendText);
        listView = (ListView)findViewById(R.id.listView);
        setContentView(R.layout.message_per_person);
        Intent intent = new Intent();
        name = intent.getStringExtra("NAME");
        phone = intent.getStringExtra("PHONE");
        addListenButtonBack();
        addListenButtonSend();
    }

    public void addListenButtonSend(){
        btn_send = (ImageButton) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long now = System.currentTimeMillis();
                Date _date = new Date(now);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
                date = simpleDateFormat.format(_date);
                dbOperator.insertMessageMainList(1, phone, contents.getText().toString(), date);
                dbOperator.insertMessageAllList(1, phone, contents.getText().toString(), date);
            }
        });
    }
    public void addListenButtonBack(){
        btn_next = (ImageButton) findViewById(R.id.btn_goBack);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
    }
}
