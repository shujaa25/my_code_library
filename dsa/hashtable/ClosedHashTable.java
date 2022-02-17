package com.ishujaa.my_code_library.dsa.hashtable;


import com.ishujaa.my_code_library.famous_algorithms.math.PrimeSieve;

import java.util.Arrays;

//implementation of hashing with open addressing
//it dynamically increases its size if needed
public class ClosedHashTable {
    private int size;
    private int[] table;
    private final int EMPTY = Integer.MIN_VALUE;
    private int PRIME;

    private int getLargestPrime(int size){
        //using sieve of eratosthenes to get the largest prime number
        PrimeSieve sieve = new PrimeSieve(size);
        return sieve.getLargestPrime();
    }

    public ClosedHashTable(int size){
        //making sure that the size of table is a power of 2
        double p = Math.ceil(Math.log10(size)/Math.log10(2));
        this.size = (int)Math.pow(2, p);

        PRIME = getLargestPrime(this.size);

        table = new int[this.size];
        Arrays.fill(table, EMPTY);
    }

    //based on double hashing
    private int hash1(int value){
        return value % size;
    }
    private int hash2(int value){
        return PRIME - (value % PRIME);
    }
    //it returns the first free slot if available for a value else -1
    private int hash(int value, int i){
        if(i == size) return -1;
        int index = (hash1(value) + i * hash2(value)) % size;
        if(table[index] == EMPTY)
            return index;
        return hash(value, i+1);
    }

    //it returns the index for the first occurrence of the value or -1
    private int findIndex(int value, int i){
        if(i == size) return -1;
        int index = (hash1(value) + i * hash2(value)) % size;
        if(table[index] == value) return index;
        return findIndex(value, i+1);
    }

    public int insert(int value){
        int index = hash(value, 0);
        if(index != -1 && table[index] == EMPTY){
            table[index] = value;
            return index;
        }

        //resizing
        size *= 2;
        int[] newTable = new int[size];
        Arrays.fill(newTable, EMPTY);
        System.arraycopy(table, 0, newTable, 0, size / 2);
        table = newTable;
        PRIME = getLargestPrime(size);

        index = hash(value, 0);
        if(index != -1 && table[index] == EMPTY){
            table[index] = value;
            return index;
        }

        return -1;
    }

    public void delete(int value){
        int index = findIndex(value, 0);
        if(index != -1)
            table[index] = EMPTY;

    }

    public int exists(int value){
        return findIndex(value, 0);
    }

    public int getSize(){
        return size;
    }

    public void printTable(){
        for(int i=0;i<size;i++){
            if(table[i] != EMPTY) System.out.print(table[i]+" ");
            else System.out.print("Φ ");
        }System.out.println();
    }
}
