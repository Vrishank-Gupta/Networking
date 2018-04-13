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
public class DistanceVector extends android.app.Fragment {

    String inputstr;
    public DistanceVector() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_distance_vector, container, false);
        final CodeView codeView = rootview.findViewById(R.id.codeviewdistancevector);
        final TextView textView = rootview.findViewById(R.id.textiewdistancevector);
        final TextView output = rootview.findViewById(R.id.outputdistancevector);
        final EditText input=rootview.findViewById(R.id.inputdistancevector);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol6);


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
                                        "public class DVR \n" +
                                        "{\n" +
                                        " static int graph[][];\n" +
                                        " static int via[][];\n" +
                                        " static int rt[][];\n" +
                                        " static int v;\n" +
                                        " static int e;\n" +
                                        "\n" +
                                        " public static void main(String args[]) throws IOException\n" +
                                        " {\n" +
                                        "  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n" +
                                        "  \n" +
                                        "  System.out.println(\"Please enter the number of Vertices: \");\n" +
                                        "  v = Integer.parseInt(br.readLine());\n" +
                                        "  \n" +
                                        "  System.out.println(\"Please enter the number of Edges: \");\n" +
                                        "  e = Integer.parseInt(br.readLine());\n" +
                                        "  \n" +
                                        "  graph = new int[v][v];\n" +
                                        "  via = new int[v][v];\n" +
                                        "  rt = new int[v][v];\n" +
                                        "  for(int i = 0; i < v; i++)\n" +
                                        "   for(int j = 0; j < v; j++)\n" +
                                        "   {\n" +
                                        "    if(i == j)\n" +
                                        "     graph[i][j] = 0;\n" +
                                        "    else\n" +
                                        "     graph[i][j] = 9999;\n" +
                                        "   }\n" +
                                        "  \n" +
                                        "  for(int i = 0; i < e; i++)\n" +
                                        "  {\n" +
                                        "   System.out.println(\"Please enter data for Edge \" + (i + 1) + \":\");\n" +
                                        "   System.out.print(\"Source: \");\n" +
                                        "   int s = Integer.parseInt(br.readLine());\n" +
                                        "   s--;\n" +
                                        "   System.out.print(\"Destination: \");\n" +
                                        "   int d = Integer.parseInt(br.readLine());\n" +
                                        "   d--;\n" +
                                        "   System.out.print(\"Cost: \");\n" +
                                        "   int c = Integer.parseInt(br.readLine());\n" +
                                        "   graph[s][d] = c;\n" +
                                        "   graph[d][s] = c;\n" +
                                        "  }\n" +
                                        "  \n" +
                                        "  dvr_calc_disp(\"The initial Routing Tables are: \");\n" +
                                        "  \n" +
                                        "  System.out.print(\"Please enter the Source Node for the edge whose cost has changed: \");\n" +
                                        "  int s = Integer.parseInt(br.readLine());\n" +
                                        "  s--;\n" +
                                        "  System.out.print(\"Please enter the Destination Node for the edge whose cost has changed: \");\n" +
                                        "  int d = Integer.parseInt(br.readLine());\n" +
                                        "  d--;\n" +
                                        "  System.out.print(\"Please enter the new cost: \");\n" +
                                        "  int c = Integer.parseInt(br.readLine());\n" +
                                        "  graph[s][d] = c;\n" +
                                        "  graph[d][s] = c;\n" +
                                        "  \n" +
                                        "  dvr_calc_disp(\"The new Routing Tables are: \");\n" +
                                        " }\n" +
                                        " \n" +
                                        " static void dvr_calc_disp(String message)\n" +
                                        " {\n" +
                                        "  System.out.println();\n" +
                                        "  init_tables();\n" +
                                        "  update_tables();\n" +
                                        "  System.out.println(message);\n" +
                                        "  print_tables();\n" +
                                        "  System.out.println();\n" +
                                        " }\n" +
                                        " \n" +
                                        " static void update_table(int source)\n" +
                                        " {\n" +
                                        "  for(int i = 0; i < v; i++)\n" +
                                        "  {\n" +
                                        "   if(graph[source][i] != 9999)\n" +
                                        "   {\n" +
                                        "    int dist = graph[source][i];\n" +
                                        "    for(int j = 0; j < v; j++)\n" +
                                        "    {\n" +
                                        "     int inter_dist = rt[i][j];\n" +
                                        "     if(via[i][j] == source)\n" +
                                        "      inter_dist = 9999;\n" +
                                        "     if(dist + inter_dist < rt[source][j])\n" +
                                        "     {\n" +
                                        "      rt[source][j] = dist + inter_dist;\n" +
                                        "      via[source][j] = i;\n" +
                                        "     }\n" +
                                        "    }\n" +
                                        "   }\n" +
                                        "  }\n" +
                                        " }\n" +
                                        " \n" +
                                        " static void update_tables()\n" +
                                        " {\n" +
                                        "  int k = 0;\n" +
                                        "  for(int i = 0; i < 4*v; i++)\n" +
                                        "  {\n" +
                                        "   update_table(k);\n" +
                                        "   k++;\n" +
                                        "   if(k == v)\n" +
                                        "    k = 0;\n" +
                                        "  }\n" +
                                        " }\n" +
                                        " \n" +
                                        " static void init_tables()\n" +
                                        " {\n" +
                                        "  for(int i = 0; i < v; i++)\n" +
                                        "  {\n" +
                                        "   for(int j = 0; j < v; j++)\n" +
                                        "   {\n" +
                                        "    if(i == j)\n" +
                                        "    {\n" +
                                        "     rt[i][j] = 0;\n" +
                                        "     via[i][j] = i;\n" +
                                        "    }\n" +
                                        "    else\n" +
                                        "    {\n" +
                                        "     rt[i][j] = 9999;\n" +
                                        "     via[i][j] = 100;\n" +
                                        "    }\n" +
                                        "   }\n" +
                                        "  }\n" +
                                        " }\n" +
                                        " \n" +
                                        " static void print_tables()\n" +
                                        " {\n" +
                                        "  for(int i = 0; i < v; i++)\n" +
                                        "  {\n" +
                                        "   for(int j = 0; j < v; j++)\n" +
                                        "   {\n" +
                                        "    System.out.print(\"Dist: \" + rt[i][j] + \"    \");\n" +
                                        "   }\n" +
                                        "   System.out.println();\n" +
                                        "  }\n" +
                                        " }\n" +
                                        " \n" +
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
