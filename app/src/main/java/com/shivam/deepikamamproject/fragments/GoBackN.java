package com.shivam.deepikamamproject.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shivam.deepikamamproject.R;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.highlight.ColorTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoBackN extends android.app.Fragment {

    String inputstr;
    public GoBackN() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_go_back_n, container, false);
        final TextView textView = rootview.findViewById(R.id.textiewgobackn);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol5);



        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;
                            case R.id.code:
//                                String url = "http://www.example.com";
//                                Intent i = new Intent(Intent.ACTION_VIEW);
//                                i.setData(Uri.parse(url));
//                                startActivity(i);
//                                break;
                        }
                        return false;
                    }
                });

        return  rootview;}

}
