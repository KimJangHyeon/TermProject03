package com.example.rlawk.tremproject3;

/**
 * Created by rlawk on 2017-05-10.
 */

public class MessageNode {
    private String content;
    private String date;
    private String phone;
    private String icon;

    public MessageNode(String date, String phone, String content, String icon){
        this.date = date;
        this.phone = phone;
        this.content = content;
        this.icon = icon;
    }

    public String getPhone(){return phone;}
    public String getDate(){return date;}
    public String getContent(){return content;}
    public String getIcon(){return icon;}

    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setIcon(String icon) { this.icon = icon; }

}
