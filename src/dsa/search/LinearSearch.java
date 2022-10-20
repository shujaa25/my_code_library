package com.ishujaa.my_code_library.src.dsa.search;

public class LinearSearch {
    public int search(int[] arr, int n){
        for (int i=0; i<arr.length;i++){
            if(arr[i] == n)
                return i;
        }

        return -1;
    }
}
