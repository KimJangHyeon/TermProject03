package com.example.rlawk.tremproject3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ImageButton record, message, phoneList, add, phoneCall, delete;
    private ImageButton one, two, three, four, zero, five, six, seven, eight, nine, hash, star;
    private TextView phoneNumber;
    public static Context mContext;
    private DBOperator dbOperator;
    public String back_phoneNumber = "";
    private String date = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbOperator = new DBOperator(getApplicationContext());
        final SQLiteManager manager = new SQLiteManager(getApplicationContext(), "ADDRESSBOOK.db", null, 1);
        DBOperator dbOperator = new DBOperator(getApplicationContext());
        //dbOperator.insertMessageMainList(1, "010-7752-0788", "hello, dooo", "2017년 05월 17일 05시 10분 53초");
        //dbOperator.insertMessageMainList(0, "010-7752-0788", "hello, you", "2017년 05월 17일 05시 10분 59초");
        //dbOperator.insertMessageMainList(0, "010-7752-0788", "hello, wooo", "2017년 05월 17일 05시 20분 00초");
        //dbOperator.insertMessageMainList(1, "010-7752-0788", "hello, did", "2017년 05월 17일 05시 21분 50초");
        //dbOperator.insertMessageMainList(1, "010-7752-0788", "hello, dwoeij", "2017년 05월 17일 06시 15분 53초");
        //dbOperator.insertMessageMainList(1, "010-7752-0788", "hello, hahaha~!", "2017년 05월 17일 07시 10분 53초");

        //dbOperator.insertMessageAllList(1, "010-7752-0788", "hello, dooo", "2017년 05월 17일 05시 10분 53초");
        //dbOperator.insertMessageAllList(0, "010-7752-0788", "hello, you", "2017년 05월 17일 05시 10분 59초");
        //dbOperator.insertMessageAllList(0, "010-7752-0788", "hello, wooo", "2017년 05월 17일 05시 20분 00초");
        //dbOperator.insertMessageAllList(1, "010-7752-0788", "hello, did", "2017년 05월 17일 05시 21분 50초");
        //dbOperator.insertMessageAllList(1, "010-7752-0788", "hello, dwoeij", "2017년 05월 17일 06시 15분 53초");
        //dbOperator.insertMessageAllList(1, "010-7752-0788", "hello, hahaha~!", "2017년 05월 17일 07시 10분 53초");

        //dbOperator.insertMessageMainList(1, "010-7752-0712", "hello, dooo", "2017년 05월 17일 05시 10분 53초");
        //dbOperator.insertMessageMainList(0, "010-7752-0712", "hello, you", "2017년 05월 17일 05시 10분 59초");
        //dbOperator.insertMessageMainList(0, "010-7752-0712", "hello, wooo", "2017년 05월 17일 05시 20분 00초");
        //dbOperator.insertMessageMainList(1, "010-7752-0712", "hello, did", "2017년 05월 17일 05시 21분 50초");
        //dbOperator.insertMessageMainList(1, "010-7752-0712", "hello, dwoeij", "2017년 05월 17일 06시 15분 53초");
        //dbOperator.insertMessageMainList(1, "010-7752-0712", "hello, hahaha~!", "2017년 05월 17일 07시 10분 53초");

        //dbOperator.insertMessageAllList(1, "010-7752-0712", "hello, dooo", "2017년 05월 17일 05시 10분 53초");
        //dbOperator.insertMessageAllList(0, "010-7752-0712", "hello, you", "2017년 05월 17일 05시 10분 59초");
        //dbOperator.insertMessageAllList(0, "010-7752-0712", "hello, wooo", "2017년 05월 17일 05시 20분 00초");
        //dbOperator.insertMessageAllList(1, "010-7752-0712", "hello, did", "2017년 05월 17일 05시 21분 50초");
        //dbOperator.insertMessageAllList(1, "010-7752-0712", "hello, dwoeij", "2017년 05월 17일 06시 15분 53초");
        //dbOperator.insertMessageAllList(1, "010-7752-0712", "hello, hahaha~!", "2017년 05월 17일 07시 10분 53초");

        dbOperator.insertCallList(0, "2017년 04월 10일 05시 00분 51초", "010-2342-1123");
        dbOperator.insertCallList(-1, "2017년 04월 10일 05시 02분 53초", "010-2342-1123");
        dbOperator.insertCallList(-1, "2017년 04월 10일 05시 20분 02초", "010-2342-1123");
        dbOperator.insertCallList(-1, "2017년 04월 10일 06시 00분 01초", "010-2342-1123");
        dbOperator.insertCallList(0, "2017년 04월 10일 07시 50분 30초", "010-2342-1123");
        dbOperator.insertCallList(0, "2017년 04월 10일 08시 50분 30초", "010-7752-0788");
        dbOperator.insertCallList(0, "2017년 04월 12일 07시 30분 30초", "010-7752-0788");
        dbOperator.insertCallList(1, "2017년 04월 10일 08시 50분 30초", "010-7752-0788");
        dbOperator.insertCallList(1, "2017년 04월 10일 08시 50분 31초", "010-7752-0728");
        dbOperator.insertCallList(-1, "2017년 05월 11일 12시 50분 30초", "010-7752-0798");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=this;

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
        addListenerOnButtonHash();
        addListenerOnButtonStar();
        add = (ImageButton) findViewById(R.id.btn_addPhoneNumber);
        phoneCall = (ImageButton) findViewById(R.id.btn_phoneCall);
        phoneNumber = (TextView) findViewById(R.id.text_phoneNumber);
        addListenerOnButtonDelete();
    }

    public void addListenerOnButtonDelete(){
        delete = (ImageButton) findViewById(R.id.btn_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(back_phoneNumber.length()>0){
                    back_phoneNumber = back_phoneNumber.substring(0, back_phoneNumber.length()-1);
                    phoneNumber.setText(toPhoneForm(back_phoneNumber));
                }
            }
        });
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
                Intent intent = new Intent(MainActivity.this, AddPerson.class);
                intent.putExtra("PHONE",toPhoneForm(back_phoneNumber));
                intent.putExtra("FROM", "MainActivity");
                startActivityForResult(intent, 1);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButtonPhoneCall(){
        phoneCall= (ImageButton) findViewById(R.id.btn_phoneCall);
        phoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long now = System.currentTimeMillis();
                Date _date = new Date(now);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
                date = simpleDateFormat.format(_date);
                dbOperator.insertCallList(-1, date, phoneNumber.getText().toString());
                Toast.makeText(getApplicationContext(), "발신이 완료되었습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }

    // 숫자 입력시 text에 추가
    public void addListenerOnButtonHash(){
        hash = (ImageButton) findViewById(R.id.btn_numberHash);
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="#";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonStar(){
        star = (ImageButton) findViewById(R.id.btn_numberStar);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="*";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonOne(){
        one = (ImageButton) findViewById(R.id.btn_number1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="1";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonTwo(){
        two = (ImageButton) findViewById(R.id.btn_number2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="2";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));

            }
        });
    }
    public void addListenerOnButtonThree(){
        three = (ImageButton) findViewById(R.id.btn_number3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                back_phoneNumber +="3";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonFour(){
        four= (ImageButton) findViewById(R.id.btn_number4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                back_phoneNumber +="4";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonFive(){
        five = (ImageButton) findViewById(R.id.btn_number5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                back_phoneNumber +="5";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonSix(){
        six = (ImageButton) findViewById(R.id.btn_number6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="6";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonSeven(){
        seven = (ImageButton) findViewById(R.id.btn_number7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="7";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonEight(){
        eight = (ImageButton) findViewById(R.id.btn_number8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="8";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonNine(){
        nine= (ImageButton) findViewById(R.id.btn_number9);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="9";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public void addListenerOnButtonZero(){
        zero= (ImageButton) findViewById(R.id.btn_number0);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_phoneNumber +="0";
                phoneNumber.setText(toPhoneForm(back_phoneNumber));
            }
        });
    }
    public String[] toPhoneFormArr(String back_phoneNumber){
        String[] phoneArr = new String[3];
        String temp = "";
        int length = back_phoneNumber.toString().length();

        //지역번호있는경우
        if(localNumber(back_phoneNumber)){
            //지역번호가 02 인 경우
            if(back_phoneNumber.substring(0,2).equals("02")){
                phoneArr[0] = back_phoneNumber.substring(0,2);
                if (length==2){
                    phoneArr[1] = "";
                    phoneArr[2] = "";
                }else if (length>2&&length<=6){
                    phoneArr[1] = back_phoneNumber.substring(2, length);
                    phoneArr[2] = "";
                }else if (length>6&&length<=10){
                    phoneArr[1] = back_phoneNumber.substring(2, length-4);
                    phoneArr[2] = back_phoneNumber.substring(length-4, length);
                }else{
                    phoneArr[1] = back_phoneNumber.substring(2, 6);
                    phoneArr[2] = back_phoneNumber.substring(6, length);
                }
            }else{
                //031, ....
                phoneArr[0] = back_phoneNumber.substring(0,3);
                if (length==3){
                    phoneArr[1] = "";
                    phoneArr[2] = "";
                }else if (length>3&&length<=7){
                    phoneArr[1] = back_phoneNumber.substring(3, length);
                    phoneArr[2] = "";
                }else if (length>7&&length<=11){
                    phoneArr[1] = back_phoneNumber.substring(3, length-4);
                    phoneArr[2] = back_phoneNumber.substring(length-4, length);
                }
                else {
                    phoneArr[1] = back_phoneNumber.substring(3, 7);
                    phoneArr[2] = back_phoneNumber.substring(7, length);
                }
            }
        }
        //지역번호 없는 경우
        else {
            phoneArr[0] = "";
            if (length <= 4) {
                phoneArr[1] = back_phoneNumber.substring(0);
                phoneArr[2] = "";
            } else {
                phoneArr[1] = back_phoneNumber.substring(0, 4);
                phoneArr[2] = back_phoneNumber.substring(4, length);
            }
        }
        return phoneArr;
    }
    public boolean localNumber(String back_phoneNumber){
        boolean result = false;
        int length = back_phoneNumber.length();
        if(length==2){
            if(back_phoneNumber.equals("02")) return true;
        }
        else if(length>2){
            if(back_phoneNumber.substring(0,2).equals("02")) return true;
            else if(back_phoneNumber.substring(0,3).equals("031")) return true;
            else if(back_phoneNumber.substring(0,3).equals("032")) return true;
            else if(back_phoneNumber.substring(0,3).equals("053")) return true;
            else if(back_phoneNumber.substring(0,3).equals("051")) return true;
            else if(back_phoneNumber.substring(0,3).equals("062")) return true;
            else if(back_phoneNumber.substring(0,3).equals("042")) return true;
            else if(back_phoneNumber.substring(0,3).equals("052")) return true;
            else if(back_phoneNumber.substring(0,3).equals("044")) return true;
            else if(back_phoneNumber.substring(0,3).equals("033")) return true;
            else if(back_phoneNumber.substring(0,3).equals("043")) return true;
            else if(back_phoneNumber.substring(0,3).equals("041")) return true;
            else if(back_phoneNumber.substring(0,3).equals("063")) return true;
            else if(back_phoneNumber.substring(0,3).equals("061")) return true;
            else if(back_phoneNumber.substring(0,3).equals("054")) return true;
            else if(back_phoneNumber.substring(0,3).equals("055")) return true;
            else if(back_phoneNumber.substring(0,3).equals("064")) return true;
            else if(back_phoneNumber.substring(0,3).equals("010")) return true;
            else if(back_phoneNumber.substring(0,3).equals("070")) return true;
        }
        return result;
    }
    public String toPhoneForm(String back_phoneNumber){
        String[] toPhoneArr = new String[3];
        int count = 0;
        for(String i:toPhoneFormArr(back_phoneNumber)){
            toPhoneArr[count++] = i;
        }

        //지역번호 없는경우
        if(toPhoneArr[0].isEmpty()){

            if(toPhoneArr[2].isEmpty()){
                return toPhoneArr[1];
            }
            else {
                return toPhoneArr[1] + "-" + toPhoneArr[2];
            }
        }
        //지역번호 있는경우
        else{
            if(toPhoneArr[2].isEmpty()&&toPhoneArr[1].isEmpty()){
                return toPhoneArr[0];
            }
            else if (toPhoneArr[2].isEmpty()&&!toPhoneArr[1].isEmpty()){
                return toPhoneArr[0] + "-" + toPhoneArr[1];
            }
            else{
                return toPhoneArr[0]+"-"+toPhoneArr[1]+"-"+toPhoneArr[2];
            }
        }


    }

}