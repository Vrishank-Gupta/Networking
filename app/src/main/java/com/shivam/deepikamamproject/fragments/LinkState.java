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
public class LinkState extends android.app.Fragment {

    String inputstr;
    public LinkState() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_link_state, container, false);

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);
        final CodeView codeView = rootview.findViewById(R.id.codeviewlinkstate);
        final TextView textView = rootview.findViewById(R.id.textiewlinkstate);
        final TextView output = rootview.findViewById(R.id.outputlinkstate);
        final  EditText input=rootview.findViewById(R.id.inputlinkstate);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol4);


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
                                        "import java.util.PriorityQueue;\n" +
                                        "import java.util.List;\n" +
                                        "import java.util.Arrays;\n" +
                                        "import java.util.ArrayList;\n" +
                                        "import java.util.Collections;\n" +
                                        "import java.util.Scanner;\n" +
                                        "import java.util.Comparator;\n" +
                                        "import java.util.Iterator;\n" +
                                        "\n" +
                                        "class Vertex implements Comparable<Vertex>{\n" +
                                        "    public final String name;\n" +
                                        "    public ArrayList<Edge> adjacencies;\n" +
                                        "    public int minDistance = Integer.MAX_VALUE;\n" +
                                        "    public Vertex previous;\n" +
                                        "\t\n" +
                                        "    public Vertex(String argName){\n" +
                                        "\t\tname = argName;\n" +
                                        "\t}\n" +
                                        "    public String toString(){\n" +
                                        "\t\treturn name;\n" +
                                        "\t}\n" +
                                        "    public int compareTo(Vertex other){\n" +
                                        "        return Integer.compare(minDistance, other.minDistance);\n" +
                                        "    }\n" +
                                        "}\n" +
                                        "\n" +
                                        "class Edge{\n" +
                                        "    public final Vertex target;\n" +
                                        "    public final int cost;\n" +
                                        "\t\n" +
                                        "    public Edge(Vertex argTarget, int argCost){\n" +
                                        "\t\ttarget = argTarget; cost = argCost;\n" +
                                        "\t}\n" +
                                        "}\n" +
                                        "\n" +
                                        "// for sorting\n" +
                                        "class CustomComparator implements Comparator<Vertex> {\n" +
                                        "    @Override\n" +
                                        "    public int compare(Vertex v1, Vertex v2){\n" +
                                        "        return v1.name.compareTo(v2.name);\n" +
                                        "    }\n" +
                                        "}\n" +
                                        "\n" +
                                        "class LSRCompute{\n" +
                                        "    public static void computePaths(Vertex source) {\n" +
                                        "        source.minDistance = 0;\n" +
                                        "\t\t\n" +
                                        "        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();\n" +
                                        "        vertexQueue.add(source);\n" +
                                        "\n" +
                                        "        while (!vertexQueue.isEmpty()) {\n" +
                                        "\t\t/*\n" +
                                        "\t\tIterator<Vertex> iterator = vertexQueue.iterator();\n" +
                                        "\t\tSystem.out.print(\"queue: \");\n" +
                                        "\t\twhile(iterator.hasNext()){\n" +
                                        "\t\t\tSystem.out.print (iterator.next().toString() + \" \");\n" +
                                        "\t\t}\n" +
                                        "\t\tSystem.out.println();*/\n" +
                                        "\t\t\n" +
                                        "            Vertex u = vertexQueue.poll();\n" +
                                        "\t\t/*\n" +
                                        "\t\titerator = vertexQueue.iterator();\n" +
                                        "\t\tSystem.out.print(\"after queue: \");\n" +
                                        "\t\twhile(iterator.hasNext()){\n" +
                                        "\t\t\tSystem.out.print (iterator.next().toString() + \" \");\n" +
                                        "\t\t}\n" +
                                        "\t\tSystem.out.println();\n" +
                                        "\t\t*/\n" +
                                        "\t\t\t\n" +
                                        "            //System.out.print(\"u: \"+u);\n" +
                                        "            // Visit each edge exiting u\n" +
                                        "            for (Edge e : u.adjacencies){\n" +
                                        "                //System.out.print(\" e: \"+e.target.name);\n" +
                                        "                Vertex v = e.target;\n" +
                                        "                int cost = e.cost;\n" +
                                        "                int distanceThroughU = u.minDistance + cost;\n" +
                                        "                if (distanceThroughU < v.minDistance) {\n" +
                                        "                    vertexQueue.remove(v);\n" +
                                        "\n" +
                                        "                    v.minDistance = distanceThroughU ;\n" +
                                        "                    v.previous = u;\n" +
                                        "                    vertexQueue.add(v);\n" +
                                        "                }\n" +
                                        "            }\n" +
                                        "        }\n" +
                                        "    }\n" +
                                        "\t\n" +
                                        "    public static List<Vertex> getShortestPathTo(Vertex target) {\n" +
                                        "        List<Vertex> path = new ArrayList<Vertex>();\n" +
                                        "        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)\n" +
                                        "            path.add(vertex);\n" +
                                        "\n" +
                                        "        Collections.reverse(path);\n" +
                                        "        return path;\n" +
                                        "    }\n" +
                                        "\n" +
                                        "\n" +
                                        "    public static void main(String[] args){\n" +
                                        "        String[] nodeName = {\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\",\"H\",\"I\",\"J\",\"K\",\"L\",\"M\",\"N\",\"O\",\"P\",\"Q\",\"R\",\"S\",\"T\",\"U\",\"V\",\"W\",\"X\",\"Y\",\"Z\"};\n" +
                                        "\n" +
                                        "        int totalNodes = 0;\n" +
                                        "        int i = 0;\n" +
                                        "        int j = 0;\n" +
                                        "\n" +
                                        "        try{\n" +
                                        "            LineNumberReader lnr = new LineNumberReader(new FileReader(new File(\"routes.lsa\")));\n" +
                                        "            lnr.skip(Long.MAX_VALUE);\n" +
                                        "            //totalNodes = lnr.getLineNumber() + 1; //Add 1 because line index starts at 0\n" +
                                        "            totalNodes = lnr.getLineNumber();\n" +
                                        "            lnr.close();\n" +
                                        "        }catch(Exception e){//Catch exception if any\n" +
                                        "            System.err.println(\"Errors: \" + e.getMessage());\n" +
                                        "        }\n" +
                                        "\n" +
                                        "        // create all nodes by total number\n" +
                                        "        ArrayList<Vertex> tmpVertex = new ArrayList<Vertex>();\n" +
                                        "\t\t\n" +
                                        "        for(i=0; i<totalNodes; i++){\n" +
                                        "            // create new node(A,B,C...), assign it into tmpVertex\n" +
                                        "            tmpVertex.add(new Vertex(nodeName[i]));\n" +
                                        "        }\n" +
                                        "\n" +
                                        "        try{\n" +
                                        "            // Open the file\n" +
                                        "            FileInputStream fstream = new FileInputStream(args[0]);\n" +
                                        "            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));\n" +
                                        "\n" +
                                        "            String strLine;\n" +
                                        "            i = 0;\n" +
                                        "            //Read File Line By Line, for create neighbors\n" +
                                        "            while ((strLine = br.readLine()) != null){\n" +
                                        "                // split by spaces store in aLineOfrecord\n" +
                                        "                String[] aLineOfrecord = strLine.split(\"\\\\s+\");\n" +
                                        "\n" +
                                        "                // create neighbors array\n" +
                                        "                ArrayList<Edge> tmpNB = new ArrayList<Edge>();\n" +
                                        "\n" +
                                        "                for(int neighbors=1; neighbors<aLineOfrecord.length; neighbors++){ // start at 1, exclude 0(newNode itself)\n" +
                                        "                    int nb = Arrays.asList(nodeName).indexOf( aLineOfrecord[neighbors].substring(0,1)); // take out the neighbor as alphabet\n" +
                                        "                    int cost = Integer.parseInt( aLineOfrecord[neighbors].substring(2,3) );  // take the neighbor cost\n" +
                                        "                    tmpNB.add( new Edge(tmpVertex.get(nb), cost) );  // add into the neighbor array\n" +
                                        "                }\n" +
                                        "                tmpVertex.get(j++).adjacencies = tmpNB;  // make the relation betwwen the newNode and its neighbors\n" +
                                        "            }\n" +
                                        "\n" +
                                        "            //Close the input stream\n" +
                                        "            br.close();\n" +
                                        "        }\n" +
                                        "        catch(Exception e){//Catch exception if any\n" +
                                        "            System.err.println(\"Errorss: \" + e.getMessage());\n" +
                                        "        }\n" +
                                        "\n" +
                                        "        int src = 0;\n" +
                                        "        src = Arrays.asList(nodeName).indexOf( args[1] );\n" +
                                        "\n" +
                                        "        switch( args[2].toUpperCase() ){\n" +
                                        "            case \"CA\":  // compute all nodes\n" +
                                        "                while(true){\n" +
                                        "                    computePaths(tmpVertex.get(src));  // recompute the shortest path\n" +
                                        "                    System.out.println( \"Source \" + tmpVertex.get(src) + \":\" );\n" +
                                        "\n" +
                                        "\t\t\t\t\tfor (Vertex v : tmpVertex) {  // print out all the shortest paths of each node\n" +
                                        "                        if(v!=tmpVertex.get(src)){\n" +
                                        "\t\t\t\t\t\t\tSystem.out.print( v + \": \" );\n" +
                                        "\t\t\t\t\t\t\tList<Vertex> path = getShortestPathTo(v);\n" +
                                        "\t\t\t\t\t\t\tSystem.out.print(\"Path: \");\n" +
                                        "\t\t\t\t\t\t\tfor(i = 0; i < path.size(); i++) {\n" +
                                        "\t\t\t\t\t\t\t\tSystem.out.print( path.get(i) );\n" +
                                        "\t\t\t\t\t\t\t\tif (i<path.size()-1)\n" +
                                        "\t\t\t\t\t\t\t\t\tSystem.out.print( \">\" );\n" +
                                        "\t\t\t\t\t\t\t}\n" +
                                        "\t\t\t\t\t\t\tSystem.out.println(\" Cost:\"+ v.minDistance);\n" +
                                        "\t\t\t\t\t\t}\n" +
                                        "\t\t\t\t\t}\n" +
                                        "                    printAllrela(tmpVertex);    // print out all nodes relations\n" +
                                        "                    addNode(tmpVertex, nodeName); // for add or delete nodes\n" +
                                        "\n" +
                                        "                    for (Vertex allnodes : tmpVertex){ // reset all the distance\n" +
                                        "                        allnodes.minDistance = Integer.MAX_VALUE;\n" +
                                        "                    }\n" +
                                        "\n" +
                                        "\t\t\t\t\tpressAnyKeyToContinue();\n" +
                                        "\t\t\t\t}\n" +
                                        "                //break;\n" +
                                        "\n" +
                                        "            case \"SS\":  // print a specific node\n" +
                                        "                while(true){\n" +
                                        "                    computePaths(tmpVertex.get(src));  // recompute the shortest path\n" +
                                        "                    System.out.println( \"Source \" + tmpVertex.get(src) + \":\" );\n" +
                                        "\n" +
                                        "                    System.out.print(\"To which node? \");\n" +
                                        "                    Scanner sc = new Scanner(System.in);\n" +
                                        "                    String inputDes = sc.next().toUpperCase();\n" +
                                        "\n" +
                                        "                    Vertex v = tmpVertex.get( Arrays.asList(nodeName).indexOf( inputDes ) );\n" +
                                        "                    System.out.print( v + \": \" );\n" +
                                        "                    List<Vertex> path = getShortestPathTo(v);\n" +
                                        "                    System.out.print(\"Path: \");\n" +
                                        "                    for(i = 0; i < path.size(); i++) {\n" +
                                        "                        System.out.print( path.get(i) );\n" +
                                        "                        if (i<path.size()-1)\n" +
                                        "                            System.out.print( \">\" );\n" +
                                        "                    }\n" +
                                        "                    System.out.print(\" Cost:\"+ v.minDistance);\n" +
                                        "\n" +
                                        "                    printAllrela(tmpVertex);    // print out all nodes relations\n" +
                                        "                    addNode(tmpVertex, nodeName); // for add or delete nodes\n" +
                                        "\n" +
                                        "\n" +
                                        "                    for (Vertex allnodes : tmpVertex){ // reset all the distance\n" +
                                        "                        allnodes.minDistance = Integer.MAX_VALUE;;\n" +
                                        "                    }\n" +
                                        "                    pressAnyKeyToContinue();\n" +
                                        "                }\n" +
                                        "        }\n" +
                                        "    }\n" +
                                        "\n" +
                                        "    private static void pressAnyKeyToContinue(){  // see function name\n" +
                                        "        System.out.println(\" [Press any key to continue]\");\n" +
                                        "        try {\n" +
                                        "            System.in.read();\n" +
                                        "        }\n" +
                                        "        catch(Exception e){\n" +
                                        "            System.err.println(\"Errorss: \" + e.getMessage());\n" +
                                        "        }\n" +
                                        "    }\n" +
                                        "\n" +
                                        "    // for add new node\n" +
                                        "    private static ArrayList<Vertex> addNode(ArrayList<Vertex> vertex, String[] nodes){\n" +
                                        "        System.out.print(\"do you want to add / delete node (y/n)? \");\n" +
                                        "        Scanner sc = new Scanner(System.in);\n" +
                                        "        String ans = sc.next().toUpperCase(); // for Y or N\n" +
                                        "\n" +
                                        "        if(ans.toUpperCase().equals(\"Y\")){\n" +
                                        "            System.out.print(\"so you want to add or delete(add/del)? \");\n" +
                                        "            sc = new Scanner(System.in);\n" +
                                        "            ans = sc.next().toUpperCase();\n" +
                                        "\n" +
                                        "            if(ans.equals(\"ADD\")){\n" +
                                        "                System.out.println(\"please type the new node relation (newNode: existNode1:cost existNode2:cost...):\");\n" +
                                        "                sc = new Scanner(System.in);\n" +
                                        "                String newRecords = sc.nextLine().toUpperCase(); // for new records\n" +
                                        "                String[] aLineOfrecord = newRecords.split(\"\\\\s+\"); // split by space\n" +
                                        "                // create neighbors array\n" +
                                        "                ArrayList<Edge> tmpNB = new ArrayList<Edge>();\n" +
                                        "\n" +
                                        "                // new node\n" +
                                        "                vertex.add( new Vertex(aLineOfrecord[0].substring(0,1)) );\n" +
                                        "\n" +
                                        "                // add neighbors\n" +
                                        "                for(int neighbors=1; neighbors<aLineOfrecord.length; neighbors++){\n" +
                                        "                    int nb = -1; // for locate neighbor index\n" +
                                        "                    for(Vertex nodename: vertex){ // finding index of existing node\n" +
                                        "                        if( nodename.name.equals(aLineOfrecord[neighbors].substring(0,1)) ){\n" +
                                        "                           nb = vertex.indexOf(nodename); // found index of the existing node, for add in neighbors list to newNode\n" +
                                        "                        }\n" +
                                        "                    }\n" +
                                        "\n" +
                                        "                    int cost = Integer.parseInt( aLineOfrecord[neighbors].substring(2,3) );\n" +
                                        "\n" +
                                        "                    //System.out.println(\"tmpNB.add( new Edge(\"+vertex.get(nb)+\",\"+cost+\") )\");\n" +
                                        "                    tmpNB.add( new Edge(vertex.get(nb), cost) ); // add adjacencies to new node\n" +
                                        "                    //System.out.println(vertex.get(nb) + \".adjacencies.add(\" + vertex.get(vertex.size()-1) +\", \"+ cost + \")\");\n" +
                                        "                    vertex.get(nb).adjacencies.add( new Edge(vertex.get(vertex.size()-1), cost) ); // add adjacencies to new node\n" +
                                        "                }\n" +
                                        "                vertex.get(vertex.size()-1).adjacencies = tmpNB; // add the neighbor relations into newNode adjacencies\n" +
                                        "                //G: B:2 F:3\n" +
                                        "            }\n" +
                                        "            else if(ans.equals(\"DEL\")){  // delete node\n" +
                                        "                System.out.println(\"which of the following node you want to delete? \");\n" +
                                        "                System.out.println(vertex);    // print out all existing nodes\n" +
                                        "                System.out.print(\"please enter one node only: \");\n" +
                                        "                sc = new Scanner(System.in);\n" +
                                        "                ans = sc.next().toUpperCase(); // get the node to be removed\n" +
                                        "\n" +
                                        "                int i=0;\n" +
                                        "                while(i<vertex.size()){ // loop all vertexes to search\n" +
                                        "                    for(int j=0; j<vertex.get(i).adjacencies.size(); j++){\n" +
                                        "                        if(vertex.get(i).adjacencies.get(j).target.name.equals(ans)){  // if itself is the adjacencies of other nodes, remove\n" +
                                        "                            vertex.get(i).adjacencies.remove(j);\n" +
                                        "                        }\n" +
                                        "                    }\n" +
                                        "\n" +
                                        "                    if( vertex.get(i).name.equals(ans) ){ // if found that node\n" +
                                        "                        //System.out.println(ans+\" bye\");   // delete\n" +
                                        "                        vertex.remove(i);                 // after remove, the nodes will pad to left, so position changed in the arraylist\n" +
                                        "                    }else{                                // so if remoced, dont increment i\n" +
                                        "                        i=i+1;\n" +
                                        "                    }\n" +
                                        "                }\n" +
                                        "            }\n" +
                                        "        }else if(ans.toUpperCase().equals(\"N\")){\n" +
                                        "\t\t\t//System.exit(0);\n" +
                                        "\t\t}\n" +
                                        "        Collections.sort(vertex, new CustomComparator());  // sort nodeName in accending order\n" +
                                        "\n" +
                                        "        return vertex;\n" +
                                        "    }\n" +
                                        "\n" +
                                        "    public static void printAllrela(ArrayList<Vertex> vertexies){\n" +
                                        "        System.out.println();\n" +
                                        "        System.out.println(\"======= below are the relations =======\");\n" +
                                        "        for(int i=0; i<vertexies.size(); i++){\n" +
                                        "            System.out.print(vertexies.get(i).name + \": \");\n" +
                                        "            for(int j=0; j<vertexies.get(i).adjacencies.size(); j++){\n" +
                                        "                 System.out.print(vertexies.get(i).adjacencies.get(j).target + \":\" + vertexies.get(i).adjacencies.get(j).cost + \" \");\n" +
                                        "            }\n" +
                                        "            System.out.println();\n" +
                                        "        }\n" +
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

        return  rootview;}

}
