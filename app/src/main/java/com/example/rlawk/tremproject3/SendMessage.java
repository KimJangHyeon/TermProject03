package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SendMessage extends AppCompatActivity {
    EditText phoneNumber;
    EditText contents;
    ImageButton send;
    IntoPhoneFilter filter;
    DBOperator dbOperator;
    String strContent;
    String strPhone;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message);
        dbOperator = new DBOperator(getApplicationContext());
        filter = new IntoPhoneFilter();
        phoneNumber = (EditText)findViewById(R.id.ed_phone);
        contents = (EditText)findViewById(R.id.ed_content);
        addListenerOnButtonSend();
    }

    void addListenerOnButtonSend(){
        send = (ImageButton) findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNumber.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "전화번호를 입력하세요", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(SendMessage.this, MessageList.class);
                    //db
                    strPhone = phoneNumber.getText().toString();
                    strPhone = filter.toPhoneForm(strPhone);
                    strContent = contents.getText().toString();

                    long now = System.currentTimeMillis();
                    Date _date = new Date(now);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
                    date = simpleDateFormat.format(_date);

                    dbOperator.insertMessageMainList(1, strPhone, strContent, date);
                    dbOperator.insertMessageAllList(1, strPhone, strContent, date);
                    startActivity(intent);
                }
            }
        });
    }
}
