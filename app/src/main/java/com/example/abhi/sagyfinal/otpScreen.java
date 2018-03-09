package com.example.abhi.sagyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class otpScreen extends AppCompatActivity {
    EditText otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);

        otp=(EditText)findViewById(R.id.otpcode);

        otpchecker();
    }

    public  void otpchecker(){
      int otpcode= Integer.parseInt(otp.getText().toString());

      if(otpcode==register.otpnumber)
      {
          Intent i=new Intent(otpScreen.this,login.class);
          startActivity(i);
      }
      else{
              otp.setError("wrong otp code");

    }
    }
}
