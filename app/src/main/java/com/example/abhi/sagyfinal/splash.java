package com.example.abhi.sagyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread th=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                    Intent i=new Intent(splash.this,login.class);
                    startActivity(i);

                }
                catch(Exception e)
                {}
                finally {
                    finish();
                }
            }
        };
        th.start();

    }
}
