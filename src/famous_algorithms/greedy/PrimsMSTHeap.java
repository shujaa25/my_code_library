package com.ishujaa.my_code_library.src.famous_algorithms.greedy;

import com.ishujaa.my_code_library.src.dsa.graph.AdjacencyListGraph;
import com.ishujaa.my_code_library.src.dsa.graph.GraphNode;
import com.ishujaa.my_code_library.src.dsa.trees.Heap;
import com.ishujaa.my_code_library.src.dsa.trees.HeapNode;

public class PrimsMSTHeap {
    //implementation of MST Prim's Algorithm
    //using Min-Heap
    // O(E log V)

    private class MSTNode extends HeapNode{
        MSTNode parent;
        GraphNode graphNode;
    }

    public int getMinimumMSTCost(AdjacencyListGraph graph){
        GraphNode[] vertices = graph.getVertices();
        int[][] cost = graph.getWeights();
        MSTNode[] mstVertices = new MSTNode[graph.getN()+1];
        for(int i=1; i<graph.getN()+1; i++){
            mstVertices[i] = new MSTNode();
            mstVertices[i].graphNode = vertices[i];
            mstVertices[i].value = Integer.MAX_VALUE;
            mstVertices[i].parent = null;
        }
        MSTNode root = mstVertices[1];
        root.value = 0;

        Heap heap = new Heap(mstVertices, false);
        MSTNode u = root;
        while(heap.getHeapSize() > 0){
            u = (MSTNode) heap.extractMin();
            GraphNode v = u.graphNode;
            while(v.nextVertex != null){
                v = v.nextVertex;
                //does v exists in the heap
                int vInMSTIndex = -1;
                for(int i=1; i<=heap.getHeapSize(); i++){
                    if(mstVertices[i].graphNode.name == v.name){
                        vInMSTIndex = i;
                        break;
                    }
                }

                if(vInMSTIndex != -1 && cost[u.graphNode.name][v.name] < mstVertices[vInMSTIndex].value){
                    mstVertices[vInMSTIndex].parent = u;
                    heap.decreaseKey(vInMSTIndex, cost[u.graphNode.name][v.name]);

                }

            }
        }

        int sum = 0;
        while(u.parent != null){
            sum+=u.value;
            u = u.parent;
        }
        return sum;
    }
}
