package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private TextView text_name;
    private TextView text_phone;
    private PerPersonAdapter adapter;
    private ArrayList<MessageNode> messageNodeArrayList = new ArrayList<MessageNode>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_per_person);
        contents = (EditText)findViewById(R.id.ed_sendText);
        listView = (ListView)findViewById(R.id.listview_);
        Intent intent = getIntent();
        name = intent.getStringExtra("NAME");
        phone = intent.getStringExtra("PHONE");
        addListenButtonBack();
        addListenButtonSend();
        text_name = (TextView)findViewById(R.id.text_name);
        text_phone=(TextView)findViewById(R.id.text_phoneNumber);
        Log.d("name", name);
        Log.d("phone", phone);
        text_phone.setText(phone);

        text_name.setText(name);
        dbOperator = new DBOperator(getApplicationContext());
        messageNodeArrayList.addAll(dbOperator.getResultMessageSomeList(phone));


        adapter = new PerPersonAdapter(this, messageNodeArrayList, phone);
        if(listView == null)
            Log.i("NullCheck", "NULL");
        else
            listView.setAdapter(adapter);
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
                messageNodeArrayList.clear();
                messageNodeArrayList.addAll(dbOperator.getResultMessageSomeList(phone));
                adapter.update();
                contents.setText("");
            }
        });
    }

    public void addListenButtonBack(){
        btn_next = (ImageButton) findViewById(R.id.btn_goBack);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagePerPerson.this, MessageList.class);
                startActivity(intent);
            }
        });
    }
}
