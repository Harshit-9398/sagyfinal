package com.example.abhi.sagyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    EditText us, adhrno, mail, pno, pwd, cpwd;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg = findViewById(R.id.reg);
        us = findViewById(R.id.uname);
        adhrno = findViewById(R.id.adhr);
        mail = findViewById(R.id.email);
        pno = findViewById(R.id.pno);
        pwd = findViewById(R.id.password);
        cpwd = findViewById(R.id.cpass);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
                Intent i = new Intent(register.this, login.class);
                startActivity(i);
            }
        });
    }
    public void sendData(){
        StringRequest st = new StringRequest(Request.Method.POST, "https://wwwapktreegq.000webhostapp.com/webservices/insertData_without_image_in_app_Register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(register.this, "" + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(register.this, "Error="+error, Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String,String>getParams() {
                Map<String,String> mp = null;
                try{
                String uname = us.getText().toString();
                String adhr = adhrno.getText().toString();
                String email = mail.getText().toString();
                String phone = pno.getText().toString();
                String pass = pwd.getText().toString();
                String cpass = cpwd.getText().toString();
                if(pass.equals(cpass)){
                    mp = new HashMap<String,String>();
                    mp.put("UserName", uname);
                    mp.put("Aadhaar", adhr);
                    mp.put("Mail", email);
                    mp.put("Phone", phone);
                    mp.put("Password", pass);
                }
                else
                    Toast.makeText(register.this, "Enter correct password", Toast.LENGTH_LONG).show();
            }catch(Exception e){
                    Toast.makeText(register.this, ""+e, Toast.LENGTH_SHORT).show();
                }
                return mp;
            }
        };
        RequestQueue q = Volley.newRequestQueue(register.this);
        q.add(st);
    }
}