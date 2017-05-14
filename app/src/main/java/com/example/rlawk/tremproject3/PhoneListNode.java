package com.example.rlawk.tremproject3;

import android.graphics.drawable.Drawable;

/**
 * Created by rlawk on 2017-05-09.
 */

public class PhoneListNode {
    private String phone;
    private String name;
    private String image;

    public PhoneListNode(String name, String phone, String image){
        this.phone = phone;
        this.name = name;
        this.image = image;
    }

    public String getPhone(){return phone;}
    public String getName(){return name;}
    public String getImage(){return image;}

    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setImage(String image){
        this.image = image;
    }


}
