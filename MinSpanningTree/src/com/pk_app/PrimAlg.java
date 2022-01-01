package com.pk_app;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;

public class PrimAlg {

    private Vector<Node> nodeList;
    private Vector<Arc> arcList;
    //private UnionFind unionFind;
    private PriorityQueue<Arc> pq;

    private int cost = 0;

    public PrimAlg(Vector<Node> nodeList, Vector<Arc> arcList) {
        this.nodeList = nodeList;
        arcList.sort((o1, o2) -> o1.compareTo(o2));
        this.arcList = new Vector<>();
        this.arcList.addAll(arcList);

        pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        Vector<Arc> reverseEdges = new Vector<>();
        for (Arc arc :
                arcList) {
            Arc revArc = new Arc();
            revArc.startNode = arc.endNode;
            revArc.endNode = arc.startNode;
            revArc.cost = arc.cost;
            reverseEdges.addElement(revArc);
        }
        this.arcList.addAll(reverseEdges);
    }

    //returns the edges that compose the MST. If there is no MST the method returns null
    public Vector<Arc> solve() {
        int expectedNrOfEdges = nodeList.size() - 1;
        int edgeCount = 0;
        addEdges(nodeList.elementAt(nodeList.size()-1));
        Vector<Arc> result = new Vector<>();
        while (!pq.isEmpty() && edgeCount != expectedNrOfEdges) {
            Arc edge = pq.poll();
            if (edge.endNode.wasVisited)
                continue;

            edgeCount += 1;
            result.add(edge);
            cost += edge.cost;

            addEdges(edge.endNode);
        }

        for (Node n :
                nodeList) {
            n.wasVisited = false;
        }

        if (edgeCount != expectedNrOfEdges) {
            return null;
        }
        return result;
    }

    private void addEdges(Node n) {

        n.wasVisited = true;
        for (Arc arc :
                arcList) {
            if (!arc.endNode.wasVisited && arc.startNode.id.equals(n.id))
                pq.add(arc);
        }
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

    public PriorityQueue<Arc> getPq() {
        return pq;
    }

    public void setPq(PriorityQueue<Arc> pq) {
        this.pq = pq;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
