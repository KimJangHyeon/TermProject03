package com.example.rlawk.tremproject3;

/**
 * Created by rlawk on 2017-05-10.
 */

public class CallListNode {
    private int inOut;
    private String date;
    private String phone;

    public CallListNode(int inOut, String date, String phone){
        this.phone = phone;
        this.inOut = inOut;
        this.date = date;
    }

    public String getPhone(){return phone;}
    public int getInOut(){return inOut;}
    public String getDate(){return date;}

    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setInOut(int inOut){
        this.inOut = inOut;
    }
    public void setDate(String date){
        this.date = date;
    }

}
