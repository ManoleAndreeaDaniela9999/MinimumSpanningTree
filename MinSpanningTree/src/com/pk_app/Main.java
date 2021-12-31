package com.pk_app;

import java.io.IOException;
import java.util.Comparator;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphUtils g = new GraphUtils("src/com/pk_app/graph.txt");
        //TODO: APPLY KRUSKAL
        g.getArcList().sort(new Comparator<Arc>() {
            @Override
            public int compare(Arc o1, Arc o2) {
                return o1.compareTo(o2);
            }
            );
        //TODO: APPLY PRIM
    }
}
