package com.pk_app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

public class GraphUtils {

    private Vector<Node> nodeList;
    private Vector<Arc> arcList;

    public GraphUtils(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);

        nodeList = new Vector<>();
        arcList = new Vector<>();

        Vector<String> contents = new Vector<>();
        BufferedReader reader = new BufferedReader(fileReader);
        Stream<String> lines = reader.lines();
        lines.forEach(s -> contents.addElement(s));
        reader.close();

//        System.out.println("Graph content:");
//        for (String line :
//                contents) {
//            System.out.println(line);
//
//        }
        reader.close();

        ComputeGraph(contents);
    }

    private void ComputeGraph(Vector<String> contents) {
        HashSet<Node> nodes =new HashSet<Node>();

        for (String content :
                contents) {
            String[] variables = content.split(" ");

            Node n1 = new Node();
            n1.id = variables[0];

            Node n2 = new Node();
            n2.id = variables[1];

            Arc a = new Arc();
            a.startNode = n1;
            a.endNode = n2;
            a.cost = Integer.parseInt(variables[2]);

            nodes.add(n1);
            nodes.add(n2);
            arcList.addElement(a);
        }

        for (Node n :
                nodes) {
            nodeList.addElement(n);
        }

    }

    public Vector<Node> getNodeList() {
        return nodeList;
    }

    public Vector<Arc> getArcList() {
        return arcList;
    }
}
