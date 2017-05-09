package com.example.rlawk.tremproject3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AddPerson extends AppCompatActivity {
    public static Context mContext;
    public String name="";
    public String phone="";
    private Button cancel, ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person);

        //dial 에서 번호를 받아서 넘어왔으면 그번호를 phone 에 추가
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone number to add");

        addListenerOnButtonCancel();
    }

    public void addListenerOnButtonCancel(){
        cancel = (Button) findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPerson.this, PhoneList.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButtonOk(){
        ok = (Button) findViewById(R.id.btn_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPerson.this, PhoneList.class);
                //PhoneList의 listView에 추가
                startActivity(intent);
            }
        });
    }
}
