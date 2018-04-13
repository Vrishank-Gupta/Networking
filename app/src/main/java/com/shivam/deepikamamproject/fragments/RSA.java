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
public class RSA extends android.app.Fragment {

    String inputstr;
    public RSA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_r, container, false);

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);
        final CodeView codeView = rootview.findViewById(R.id.codeviewrsa);
        final TextView textView = rootview.findViewById(R.id.textiewrsa);
        final TextView output = rootview.findViewById(R.id.outputrsa);
        final EditText input=rootview.findViewById(R.id.inputrsa);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol3);


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
                                codeView.setCode("import java.io.DataInputStream;\n" +
                                        "import java.io.IOException;\n" +
                                        "import java.math.BigInteger;\n" +
                                        "import java.util.Random;\n" +
                                        "\n" +
                                        "\n" +
                                        "public class RSA\n" +
                                        "{\n" +
                                        "\tprivate BigInteger p;\n" +
                                        "    private BigInteger q;\n" +
                                        "    private BigInteger N;\n" +
                                        "    private BigInteger phi;\n" +
                                        "    private BigInteger e;\n" +
                                        "    private BigInteger d;\n" +
                                        "    private int        bitlength = 1024;\n" +
                                        "    private Random     r;\n" +
                                        " \n" +
                                        "    public RSA()\n" +
                                        "    {\n" +
                                        "        r = new Random();\n" +
                                        "        p = BigInteger.probablePrime(bitlength, r);\n" +
                                        "        q = BigInteger.probablePrime(bitlength, r);\n" +
                                        "        N = p.multiply(q);\n" +
                                        "        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));\n" +
                                        "        e = BigInteger.probablePrime(bitlength / 2, r);\n" +
                                        "        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)\n" +
                                        "        {\n" +
                                        "            e.add(BigInteger.ONE);\n" +
                                        "        }\n" +
                                        "        d = e.modInverse(phi);\n" +
                                        "    }\n" +
                                        " \n" +
                                        "    public RSA(BigInteger e, BigInteger d, BigInteger N)\n" +
                                        "    {\n" +
                                        "        this.e = e;\n" +
                                        "        this.d = d;\n" +
                                        "        this.N = N;\n" +
                                        "    }\n" +
                                        " \n" +
                                        "    @SuppressWarnings(\"deprecation\")\n" +
                                        "    public static void main(String[] args) throws IOException\n" +
                                        "    {\n" +
                                        "        RSA rsa = new RSA();\n" +
                                        "        DataInputStream in = new DataInputStream(System.in);\n" +
                                        "        String teststring;\n" +
                                        "        System.out.println(\"Enter the plain text:\");\n" +
                                        "        teststring = in.readLine();\n" +
                                        "        System.out.println(\"Encrypting String: \" + teststring);\n" +
                                        "        System.out.println(\"String in Bytes: \"\n" +
                                        "                + bytesToString(teststring.getBytes()));\n" +
                                        "        // encrypt\n" +
                                        "        byte[] encrypted = rsa.encrypt(teststring.getBytes());\n" +
                                        "        // decrypt\n" +
                                        "        byte[] decrypted = rsa.decrypt(encrypted);\n" +
                                        "        System.out.println(\"Decrypting Bytes: \" + bytesToString(decrypted));\n" +
                                        "        System.out.println(\"Decrypted String: \" + new String(decrypted));\n" +
                                        "    }\n" +
                                        " \n" +
                                        "    private static String bytesToString(byte[] encrypted)\n" +
                                        "    {\n" +
                                        "        String test = \"\";\n" +
                                        "        for (byte b : encrypted)\n" +
                                        "        {\n" +
                                        "            test += Byte.toString(b);\n" +
                                        "        }\n" +
                                        "        return test;\n" +
                                        "    }\n" +
                                        " \n" +
                                        "    // Encrypt message\n" +
                                        "    public byte[] encrypt(byte[] message)\n" +
                                        "    {\n" +
                                        "        return (new BigInteger(message)).modPow(e, N).toByteArray();\n" +
                                        "    }\n" +
                                        " \n" +
                                        "    // Decrypt message\n" +
                                        "    public byte[] decrypt(byte[] message)\n" +
                                        "    {\n" +
                                        "        return (new BigInteger(message)).modPow(d, N).toByteArray();\n" +
                                        "    }\n" +
                                        "}");
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

        return  rootview;
    }

}
