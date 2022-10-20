package com.ishujaa.my_code_library.src.dsa.search;

public class BinarySearch {
    public int search(int[] arr, int n){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == n)
                return mid;
            else if(arr[mid] < n)
                low = mid+1;
            else
                high = mid-1;
        }

        return -1;
    }
}
