package com.pk_app;

import java.util.HashMap;
import java.util.Vector;

public class KruskalAlg {

    private Vector<Node> nodeList;
    private Vector<Arc> arcList;
    private UnionFind unionFind;

    public KruskalAlg(Vector<Node> nodeList, Vector<Arc> arcList) {
        this.nodeList = nodeList;
        arcList.sort((o1, o2) -> o1.compareTo(o2));
        this.arcList = arcList;

        unionFind = new UnionFind(nodeList);
    }

    public Vector<Arc> solve() {

        Vector<Arc> result = new Vector<>();

        for (Arc arc :
                arcList) {
            if (unionFind.components() < 2) break;
            if (unionFind.find(arc.startNode) == unionFind.find(arc.endNode)) continue;
            unionFind.unify(arc.startNode, arc.endNode);

            result.addElement(arc);
        }

        for (Node n :
                nodeList) {
            n.wasVisited = false;
        }
        return result;
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
