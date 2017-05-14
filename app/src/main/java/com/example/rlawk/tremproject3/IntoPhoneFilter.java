package com.example.rlawk.tremproject3;

/**
 * Created by rlawk on 2017-05-09.
 */

public class IntoPhoneFilter {
    public String deleteHythen(String _phone){
        String phone = _phone;
        while(phone.indexOf("-")!=-1){
            phone = phone.substring(0, phone.indexOf("-"))+phone.substring(phone.indexOf("-")+1);
        }
        return phone;
    }
    public String[] toPhoneFormArr(String back_phoneNumber){
        String[] phoneArr = new String[3];
        String temp = "";
        int length = back_phoneNumber.toString().length();

        //지역번호있는경우
        if(localNumber(back_phoneNumber)){
            //지역번호가 02 인 경우
            if(back_phoneNumber.substring(0,2).equals("02")){
                phoneArr[0] = back_phoneNumber.substring(0,2);
                if (length==2){
                    phoneArr[1] = "";
                    phoneArr[2] = "";
                }else if (length>2&&length<=6){
                    phoneArr[1] = back_phoneNumber.substring(2, length);
                    phoneArr[2] = "";
                }else if (length>6&&length<=10){
                    phoneArr[1] = back_phoneNumber.substring(2, length-4);
                    phoneArr[2] = back_phoneNumber.substring(length-4, length);
                }else{
                    phoneArr[1] = back_phoneNumber.substring(2, 6);
                    phoneArr[2] = back_phoneNumber.substring(6, length);
                }
            }else{
                //031, ....
                phoneArr[0] = back_phoneNumber.substring(0,3);
                if (length==3){
                    phoneArr[1] = "";
                    phoneArr[2] = "";
                }else if (length>3&&length<=7){
                    phoneArr[1] = back_phoneNumber.substring(3, length);
                    phoneArr[2] = "";
                }else if (length>7&&length<=11){
                    phoneArr[1] = back_phoneNumber.substring(3, length-4);
                    phoneArr[2] = back_phoneNumber.substring(length-4, length);
                }
                else {
                    phoneArr[1] = back_phoneNumber.substring(3, 7);
                    phoneArr[2] = back_phoneNumber.substring(7, length);
                }
            }
        }
        //지역번호 없는 경우
        else {
            phoneArr[0] = "";
            if (length <= 4) {
                phoneArr[1] = back_phoneNumber.substring(0);
                phoneArr[2] = "";
            } else {
                phoneArr[1] = back_phoneNumber.substring(0, 4);
                phoneArr[2] = back_phoneNumber.substring(4, length);
            }
        }
        return phoneArr;
    }
    public boolean localNumber(String back_phoneNumber){
        boolean result = false;
        int length = back_phoneNumber.length();
        if(length==2){
            if(back_phoneNumber.equals("02")) return true;
        }
        else if(length>2){
            if(back_phoneNumber.substring(0,2).equals("02")) return true;
            else if(back_phoneNumber.substring(0,3).equals("031")) return true;
            else if(back_phoneNumber.substring(0,3).equals("032")) return true;
            else if(back_phoneNumber.substring(0,3).equals("053")) return true;
            else if(back_phoneNumber.substring(0,3).equals("051")) return true;
            else if(back_phoneNumber.substring(0,3).equals("062")) return true;
            else if(back_phoneNumber.substring(0,3).equals("042")) return true;
            else if(back_phoneNumber.substring(0,3).equals("052")) return true;
            else if(back_phoneNumber.substring(0,3).equals("044")) return true;
            else if(back_phoneNumber.substring(0,3).equals("033")) return true;
            else if(back_phoneNumber.substring(0,3).equals("043")) return true;
            else if(back_phoneNumber.substring(0,3).equals("041")) return true;
            else if(back_phoneNumber.substring(0,3).equals("063")) return true;
            else if(back_phoneNumber.substring(0,3).equals("061")) return true;
            else if(back_phoneNumber.substring(0,3).equals("054")) return true;
            else if(back_phoneNumber.substring(0,3).equals("055")) return true;
            else if(back_phoneNumber.substring(0,3).equals("064")) return true;
            else if(back_phoneNumber.substring(0,3).equals("010")) return true;
            else if(back_phoneNumber.substring(0,3).equals("070")) return true;
        }
        return result;
    }
    public String toPhoneForm(String back_phoneNumber){
        String[] toPhoneArr = new String[3];
        int count = 0;
        for(String i:toPhoneFormArr(back_phoneNumber)){
            toPhoneArr[count++] = i;
        }

        //지역번호 없는경우
        if(toPhoneArr[0].isEmpty()){

            if(toPhoneArr[2].isEmpty()){
                return toPhoneArr[1];
            }
            else {
                return toPhoneArr[1] + "-" + toPhoneArr[2];
            }
        }
        //지역번호 있는경우
        else{
            if(toPhoneArr[2].isEmpty()&&toPhoneArr[1].isEmpty()){
                return toPhoneArr[0];
            }
            else if (toPhoneArr[2].isEmpty()&&!toPhoneArr[1].isEmpty()){
                return toPhoneArr[0] + "-" + toPhoneArr[1];
            }
            else{
                return toPhoneArr[0]+"-"+toPhoneArr[1]+"-"+toPhoneArr[2];
            }
        }


    }
}
