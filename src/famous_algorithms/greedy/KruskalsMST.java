package com.ishujaa.my_code_library.src.famous_algorithms.greedy;

import com.ishujaa.my_code_library.src.dsa.disjoint_sets.DisjointSetList;
import com.ishujaa.my_code_library.src.dsa.graph.EdgeNode;
import com.ishujaa.my_code_library.src.dsa.graph.MatrixGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class KruskalsMST {
    //implementation of the Kruskal's Algorithm with Disjoint Sets

    class EdgeComparator implements Comparator<EdgeNode>{

        @Override
        public int compare(EdgeNode o1, EdgeNode o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    }

    public void getMinimumMSTCost(MatrixGraph graph){
        DisjointSetList disjointSet = new DisjointSetList(); //use forest
        for(int i=1; i<graph.getN()+1; i++) disjointSet.createSet(i);

        Set<EdgeNode> mstEdges = new HashSet<>();

        ArrayList<EdgeNode> edges = graph.getEdgeNodes();
        //sort edges by weight
        edges.sort(new EdgeComparator());

        for(EdgeNode edgeNode: edges){
            int a = disjointSet.findSetRepresentative(edgeNode.x);
            int b = disjointSet.findSetRepresentative(edgeNode.y);
            if(a != b){
                mstEdges.add(edgeNode);
                System.out.println(edgeNode.x+" "+edgeNode.y+" "+ a+" "+ b);
                disjointSet.union(edgeNode.x, edgeNode.y);
                System.out.println("    "+
                        disjointSet.findSetRepresentative(edgeNode.x)+" "+
                        disjointSet.findSetRepresentative(edgeNode.y));
                System.out.println(disjointSet.getNumberOfSets());
            }
        }
        int sum = 0;
        for(EdgeNode node : mstEdges){
            sum+=node.weight;
        }
        System.out.println(sum);


    }
}
