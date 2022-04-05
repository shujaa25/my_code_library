package com.ishujaa.my_code_library.dsa.sorting;

public class QuickSort {
    private void swap(int[] arr, int i, int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    private int partition(int[] arr, int l, int h){
        int pivot = arr[h];
        int i=l-1;
        for(int j=l; j<h; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }

    private void quickSort(int[] arr, int l, int h){
        if(l < h){
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, h);
        }
    }

    public void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
}
