package com.ishujaa.my_code_library.src.dsa.sorting;

public class CycleSort {

    public void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){// no. of cycles
            int key = arr[i];
            int loc = i;
            for(int j=i+1;j<arr.length;j++)//find no. of smallest
                if(key > arr[j]) loc++;

            if(loc == i) continue;//key is itself smallest
            while(key == arr[loc]) loc++;//ignore duplicates

            if(key != arr[loc]){//swap key and arr[loc]
                int temp = arr[loc];
                arr[loc] = key;
                key = temp;
            }

            while (loc != i){//repeat until cycle is complete
                loc = i;
                for(int j=i+1;j<arr.length;j++)//find smaller
                    if(key > arr[j]) loc++;
                while(key == arr[loc]) loc++;//ignore duplicates
                if(key != arr[loc]){//swap
                    int temp = arr[loc];
                    arr[loc] = key;
                    key = temp;
                }
            }
        }
    }

    public void sortDistinct(int[] arr){
        for(int i=0;i<arr.length-1;i++){// no. of cycles
            int key = arr[i];
            int loc;
            do{
                loc = i;
                for(int j=i+1;j<arr.length;j++)// no. of smaller elements than key
                    if(key > arr[j]) loc++;
                //if none then it means the key itself is smallest, hence loc = i

                //swap key and arr[loc]
                int temp = arr[loc];
                arr[loc] = key;
                key = temp;
            }while (loc != i);// cycle completes
        }
    }
}
