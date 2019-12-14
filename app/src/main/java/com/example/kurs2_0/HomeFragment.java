package com.example.kurs2_0;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment implements View.OnClickListener {
    public final static String TAG = "com.example.kurs2_0.HomeFragment";
    public static final String KEY = "data";

    TextView text1 ;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {


        View v = inflater.inflate(R.layout.fragment_home, null);
        text1 = v.findViewById(R.id.text1);
      //  String textFromActivity = getArguments().getString(KEY);
       // text1.setText(textFromActivity);
       // FloatingActionButton fab = v.findViewById(R.id.fab);
//        fab.setOnClickListener(this);

//    String textFromActivity = getArguments().getString(KEY);
 //   text1.setText(textFromActivity);

    return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {

    }


}
