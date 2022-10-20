package com.ishujaa.my_code_library.src.dsa.sorting;

public class InsertionSort {
    public void sort(int[] arr){
        if(arr.length > 1){

            for(int i=1; i<arr.length; i++){
                int key = arr[i];
                int j = i-1;
                while(j>=0 && key < arr[j]){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = key;
            }

        }

    }
}
