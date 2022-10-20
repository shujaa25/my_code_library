package com.ishujaa.my_code_library.src.dsa.sorting;

public class BubbleSort {
    public void sort(int arr[]){
        for(int i=0;i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
