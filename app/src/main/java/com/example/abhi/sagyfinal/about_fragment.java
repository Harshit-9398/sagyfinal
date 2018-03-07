package com.example.abhi.sagyfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class about_fragment extends Fragment {

Button read;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_fragment, null);
    }

    @Override
     public void onViewCreated(View view,Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        read=(Button) view.findViewById(R.id.button);

read.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    Intent i=new Intent(getActivity(),web_view.class);
    startActivity(i);

        }
});

    }


}
