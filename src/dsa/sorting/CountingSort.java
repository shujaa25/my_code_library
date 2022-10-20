package com.ishujaa.my_code_library.src.dsa.sorting;

import java.util.Arrays;

public class CountingSort {
    public void sort(int[] arr, int l, int h){
        l--;//in order to include the lower value
        int[] count = new int[h-l+1];
        Arrays.fill(count, 0);

        for(int i=0;i<arr.length;i++)
            count[arr[i]-l]++;

        int j=0;
        for(int i=1; i<count.length; i++)
            while(count[i]-- > 0)
                arr[j++] = i+l;
    }
}
