package com.example.norkholis.recordtimbangan.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by norkholis on 3/10/2018.
 */

public class SharedPrefManager {
    public static final String SP_BMI_APP = "spBmiApp";
    public static final String SP_NAMA = "spName";
    public static final String SP_USERNAME = "spUsername";
    public static final String SP_ID = "spId";
    public static final String SP_TINGGI_BADAN = "spTinggiBadan";
    public static final String SP_BERATBADAN = "spBeratBadan";
    public static final String SP_BMR = "spBMR";
    public static final String SP_LAST_DATE = "spLastDate";

    public static final String SP_STATUS_LOGIN = "spStatusLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_BMI_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPFloat(String keySP, float value){
        spEditor.putFloat(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpNama(){
        return sp.getString(SP_NAMA,"");
    }

    public String getSpUsername(){
        return sp.getString(SP_USERNAME,"");
    }

    public String getSpLastDate(){
        return sp.getString(SP_LAST_DATE, "");
    }

    public float getSpTinggiBadan(){
        return sp.getFloat(SP_TINGGI_BADAN, 0);
    }

    public float getSpBeratBadan(){
        return sp.getFloat(SP_BERATBADAN, 0);
    }

    public float getSpBmr(){
        return  sp.getFloat(SP_BMR, 0);
    }

    public int getSpId() {
        return sp.getInt(SP_ID,0);
    }

    public Boolean getSpStatusLogin(){
        return sp.getBoolean(SP_STATUS_LOGIN,false);
    }

}
