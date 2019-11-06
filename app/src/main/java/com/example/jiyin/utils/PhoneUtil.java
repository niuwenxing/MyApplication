package com.example.jiyin.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.example.rootlib.utils.Contacts.IndexableEntity;

import java.util.ArrayList;
import java.util.List;

public class PhoneUtil {

    // 号码
    public final static String NUM = ContactsContract.CommonDataKinds.Phone.NUMBER;
    // 联系人姓名
    public final static String NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;

    //上下文对象
    private Context context;
    //联系人提供者的uri
    private Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

    public PhoneUtil(Context context){
        this.context = context;
    }

    //获取所有联系人
    public List<PhoneDto> getPhone(){
        List<PhoneDto> phoneDtos = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor cursor = cr.query(phoneUri,new String[]{NUM,NAME},null,null,null);
        while (cursor.moveToNext()){
            PhoneDto phoneDto = new PhoneDto(cursor.getString(cursor.getColumnIndex(NAME)),cursor.getString(cursor.getColumnIndex(NUM)));
            phoneDtos.add(phoneDto);
        }
        return phoneDtos;
    }


    public class PhoneDto implements IndexableEntity {
        private String name;        //联系人姓名
        private String telPhone;    //电话号码
        private String pinyin;

        private Boolean isSelect=false;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTelPhone() {
            return telPhone;
        }
        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }


        public void setTelPhone(String telPhone) {
            this.telPhone = telPhone;
        }

        public PhoneDto() {
        }

        public PhoneDto(String name, String telPhone) {
            this.name = name;
            this.telPhone = telPhone;
        }

        @Override
        public String getFieldIndexBy() {
            return name;
        }

        @Override
        public void setFieldIndexBy(String indexField) {
            this.name = indexField;
        }

        @Override
        public void setFieldPinyinIndexBy(String pinyin) {
            this.pinyin = pinyin;
        }
    }

}
