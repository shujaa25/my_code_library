package com.ishujaa.my_code_library.src.famous_algorithms.greedy;

import java.util.Arrays;

public class PrimsMST {
//implementation of the Prim's Algorithm for MST without using a heap
// O(n^2)

    public int[][] getMinimumCostMST(int[][] graph, int n){
        int[][] sortedEdges = new int[n-1][2]; //for n vertex graph the MST will have n-1 edges

        int[] nearVertex = new int[n+1];//contains the vertices that are nearer to the latest minimum sorted edge.
        Arrays.fill(nearVertex, Integer.MAX_VALUE);

        //find the first minimum edge
        int minimumValue = Integer.MAX_VALUE;
        for(int i=1; i<=n;i++){
            for(int j=i+1; j<=n; j++){
                if(graph[i][j] < minimumValue){
                    minimumValue = graph[i][j];
                    sortedEdges[0][0] = i; //source
                    sortedEdges[0][1] = j; //dest
                }
            }
        }

        //fill the sortedEdges Array with remaining edges
        for(int k=1; k<n-1; k++){
            //mark the latest minimum edge as 0 in the nearVertex array
            nearVertex[sortedEdges[k-1][0]] = nearVertex[sortedEdges[k-1][1]] = 0;

            //find the vertices that are nearer to the latest min. edge
            for(int i=1; i<=n; i++){
                if(nearVertex[i] != 0){//0 indicates that the edge is already included
                    int x = sortedEdges[k-1][0]; int y = sortedEdges[k-1][1];
                    if(graph[x][i] < graph[y][i])
                        nearVertex[i] = x;
                    else nearVertex[i] = y;

                }
            }

            //find the next minimum edge
            minimumValue= Integer.MAX_VALUE;
            for(int i=1; i<=n; i++){
                if(nearVertex[i] != 0){
                    if(graph[i][nearVertex[i]] < minimumValue){
                        minimumValue = graph[i][nearVertex[i]];
                        sortedEdges[k][0] = i;
                        sortedEdges[k][1] = nearVertex[i];
                    }
                }
            }
        }
        return sortedEdges;
    }

    public int getMinimumCostSum(int[][] graph, int n){
        int[][] mstEdges = getMinimumCostMST(graph, n);
        int sum = 0;
        for(int i=0; i<n-1; i++){
            sum+=graph[mstEdges[i][0]][mstEdges[i][1]];
        }
        return sum;
    }
}
