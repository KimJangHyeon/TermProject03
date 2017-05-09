package com.example.rlawk.tremproject3;

import android.graphics.drawable.Drawable;

/**
 * Created by rlawk on 2017-05-09.
 */
//안되면 setName 이름 바꿔보기

public class CallListItem {
    private Drawable icon;
    private String name;
    private String phone;

    public void setIcon(Drawable icon){
        this.icon = icon;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public Drawable getIcon(){
        return this.icon;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
}
