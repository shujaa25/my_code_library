package com.ishujaa.my_code_library.src.dsa.trees;

import java.util.Arrays;

public class HeapObs {
    private final boolean isMax;
    private final long[] arr; //0th index is ignored
    private int heapSize;

    public HeapObs(long[] arr, boolean isMax){
        this.isMax = isMax;
        this.arr = arr;
        this.heapSize = arr.length-1;

        buildHeap();
    }

    private void heapify(int i){ //O(log n)
        int leftIndex = i * 2; int rightIndex = leftIndex+1; int targetIndex = i;
        if(isMax){
            int largestIndex = i;
            if(leftIndex <= heapSize && arr[leftIndex] > arr[i])
                largestIndex = leftIndex;

            if(rightIndex <= heapSize && arr[rightIndex] > arr[largestIndex])
                largestIndex = rightIndex;

            targetIndex = largestIndex;

        }else{
            int smallestIndex = i;
            if(leftIndex <= heapSize && arr[leftIndex] < arr[i])
                smallestIndex = leftIndex;

            if(rightIndex <= heapSize && arr[rightIndex] < arr[smallestIndex])
                smallestIndex  = rightIndex;

            targetIndex = smallestIndex;
        }

        if(targetIndex != i){
            long iValue = arr[i];
            arr[i] = arr[targetIndex];
            arr[targetIndex] = iValue;
            heapify(targetIndex);

        }
    }

    private void buildHeap(){ //O(n)
        int lastNonLeafIndex = (int)Math.floor(heapSize/2);
        for(int i=lastNonLeafIndex; i>0; i--)
            heapify(i);
    }

    public long extractMax(){
        long maxVal = Integer.MIN_VALUE;
        if(isMax){ //O(log n)
            maxVal = arr[1];
            arr[1] = arr[heapSize];
            heapSize--;
            heapify(1);
        }else{ // O(n)
            int lastNonLeafIndex = (int)Math.floor(heapSize/2);
            int maxIndex = lastNonLeafIndex;
            for(int i = lastNonLeafIndex+1; i<= heapSize; i++){
                if(arr[i] > arr[maxIndex]){
                    maxIndex = i;
                }
            }

            maxVal = arr[maxIndex];
            arr[maxIndex] = arr[heapSize];
            heapSize--;
            heapify(maxIndex);
        }
        return maxVal;
    }

    public long extractMin(){
        long minVal = Integer.MAX_VALUE;
        if(!isMax){
            minVal = arr[1];
            arr[1] = arr[heapSize];
            heapSize--;
            heapify(1);
        }else{
            int lastNonLeafIndex = (int)Math.floor(heapSize/2);
            int minIndex = lastNonLeafIndex;
            for(int i = lastNonLeafIndex+1; i<= heapSize; i++){
                if(arr[i] < arr[minIndex]){
                    minIndex = i;
                }
            }

            minVal = arr[minIndex];
            arr[minIndex] = arr[heapSize];
            heapSize--;
            heapify(minIndex);
        }
        return minVal;
    }

    private void sort(boolean asc){// O(n log n)
        if((isMax && asc) || (!isMax && !asc)){
            for(int i = heapSize; i>0; i--){
                long root = arr[1];
                arr[1] = arr[i];
                arr[i] = root;
                heapSize--;
                heapify(1);
            }
        }

        //heap property is violated by the arr
    }

    public long[] getHeap(){
        return Arrays.copyOfRange(arr, 1, heapSize+1);
    }
}
