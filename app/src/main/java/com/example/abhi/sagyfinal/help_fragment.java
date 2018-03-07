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
import android.widget.Toast;

public class help_fragment extends Fragment {

    Button b1,web;
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

        b1=(Button)view.findViewById(R.id.help_button);
        web=(Button)view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"u r on help fragment",Toast.LENGTH_SHORT).show();

            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("http://saanjhi.gov.in/");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);

            }
        });


    }
}
