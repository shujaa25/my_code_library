package com.ishujaa.my_code_library.src.dsa.graph;

public class AdjacencyListGraph {
    private GraphNode[] vertices;
    private final int n;
    private int[][] weights;

    public AdjacencyListGraph(int n){
        this.n = n;
        vertices = new GraphNode[n+1];
        weights = new int[n+1][n+1];

        //filling infinity
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                weights[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=1; i<=n; i++){
            vertices[i] = new GraphNode();
            vertices[i].name = i;
            vertices[i].nextVertex = null;
        }
    }

    public void addEdge(int source, int destination, int weight, boolean directed){
        weights[source][destination] = weight;
        if(!directed) weights[destination][source] = weight;

        GraphNode targetVertex = vertices[source];
        GraphNode node = new GraphNode();
        node.name = destination;
        node.nextVertex = targetVertex.nextVertex;
        targetVertex.nextVertex = node;

        if(!directed){
            targetVertex = vertices[destination];
            node = new GraphNode();
            node.name = source;
            node.nextVertex = targetVertex.nextVertex;
            targetVertex.nextVertex = node;
        }
    }

    public GraphNode[] getVertices() {
        return vertices;
    }

    public int[][] getWeights() {
        return weights;
    }

    public int getN() {
        return n;
    }

    public void printGraph(){
        for(int i=1; i<=n; i++){
            System.out.print(vertices[i].name + " -> ");
            GraphNode node = vertices[i];
            while(node.nextVertex != null){
                node = node.nextVertex;
                System.out.print(node.name + " ");
            }
            System.out.println();
        }
    }
}
