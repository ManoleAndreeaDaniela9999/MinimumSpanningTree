package com.pk_app;

import java.util.HashMap;
import java.util.Vector;

public class UnionFind {

    private int size;

    private HashMap<Node, Integer> componentSizes;

    private HashMap<Node, Node> parentNodeOf;

    private int numOfComponents;

    public UnionFind(Vector<Node> nodeList) {

        if (nodeList.isEmpty()) throw new IllegalArgumentException("The node list can not be null!");

        this.size = this.numOfComponents = nodeList.size();

        componentSizes = new HashMap<>();
        parentNodeOf = new HashMap<>();

        for (Node n :
                nodeList) {
            parentNodeOf.put(n, n);
            componentSizes.put(n, 1);
        }

    }

    //with path compression
    public Node find(final Node n) {

        Node rootNode = n;

        while (rootNode != parentNodeOf.get(rootNode)) {
            rootNode = parentNodeOf.get(rootNode);
        }

        //path compression

        Node aux = n;
        while (aux != rootNode) {
            Node next = parentNodeOf.get(aux);
            parentNodeOf.replace(aux, rootNode);
            aux = next;
        }
        return rootNode;
    }

    public boolean connected(Node n, Node m) {
        return find(n) == find(m);
    }

    public Integer componentSizeOf(Node n) {
        return componentSizes.get(find(n));
    }

    public Integer size() {
        return size;
    }

    //return the remaining of components
    public Integer components() {
        return numOfComponents;
    }

    public void unify(Node n, Node m) {

        Node root1 = find(n);
        Node root2 = find(m);

        if (root1 == root2) return;

        //merge smaller component into bigger one
        if (componentSizes.get(root1) < componentSizes.get(root2)) {
            componentSizes.replace(root2, componentSizes.get(root1) + componentSizes.get(root2));
            parentNodeOf.replace(root1, root2);
        } else {
            componentSizes.replace(root1, componentSizes.get(root1) + componentSizes.get(root2));
            parentNodeOf.replace(root2, root1);
        }
        numOfComponents-=1;
    }

}
