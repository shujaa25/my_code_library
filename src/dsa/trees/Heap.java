package com.ishujaa.my_code_library.src.dsa.trees;

public class Heap {

    private final boolean isMax;
    private HeapObject[] arr; //0th index is ignored
    private int heapSize;

    public Heap(HeapObject[] arr, boolean isMax){
        this.isMax = isMax;
        this.arr = arr;
        this.heapSize = arr.length-1;

        buildHeap();
    }

    private void heapify(int i){ //O(log n)
        int leftIndex = i * 2; int rightIndex = leftIndex+1; int targetIndex = i;
        if(isMax){
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
            HeapObject iValue = arr[i];
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

    public HeapObject extractMax(){
        HeapObject maxVal = new HeapObject();
        maxVal.value = Integer.MIN_VALUE;
        if(isMax){ //O(log n)
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

    public HeapObject extractMin(){
        HeapObject minVal = new HeapObject();
        minVal.value = Integer.MAX_VALUE;
        if(!isMax){
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

    private void increaseKey(int index, long key){
        arr[index].value = key;

        while(index > 1 && arr[index/2].value < arr[index].value){
            long temp = arr[index/2].value;
            arr[index/2].value = arr[index].value;
            arr[index].value = temp;

            index = index/2;
        }
    }

    private void decreaseKey(int index, long key){
        arr[index].value = key;

        while(index > 1 && arr[index/2].value > arr[index].value){
            long temp = arr[index/2].value;
            arr[index/2].value = arr[index].value;
            arr[index].value = temp;

            index = index/2;
        }
    }


    public boolean insert(HeapObject node){
        if(heapSize < arr.length-1){
            arr[++heapSize] = node;
            if(!isMax){
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

    /*private void sort(boolean asc){// O(n log n)
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
    }*/
}
