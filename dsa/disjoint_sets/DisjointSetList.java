package com.ishujaa.my_code_library.dsa.disjoint_sets;

import java.util.HashMap;

//implementation of disjoint sets using Linked List
public class DisjointSetList{
    class Node{
        int value;
        Node representative, next;
    }

    private HashMap<Integer, Node> map;
    private int numberOfSets = 0;
    
    public DisjointSetList(){
        map = new HashMap<>();
    }

    public void createSet(int element){ // O(1)
        Node node = new Node();
        node.next = null;
        node.representative = node;
        node.value = element;

        map.put(element, node);
        numberOfSets++;
    }

    private Node findSet(int element){ // O(1)
        if(map.containsKey(element)){
            Node node = map.get(element);
            return node.representative;
        }
        return null;
    }

    public int findSetRepresentative(int element){
        Node node = findSet(element);
        if(node != null) return node.value;
        return -1;
    }

    public void union(int element1, int element2){ // O(n)
        if(findSet(element1) != null && findSet(element2) != null && findSet(element1) != findSet(element2)){
            Node set1 = map.get(element1).representative;
            Node set2 = map.get(element2).representative;
            set2.representative = set1;

            Node temp = set1;
            while(temp.next != null)
                temp = temp.next;

            temp.next = set2;
            numberOfSets--;
        }
    }

    public int getNumberOfSets(){
        return numberOfSets;
    }
}
