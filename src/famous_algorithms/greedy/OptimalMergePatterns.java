package com.ishujaa.my_code_library.src.famous_algorithms.greedy;

import com.ishujaa.my_code_library.src.dsa.trees.Heap;
import com.ishujaa.my_code_library.src.dsa.trees.HeapObject;

public class OptimalMergePatterns {

    public int getMinimumMovements(int[] filesArray){

        HeapObject[] files = new HeapObject[filesArray.length+1];
        for(int i=1; i<files.length; i++){
            files[i] = new HeapObject();
            files[i].value = filesArray[i-1];
        }
        Heap heap = new Heap(files, false);

        int count = 0;
        while(heap.getHeapSize() > 1){
            HeapObject node = new HeapObject();
            node.value = heap.extractMin().value + heap.extractMin().value;
            count+= node.value;
            heap.insert(node);
        }

        return count;
    }

}
