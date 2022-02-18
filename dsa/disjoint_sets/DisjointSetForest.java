package com.ishujaa.my_code_library.dsa.disjoint_sets;

import java.util.HashMap;

public class DisjointSetForest{

    class Node{
        int value, rank;
        Node parent;
    }

    private HashMap<Integer, Node> map;
    private int numberOfSets = 0;

    public DisjointSetForest(){
        map = new HashMap<>();
    }

    public void createSet(int element) {
        Node node = new Node();
        node.parent = node;
        node.value = element;
        node.rank = 1;
        map.put(element, node);
        numberOfSets++;
    }

    public int findSet(int element) {
        return 0;
    }

    public void union(int element1, int element2) {

    }

    public int getNumberOfSets() {
        return numberOfSets;
    }
}
