package com.example.abhi.sagyfinal;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
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
import java.util.Random;

import static java.lang.Thread.sleep;

public class register extends AppCompatActivity {

    EditText us, adhrno, mail, pno, pwd, cpwd;
    Button reg;
    databasehelper d;

    static int otpnumber;
    String phone;
    String message;
    int MY_PERMISSIONS_REQUEST_SENDSMS=1;
    //otp generation


    // public static final String db_name="sagyrecords",tablename="newRegisterations",col2="username",col3="aadhaar",col4="email",col5="phone",col6="password";


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

        phone = pno.getText().toString();


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registering();

                otpgeneration();
                //   Intent i = new Intent(register.this, login.class);
                //   startActivity(i);
            }
        });
    }
  /*  public void sendData(){
        StringRequest st = new StringRequest(Request.Method.POST, "http://studentstation.ml/webservices/insertData_without_image.php", new Response.Listener<String>() {
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
    }*/


    public void otpgeneration() {

        Random random = new Random();
        otpnumber = random.nextInt(999);
        message="your one time password (otp) is "+otpnumber;


            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SENDSMS);
            } else {

               // SmsManager sms = SmsManager.getDefault();
                //sms.sendTextMessage(phone, null, message, null, null);
               //  Intent i = new Intent(register.this,otpScreen.class);
                //startActivity(i);
                Toast.makeText(this,"i am runing",Toast.LENGTH_SHORT).show();


        }

}

public  void registering(){
    String uname = us.getText().toString();
    String adhr = adhrno.getText().toString();
    String email = mail.getText().toString();
    String phone = pno.getText().toString();
    String pass = pwd.getText().toString();
    String cpass = cpwd.getText().toString();


            if ((uname.isEmpty())||(adhr.isEmpty())||(email.isEmpty())||(phone.isEmpty())||(pass.isEmpty())||(cpass.isEmpty()))
                Toast.makeText(register.this,"fill details correctly",Toast.LENGTH_SHORT).show();
            else
            {

                if(!pass.equals(cpass))
                {cpwd.setError("passwords doesnot match");
                cpwd.requestFocus();}

        /*        boolean b=d.insertdata();
                if(b==true)
                    Toast.makeText(MainActivity.this,"row inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
            clr();

        }

        public void clr()
        {
            name.setText("");
            surname.setText("");
            marks.setText("");
            name.requestFocus();

        }
    });
}*/

}}}