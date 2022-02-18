package com.ishujaa.my_code_library.famous_algorithms.dp;

public class BoundedKnapsack {
    public int getMaximumValue(int[] weight, int[] value, int n, int capacity){
        int[][] knapsack = new int[n+1][capacity+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<capacity+1;j++){
                if(weight[i-1] <= j){
                    knapsack[i][j] = Math.max(value[i-1]+knapsack[i-1][j-weight[i-1]],
                            knapsack[i-1][j]);
                }else knapsack[i][j] = knapsack[i-1][j];
            }
        }

        return knapsack[n][capacity];
    }
}
