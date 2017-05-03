package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageButton record, message, phoneList, add, phoneCall;
    private ImageButton one, two, three, four, zero, five, six, seven, eight, nine, hash, star;
    private TextView phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonRecord();
        addListenerOnButtonMessage();
        addListenerOnButtonPhoneList();

        addListenerOnButtonAdd();
        addListenerOnButtonPhoneCall();

        addListenerOnButtonOne();
        addListenerOnButtonTwo();
        addListenerOnButtonThree();
        addListenerOnButtonFour();
        addListenerOnButtonFive();
        addListenerOnButtonSix();
        addListenerOnButtonSeven();
        addListenerOnButtonEight();
        addListenerOnButtonNine();
        addListenerOnButtonZero();
        add = (ImageButton) findViewById(R.id.btn_addPhoneNumber);
        phoneCall = (ImageButton) findViewById(R.id.btn_phoneCall);


        phoneNumber = (TextView) findViewById(R.id.text_phoneNumber);

    }

    //화면 전환 record, message, phoneList
    public void addListenerOnButtonRecord(){
        record = (ImageButton) findViewById(R.id.btn_record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CallList.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonMessage(){
        message = (ImageButton) findViewById(R.id.btn_message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageList.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonPhoneList(){
        phoneList= (ImageButton) findViewById(R.id.btn_phoneList);
        phoneList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhoneList.class);
                startActivity(intent);
            }
        });
    }

    //추가, 전화
    public void addListenerOnButtonAdd(){
        add= (ImageButton) findViewById(R.id.btn_addPhoneNumber);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonPhoneCall(){
        phoneCall= (ImageButton) findViewById(R.id.btn_phoneCall);
        phoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    // 숫자 입력시 text에 추가
    public void addListenerOnButtonOne(){
        one = (ImageButton) findViewById(R.id.btn_number1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //예외처리
            }
        });
    }
    public void addListenerOnButtonTwo(){
        two = (ImageButton) findViewById(R.id.btn_number2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonThree(){
        three = (ImageButton) findViewById(R.id.btn_number3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonFour(){
        four= (ImageButton) findViewById(R.id.btn_number4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonFive(){
        five = (ImageButton) findViewById(R.id.btn_number5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonSix(){
        six = (ImageButton) findViewById(R.id.btn_number6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonSeven(){
        seven = (ImageButton) findViewById(R.id.btn_number7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonEight(){
        eight = (ImageButton) findViewById(R.id.btn_number8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonNine(){
        nine= (ImageButton) findViewById(R.id.btn_number9);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void addListenerOnButtonZero(){
        zero= (ImageButton) findViewById(R.id.btn_number0);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addFilter(View v, TextView phoneNumber){
        
    }
}