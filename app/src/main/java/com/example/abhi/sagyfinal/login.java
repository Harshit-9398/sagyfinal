package com.example.abhi.sagyfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class login extends AppCompatActivity {
    EditText username,password;
    TextView not_registered_yet;
    CheckBox keep_me_logedin;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        not_registered_yet=(TextView)findViewById(R.id.t1);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        keep_me_logedin=(CheckBox)findViewById(R.id.keep_me_logedin);
        b1=(Button)findViewById(R.id.login_button);
        b2=(Button)findViewById(R.id.temppbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login.this,home_page.class);
                startActivity(i);
            }
        });


       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               String username1=username.getText().toString();
               String password1=password.getText().toString();

               if(username1.isEmpty())
               {
                   username.setError("enter valid username");
                   username.requestFocus();
                   return;
               }
               if(password1.length()<6)
               {
                   password.setError("min length 6 chars");
                   password.requestFocus();
                   return;
               }

               if(keep_me_logedin.isChecked()==true)
               {
                   SharedPreferences sp=getSharedPreferences("userinfo",MODE_PRIVATE);
                   SharedPreferences.Editor e=sp.edit();
                   e.putString("username",username1);
                   e.putString("password",password1);
                   e.commit();
               }

               Intent i=new Intent(login.this,home_page.class);
               startActivity(i);
           }
       });



        not_registered_yet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login.this,register.class);
                startActivity(i);

            }
        });
    }
}
