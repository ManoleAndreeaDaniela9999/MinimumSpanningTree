package com.pk_app;

public class Arc {
    public Node startNode;
    public Node endNode;
    public int cost;

    @Override
    public String toString() {
        return startNode.id + " " + endNode.id+ " " + cost;
    }

    public int compareTo(Arc a){
        if( this.cost > a.cost) return 1;
        if( this.cost < a.cost) return -1;
        return 0;

    }
}
