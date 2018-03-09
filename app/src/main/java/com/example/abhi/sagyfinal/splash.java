package com.example.abhi.sagyfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {
    String saved_username;
    String saved_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                userinfo();
            }
        }, 3000);

//        Thread th=new Thread(){
//            public void run(){
//                try{
//                    sleep(3000);
//
//                    userinfo();
//
//
//                }
//                catch(Exception e)
//                {}
//                finally {
//                    finish();
//                }
//            }
//        };
//        th.start();

    }

    public void userinfo()
    {
        SharedPreferences sp=getSharedPreferences("userinfo",MODE_PRIVATE);
        saved_username=sp.getString("username",null);
        saved_password=sp.getString("password",null);

        if(saved_username!=null&&saved_password!=null)
        {
            Intent i=new Intent(splash.this,home_page.class);
            startActivity(i);
        }
        else {
            Intent i=new Intent(splash.this,login.class);
            startActivity(i);
        }
        }
    }

