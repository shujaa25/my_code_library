package com.ishujaa.my_code_library.dsa.disjoint_sets;

import java.util.ArrayList;
import java.util.HashMap;

public class LinkedDSet {
    class Node{
        int value;
        Node representative, next;
    }

    private HashMap<Integer, Node> map;
    public final int NULL = Integer.MIN_VALUE;
    
    public LinkedDSet(){
        map = new HashMap<>();
    }

    public void createSet(int element){ // O(1)
        Node node = new Node();
        node.next = null;
        node.representative = node;
        node.value = element;

        map.put(element, node);
    }

    public int findSet(int element){ // O(1)
        if(map.containsKey(element)){
            Node node = map.get(element);
            return node.representative.value;
        }
        return NULL;
    }

    public void union(int element1, int element2){ // O(n)
        if(findSet(element1) != NULL && findSet(element2) != NULL && findSet(element1) != findSet(element2)){
            Node set1 = map.get(element1).representative;
            Node set2 = map.get(element2).representative;
            set2.representative = set1;

            Node temp = set1;
            while(temp.next != null)
                temp = temp.next;

            temp.next = set2;
        }
    }

}
