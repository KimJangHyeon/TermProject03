package com.example.rlawk.tremproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class CallListSingleItem extends AppCompatActivity {
    private String name;
    private String phone;
    private int inOut;
    private String date;
    private String image;

    TextView txt_date;
    TextView txt_phone;
    TextView txt_name;
    ImageView img_image;
    TextView txt_inOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_list_single_item);
        Intent intent = getIntent();
        name = intent.getStringExtra("NAME");
        phone = intent.getStringExtra("PHONE");
        inOut = intent.getIntExtra("INOUT", 1);
        date = intent.getStringExtra("DATE");
        Log.d("DATE", date);
        image = intent.getStringExtra("IMAGE");

        txt_date =(TextView)findViewById(R.id.text_date);
        txt_phone = (TextView)findViewById(R.id.text_phone);
        txt_name = (TextView)findViewById(R.id.text_name);
        img_image = (ImageView)findViewById(R.id.img_image);
        txt_inOut = (TextView)findViewById(R.id.text_inout);

        txt_date.setText(date);

        if(name.equals("()@&$&*&"))
          txt_name.setText("Unknown");
        else
            txt_name.setText(name);

        txt_phone.setText(phone);

        if(image.toString().equals("man")){
            img_image.setImageResource(R.drawable.number0);
        } else if(image.toString().equals("woman")){
            img_image.setImageResource(R.drawable.number1);
        }else{
            img_image.setImageResource(R.drawable.number2);
        }
        if(inOut ==1){
            txt_inOut.setText("수신");
        }else if(inOut==0){
            txt_inOut.setText("부재중");
        }else{
            txt_inOut.setText("발신");
        }
    }
}
