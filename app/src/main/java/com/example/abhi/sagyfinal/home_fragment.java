package com.example.abhi.sagyfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class home_fragment extends Fragment {

Button b1;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             @Nullable  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragment, null);
    }


    public  void onViewCreated(View view, @Nullable  Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        b1=(Button)view.findViewById(R.id.homepagebutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "u r on home screen fragment", Toast.LENGTH_SHORT).show();
            }
        });
    }
}