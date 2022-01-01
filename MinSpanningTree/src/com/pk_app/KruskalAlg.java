package com.pk_app;

import java.util.Vector;

public class KruskalAlg {

    private Vector<Node> nodeList;
    private Vector<Arc> arcList;

    public KruskalAlg(Vector<Node> nodeList, Vector<Arc> arcList) {
        this.nodeList = nodeList;
        arcList.sort((o1, o2) -> o1.compareTo(o2));
        this.arcList = arcList;
    }

    public Vector<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(Vector<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Vector<Arc> getArcList() {
        return arcList;
    }

    public void setArcList(Vector<Arc> arcList) {
        this.arcList = arcList;
    }
}
