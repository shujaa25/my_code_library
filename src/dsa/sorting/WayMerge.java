package com.ishujaa.my_code_library.src.dsa.sorting;

public class WayMerge {
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

    public int[] merge(int[] a1, int[] a2, int[] a3){

        int[] arr = new int[a1.length+a2.length+a3.length];

        int i = 0, j = 0, k = 0, l = 0;
        while(i < a1.length && j < a2.length && l < a3.length){

            if(a1[i] <= a2[j] && a1[i] <= a3[l])
                arr[k++] = a1[i++];
            else if(a2[j] <= a1[i] && a2[j] <= a3[l])
                arr[k++] = a2[j++];
            else if(a3[l] <= a1[i] && a3[l] <= a2[j])
                arr[k++] = a3[l++];

        }

        while(i < a1.length && j < a2.length)
            if(a1[i] <= a2[j]) arr[k++] = a1[i++];
            else arr[k++] = a2[j++];

        while(l < a3.length && j < a2.length)
            if(a3[l] <= a2[j]) arr[k++] = a3[l++];
            else arr[k++] = a2[j++];

        while(i < a1.length && l < a3.length)
            if(a1[i] <= a3[l]) arr[k++] = a1[i++];
            else arr[k++] = a3[l++];

        while(i < a1.length) arr[k++] = a1[i++];
        while(j < a2.length) arr[k++] = a2[j++];
        while(l < a3.length) arr[k++] = a3[l++];


        return arr;
    }
}
