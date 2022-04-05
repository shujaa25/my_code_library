package com.ishujaa.my_code_library.dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    private void twoWayMerge(int[] arr, int l, int m, int h){

        int[] a1 = Arrays.copyOfRange(arr, l, m+1);
        int[] a2 = Arrays.copyOfRange(arr, m+1, h+1);

        int i = 0, j = 0, k = l;
        while(i < a1.length && j < a2.length){
            if(a1[i] <= a2[j]) arr[k++] = a1[i++];
            else arr[k++] = a2[j++];
        }

        while(i < a1.length) arr[k++] = a1[i++];
        while(j < a2.length) arr[k++] = a2[j++];

    }

    private void mergeSort(int[] arr, int l, int h){
        if(l < h){
            int mid = (l+h)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);
            twoWayMerge(arr, l, mid, h);
        }
    }

    public void sort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }
}
