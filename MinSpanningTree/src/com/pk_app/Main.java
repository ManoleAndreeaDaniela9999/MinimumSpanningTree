package com.pk_app;

import java.io.IOException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        //TODO: APPLY KRUSKAL
        GraphUtils g = new GraphUtils("src/com/pk_app/graph.txt");
        KruskalAlg k = new KruskalAlg(g.getNodeList(),g.getArcList());

        System.out.println("The list: ");
        for (Arc a:
                k.getArcList()) {
            System.out.println(a);

        }
        System.out.println("Kruskal result:");
        System.out.println(k.solve() + " cost: " + k.cost());
        //TODO: APPLY PRIM
        GraphUtils g2 = new GraphUtils("src/com/pk_app/graph2.txt");
        PrimAlg p = new PrimAlg(g2.getNodeList(), g2.getArcList());
        System.out.println("The list: ");
        for (Arc a:
                p.getArcList()) {
            System.out.println(a);
        }
        Vector<Arc> r = p.solve();
        System.out.println("Prim's result");
        if(r != null) System.out.println(r + " cost: " + p.getCost());
        else System.out.println("no MST");
    }
}
