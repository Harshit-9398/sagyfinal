package com.example.abhi.sagyfinal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class help_fragment extends Fragment {

    Button b1,b2;
    EditText ed1;
    String sfrom;
    String sto="harshit@gmail.com";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_fragment, null);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        b2=(Button) view.findViewById(R.id.b1);
      b1=(Button) view.findViewById(R.id.button1);
      ed1=(EditText)view.findViewById(R.id.et);

      b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              sfrom=ed1.getText().toString();
             //String from1[]={sfrom};
              String to1[]={sto,sfrom};
              sendEmail(to1);
          }

      }
      );
      b2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8118808259"));
              startActivity(i);
          }
      });

    }
    public void sendEmail(String[] to1)
    { //String from[]= from1;
    String to[]=to1;
    Intent i =new Intent(Intent.ACTION_SEND);
    i.putExtra(Intent.EXTRA_EMAIL, to);
i.setData(Uri.parse("mailto:harshitmharshi@gmail.com"));
i.setType("text/plain");
    i.setType("message/rfc467");
    startActivity(Intent.createChooser(i,"send via"));
    }
}
