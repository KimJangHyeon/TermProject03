package com.example.rlawk.tremproject3;

import android.graphics.drawable.Drawable;

/**
 * Created by rlawk on 2017-05-09.
 */
//안되면 setName 이름 바꿔보기

public class CallListItem {
    private Drawable icon;
    private String phone;
    private String date;
    private int inOut;

    public CallListItem(Drawable icon, String phone, String date, int inOut){
        this.phone = phone;
        this.icon = icon;
        this.date = date;
        this.inOut = inOut;
    }
    public void setIcon(Drawable icon){
        this.icon = icon;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setInOut(int inOut){
        this.inOut = inOut;
    }

    public Drawable getIcon(){
        return this.icon;
    }
    public String getDate(){
        return this.date;
    }
    public String getPhone(){
        return this.phone;
    }
    public int getInOut(){ return this.inOut; }
}
