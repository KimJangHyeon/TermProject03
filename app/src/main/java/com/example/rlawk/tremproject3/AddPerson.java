package com.example.rlawk.tremproject3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//main에서온거랑 phoneLIst에서 온거 나눠 주기
public class AddPerson extends AppCompatActivity {
    public static Context mContext;
    public String name="";
    public String phone="";
    private Button cancel, ok;
    private EditText eName;
    private EditText ePhone;
    private SQLiteManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person);

        eName = (EditText)findViewById(R.id.text_name);
        ePhone = (EditText)findViewById(R.id.text_phone);

        //dial 에서 번호를 받아서 넘어왔으면 그번호를 phone 에 추가
        //전화번호부에서 받으면 name과 phone 추가
        Intent intent = getIntent();
        if(intent.getStringExtra("FROM").equals("PhoneList")){
            //image = intent.getStringExtra("IMAGE");
            name = intent.getStringExtra("NAME");
            phone = intent.getStringExtra("PHONE");
        }else {
            phone = intent.getStringExtra("phone number to add");
        }

        eName.setText(name);
        ePhone.setText(phone);
        //setPhoneEdit(ePhone);
        addListenerOnButtonCancel();
        addListenerOnButtonOk();
    }

    public void setPhoneEdit(EditText ePhone){
        IntoPhoneFilter intoPhoneFilter = new IntoPhoneFilter();
        ePhone.setText(intoPhoneFilter.deleteHythen(ePhone.getText().toString()));
        ePhone.setText(intoPhoneFilter.toPhoneForm(ePhone.getText().toString()));
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
                manager.INSERT(eName.getText().toString(), ePhone.getText().toString(), "man");
                startActivity(intent);
            }
        });
    }
}
