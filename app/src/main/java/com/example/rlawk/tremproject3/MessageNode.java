package com.example.rlawk.tremproject3;

/**
 * Created by rlawk on 2017-05-10.
 */

public class MessageNode {
    private boolean inOut;
    private String content;
    private String date;
    private String phone;

    public MessageNode(boolean inOut, String date, String phone, String content){
        this.inOut = inOut;
        this.date = date;
        this.phone = phone;
        this.content = content;
    }

    public String getPhone(){return phone;}
    public String getDate(){return date;}
    public String getContent(){return content;}
    public boolean getInOut(){return inOut;}

    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setInOut(boolean inOut){ this.inOut = inOut;}
}
