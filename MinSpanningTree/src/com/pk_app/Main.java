package com.pk_app;

import java.io.IOException;
import java.util.Comparator;
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
        System.out.println(k.solve());
        //TODO: APPLY PRIM
        GraphUtils g2 = new GraphUtils("src/com/pk_app/graph2.txt");
        PrimAlg p = new PrimAlg(g2.getNodeList(), g2.getArcList());
        Vector<Arc> r = p.solve();
        if(r != null) System.out.println(r);
        else System.out.println("no MST");
    }
}
