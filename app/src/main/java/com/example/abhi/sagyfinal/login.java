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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        b1=(Button)findViewById(R.id.login_button);

        b2=(Button)findViewById(R.id.temppbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login.this,phonenoauth.class);
                startActivity(i);
            }
        });


       b1.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {


               try {
                   String username1 = username.getText().toString();
                   String password1 = password.getText().toString();
                   if (username1.isEmpty()) {
                       username.setError("enter valid username");
                       username.requestFocus();
                       return;
                   }
                   if (password1.length() < 6) {
                       password.setError("min length 6 chars");
                       password.requestFocus();
                       return;
                   }
                   logindemo();
               }catch(Exception e) {
                   Toast.makeText(login.this, ""+e, Toast.LENGTH_SHORT).show();
               }
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
    public void logindemo() {
        StringRequest st = new StringRequest(Request.Method.POST, "https://wwwapktreegq.000webhostapp.com/webservices/login_with_app_Register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                getStatus(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String,String> getParams() {
                Map<String, String>mp = new HashMap<String, String>();
                mp.put("UserName",username.getText().toString());
                mp.put("Password",password.getText().toString());
                return mp;
            }
        };
        RequestQueue q = Volley.newRequestQueue(login.this);
        q.add(st);
    }
    public void getStatus(String stt) {
        try {
            JSONObject obj = new JSONObject(stt);
            String res = obj.getString("status");
            if(res.equals("1")) {
                SharedPreferences sp=getSharedPreferences("userinfo",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.putString("username",username.getText().toString());
                e.putString("password",password.getText().toString());
                e.commit();
                Intent i = new Intent(login.this, home_page.class);
                startActivity(i);
                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Toast.makeText(login.this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
    }
}
