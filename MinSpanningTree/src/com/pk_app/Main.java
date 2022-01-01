package com.pk_app;

import java.io.IOException;
import java.util.Comparator;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphUtils g = new GraphUtils("src/com/pk_app/graph.txt");
        //TODO: APPLY KRUSKAL
        KruskalAlg k = new KruskalAlg(g.getNodeList(),g.getArcList());

        System.out.println("The list: ");
        for (Arc a:
                k.getArcList()) {
            System.out.println(a);

        }
        System.out.println("Kruskal result:");
        System.out.println(k.solve());
        //TODO: APPLY PRIM

        
    }
}
