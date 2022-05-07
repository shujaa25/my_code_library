package com.ishujaa.my_code_library.src.dsa.graph;

public class MatrixGraph {
    private int[][] graph;
    private final int n;
    public MatrixGraph(int n){
        this.n = n;
        graph = new int[n+1][n+1];

        //filling infinity
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

    }

    public void addEdge(int source, int destination, int weight, boolean directed){
        graph[source][destination] = weight;
        if(!directed) graph[destination][source] = weight;
    }

    public int[][] getGraphMatrix(){
        return graph;
    }

    public int getN() {
        return n;
    }

    public void printMatrix(){
        for(int i=0; i<=n; i++){
            if(i != 0) System.out.print(String.format("%3d ", i));
            else System.out.print(String.format("%3c ", 32));
            for(int j=1; j<=n; j++){
                String op;
                if(i == 0){
                    op = String.format("%3d ", j);
                }else {
                    op = String.format("%3d ", graph[i][j]);
                    if(graph[i][j] == Integer.MAX_VALUE)
                        op = String.format("%3c ", 45);
                }

                System.out.print(op);
            }System.out.println();
        }
    }
}
