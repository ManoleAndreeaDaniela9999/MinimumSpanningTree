package com.pk_app;

public class Arc {
    public Node startNode;
    public Node endNode;
    public int cost;

    @Override
    public String toString() {
        return startNode.id + " " + endNode.id+ " " + cost;
    }
}
