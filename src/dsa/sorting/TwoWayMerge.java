package com.ishujaa.my_code_library.src.dsa.sorting;

import java.util.Arrays;

public class TwoWayMerge {
    public int[] merge(int[] a1, int[] a2){

        int[] arr = new int[a1.length+a2.length];

        int i = 0, j = 0, k = 0;
        while(i < a1.length && j < a2.length){
            if(a1[i] <= a2[j]) arr[k++] = a1[i++];
            else arr[k++] = a2[j++];
        }

        while(i < a1.length) arr[k++] = a1[i++];
        while(j < a2.length) arr[k++] = a2[j++];


        return arr;
    }
}
