package com.ishujaa.my_code_library.dsa.hashtable;

import com.ishujaa.my_code_library.dsa.lists.SinglyLinkedList;

import java.util.Arrays;
//Implementation of hashing with chaining
public class ChainedHashTable {
    private SinglyLinkedList[] table;
    private int size;
    public ChainedHashTable(int size){
        table = new SinglyLinkedList[size];
        this.size = size;

        Arrays.fill(table, new SinglyLinkedList());
    }

    private int hash(int value){
        return value % size;
    }


    public int insert(int value) { // O(1)
        int index = hash(value);
        table[index].addNodeHead(value);
        return index;
    }

    public int exists(int value) { // O(n)
        if(table[hash(value)].exists(value)) return hash(value);
        else return -1;
    }

    public boolean delete(int value) { // O(n)
        return table[hash(value)].deleteValue(value);
    }
}
