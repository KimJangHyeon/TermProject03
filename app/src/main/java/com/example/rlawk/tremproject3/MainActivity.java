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
    public View viewOne = findViewById(R.id.btn_number1);
    public View viewTwo = findViewById(R.id.btn_number2);
    public View viewThree = findViewById(R.id.btn_number3);
    public View viewFour = findViewById(R.id.btn_number4);
    public View viewFive = findViewById(R.id.btn_number5);
    public View viewSix = findViewById(R.id.btn_number6);
    public View viewSeven = findViewById(R.id.btn_number7);
    public View viewEight = findViewById(R.id.btn_number8);
    public View viewNine = findViewById(R.id.btn_number9);
    public View viewZero = findViewById(R.id.btn_number0);
    public View viewStar = findViewById(R.id.btn_numberStar);
    public View viewHash = findViewById(R.id.btn_numberHash);
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
                //Add person의 번호로 phoneNumber
                //add person으로 이동
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
                //하이폰 입력
                //1입력
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
    public void makeFourFour(){

    }
    public void addSecondHyphen(TextView phoneNumber){
        //지역번호가 없을 경우
        //02 일경우&&phoneNumber이 6인 경우
        //이외일 경우
    }
    public void addFirstHyphen(TextView phoneNumber){
        if(phoneNumber.getText() == "02"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if(phoneNumber.getText() == "031"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if(phoneNumber.getText()=="032"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "051"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "053"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "062"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "042"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "052"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "044"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "033"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "043"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "041"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "063"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "061"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "054"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "055"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "064"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "010"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
        else if (phoneNumber.getText() == "070"){
            phoneNumber.setText(phoneNumber.getText() + "-");
        }
    }
    public void addFilter(View v, TextView phoneNumber){
        //하이폰이나 숫자 맞추기
        //숫자추가
        if(v == viewOne){

        }
        else if (v == viewTwo){

        }
        else if (v == viewThree){

        }
        else if (v == viewFour){

        }
        else if (v == viewFive){

        }
        else if (v == viewSix){

        }
        else if (v == viewSeven){

        }
        else if (v == viewEight){

        }
        else if (v == viewNine){

        }
        else if (v == viewZero){

        }
        else if (v == viewStar){

        }
        else {

        }

    }
}