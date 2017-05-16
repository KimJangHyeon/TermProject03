package com.example.rlawk.tremproject3;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//main에서온거랑 phoneLIst에서 온거 나눠 주기
public class AddPerson extends AppCompatActivity {
    public static Context mContext;
    public String name="";
    public String phone="";
    public String foreName="";
    public String forePhone = "";
    private Button cancel, ok;

    private EditText eName;
    private EditText ePhone;
    private IntoPhoneFilter filter;
    private DBOperator dbOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person);
        filter = new IntoPhoneFilter();
        eName = (EditText)findViewById(R.id.text_name);
        ePhone = (EditText)findViewById(R.id.text_phone);

        dbOperator = new DBOperator(getApplicationContext());
        //dial 에서 번호를 받아서 넘어왔으면 그번호를 phone 에 추가
        //전화번호부에서 받으면 name과 phone 추가
        Intent intent = getIntent();
        if(intent.getStringExtra("FROM").equals("PhoneList")){
            //image = intent.getStringExtra("IMAGE");
            name = intent.getStringExtra("NAME");
            foreName = intent.getStringExtra("NAME");
            phone = intent.getStringExtra("PHONE");
            forePhone = intent.getStringExtra("PHONE");
        }else {
            phone = intent.getStringExtra("PHONE");
        }

        eName.setText(name);
        ePhone.setText(filter.deleteHythen(phone));
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
    public String isExist(String phone){
        List<PhoneListNode> list = new ArrayList<PhoneListNode>();
        list.addAll(dbOperator.getResultPhoneList("ADDRESSBOOK"));
        for(PhoneListNode node : dbOperator.getResultPhoneList("ADDRESSBOOK")){
           if(phone.equals(node.getPhone().toString())) return node.getName().toString();
        }
        return "";
    }
    public void addListenerOnButtonOk(){
        String isExist = "";
        ok = (Button) findViewById(R.id.btn_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_LONG).show();
                }else if (ePhone.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "번호을 입력하세요.", Toast.LENGTH_LONG).show();
                }else if(!isExist(filter.toPhoneForm(ePhone.getText().toString())).equals("")){
                    Toast.makeText(getApplicationContext(), "이미 있는 전화번호 입니다.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent = new Intent(AddPerson.this, PhoneList.class);
                    if (!foreName.equals("")){
                        dbOperator.deletePhoneList("ADDRESSBOOK", forePhone);
                    }

                    dbOperator.insertPhoneList("ADDRESSBOOK", eName.getText().toString(), filter.toPhoneForm(ePhone.getText().toString()), "man");
                    startActivity(intent);
                }
            }
        });
    }
}
