package com.ishujaa.my_code_library.src.dsa.sorting;

public class SelectionSort {
    public void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
