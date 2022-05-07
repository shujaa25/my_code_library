package com.ishujaa.my_code_library.src.dsa.trees;

public class Heap {

    private final boolean maxHeap;
    private HeapNode[] arr; //0th index is ignored
    private int heapSize;

    public Heap(HeapNode[] arr, boolean maxHeap){
        this.maxHeap = maxHeap;
        this.arr = arr;
        this.heapSize = arr.length-1;

        buildHeap();
    }

    private void heapify(int i){ //O(log n)
        int leftIndex = i * 2; int rightIndex = leftIndex+1; int targetIndex = i;
        if(maxHeap){
            int largestIndex = i;
            if(leftIndex <= heapSize && arr[leftIndex].value > arr[i].value)
                largestIndex = leftIndex;

            if(rightIndex <= heapSize && arr[rightIndex].value > arr[largestIndex].value)
                largestIndex = rightIndex;

            targetIndex = largestIndex;

        }else{
            int smallestIndex = i;
            if(leftIndex <= heapSize && arr[leftIndex].value < arr[i].value)
                smallestIndex = leftIndex;

            if(rightIndex <= heapSize && arr[rightIndex].value < arr[smallestIndex].value)
                smallestIndex  = rightIndex;

            targetIndex = smallestIndex;
        }

        if(targetIndex != i){
            HeapNode iValue = arr[i];
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

    public HeapNode extractMax(){
        HeapNode maxVal = new HeapNode();
        maxVal.value = Integer.MIN_VALUE;
        if(maxHeap){ //O(log n)
            maxVal = arr[1];
            arr[1] = arr[heapSize];
            heapSize--;
            heapify(1);
        }else{ // O(n)
            int lastNonLeafIndex = (int)Math.floor(heapSize/2);
            int maxIndex = lastNonLeafIndex;
            for(int i = lastNonLeafIndex+1; i<= heapSize; i++){
                if(arr[i].value > arr[maxIndex].value){
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

    public HeapNode extractMin(){
        HeapNode minVal = new HeapNode();
        minVal.value = Integer.MAX_VALUE;
        if(!maxHeap){
            minVal = arr[1];
            arr[1] = arr[heapSize];
            heapSize--;
            heapify(1);
        }else{
            int lastNonLeafIndex = (int)Math.floor(heapSize/2);
            int minIndex = lastNonLeafIndex;
            for(int i = lastNonLeafIndex+1; i<= heapSize; i++){
                if(arr[i].value < arr[minIndex].value){
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

    private void increaseKey(int index, long key){// for max heap only
        arr[index].value = key;

        if(maxHeap){
            while(index > 1 && arr[index/2].value < arr[index].value){
                HeapNode temp = arr[index/2];
                arr[index/2] = arr[index];
                arr[index] = temp;

                index = index/2;
            }
        }
    }

    public void decreaseKey(int index, long key){// for min heap only
        arr[index].value = key;

        if(!maxHeap){
            while(index > 1 && arr[index/2].value > arr[index].value){
                HeapNode temp = arr[index/2];
                arr[index/2] = arr[index];
                arr[index] = temp;

                index = index/2;
            }
        }
    }


    public boolean insert(HeapNode node){
        if(heapSize < arr.length-1){
            arr[++heapSize] = node;
            if(!maxHeap){
                decreaseKey(heapSize, node.value);
            }else{
                increaseKey(heapSize, node.value);
            }
            return true;
        }
        return false;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void printHeap(){
        for(int i=1; i<=heapSize; i++){
            System.out.print(arr[i].value+" ");
        }System.out.println();
    }
}
