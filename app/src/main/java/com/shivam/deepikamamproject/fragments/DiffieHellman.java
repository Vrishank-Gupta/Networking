package com.shivam.deepikamamproject.fragments;


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
public class DiffieHellman extends android.app.Fragment {

    String inputstr;
    public DiffieHellman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_diffie_hellman, container, false);
        final CodeView codeView = rootview.findViewById(R.id.codeviewdiffiehellman);
        final TextView textView = rootview.findViewById(R.id.textiewdiffiehellman);
        final TextView output = rootview.findViewById(R.id.outputdiffiehellman);
        final EditText input=rootview.findViewById(R.id.inputdiffiehellman);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol7);


        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                scroll1.setVisibility(View.VISIBLE);
                                input.setVisibility(View.GONE);
                                output.setVisibility(View.GONE);
                                textView.setVisibility(View.VISIBLE);
                                codeView.setVisibility(View.GONE);
                                break;
                            case R.id.code:
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                input.setVisibility(View.GONE);
                                output.setVisibility(View.GONE);
                                codeView.setVisibility(View.VISIBLE);
                                codeView.setCode("import java.io.*;\n" +
                                        "import java.math.BigInteger;\n" +
                                        "\n" +
                                        "public class Deffie_Hellman {\n" +
                                        " \n" +
                                        " public static void main(String[]args)throws IOException\n" +
                                        "    {\n" +
                                        "        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));\n" +
                                        "        System.out.println(\"Enter prime number:\");\n" +
                                        "        BigInteger p=new BigInteger(br.readLine());\n" +
                                        "        System.out.print(\"Enter primitive root of \"+p+\":\");\n" +
                                        "        BigInteger g=new BigInteger(br.readLine());\n" +
                                        "        System.out.println(\"Enter value for x less than \"+p+\":\");\n" +
                                        "        BigInteger x=new BigInteger(br.readLine());\n" +
                                        "        BigInteger R1=g.modPow(x,p);\n" +
                                        "        System.out.println(\"R1=\"+R1);\n" +
                                        "        System.out.print(\"Enter value for y less than \"+p+\":\");\n" +
                                        "        BigInteger y=new BigInteger(br.readLine());\n" +
                                        "        BigInteger R2=g.modPow(y,p);\n" +
                                        "        System.out.println(\"R2=\"+R2);\n" +
                                        "        BigInteger k1=R2.modPow(x,p);\n" +
                                        "        System.out.println(\"Key calculated at Alice's side:\"+k1);\n" +
                                        "        BigInteger k2=R1.modPow(y,p);\n" +
                                        "        System.out.println(\"Key calculated at Bob's side:\"+k2);\n" +
                                        "        System.out.println(\"deffie hellman secret key Encryption has Taken\");\n" +
                                        "    }\n" +
                                        "\n" +
                                        "}\n");
                                codeView.getOptions().setTheme(ColorTheme.SOLARIZED_LIGHT);

                                break;
                            case R.id.tryit:
                                scroll1.setVisibility(View.GONE);
                                input.setVisibility(View.VISIBLE);
                                output.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.GONE);
                                codeView.setVisibility(View.GONE);
                                inputstr=input.getText().toString();
                                break;
                        }
                        return false;
                    }
                });

        return  rootview;}

}


