package com.example.abhi.sagyfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhi on 10-02-2018.
 */

public class databasehelper extends SQLiteOpenHelper {
    public static final String db_name="sagyrecords",tablename="newRegisterations",col2="username",col3="aadhaar",col4="email",
            col5="phone",col6="password";

    public databasehelper(Context context) {
        super(context, db_name, null ,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tablename+"(id integer primary key autoincrement,username varchar,aadhaar varchar,email varchar ,phone varchar,password varchar);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+tablename+";");
        onCreate(db);
    }

    public boolean insertdata(String username,String aadhaar,String email,String phone,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put(col2,username);
        c.put(col3,aadhaar);
        c.put(col4,email);
        c.put(col5,phone);
        c.put(col6,password);
       long result= db.insert(tablename,null,c);
       if(result==-1)
        return false;
    else
        return true;


    }

    public Cursor findrecord(String username11 ){

        SQLiteDatabase db=this.getReadableDatabase();
          //Cursor c=db.rawQuery("select * from " +tablename ,null);
         Cursor c=db.rawQuery("select * from " +tablename+ " where "+col2+" = 'himanshu' ;",null);
        return c;


    }


}
