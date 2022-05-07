package com.ishujaa.my_code_library.tests;

import com.ishujaa.my_code_library.src.dsa.graph.AdjacencyListGraph;
import com.ishujaa.my_code_library.src.dsa.graph.MatrixGraph;
import com.ishujaa.my_code_library.src.famous_algorithms.greedy.PrimsMST;
import com.ishujaa.my_code_library.src.famous_algorithms.greedy.PrimsMSTHeap;
import junit.framework.TestCase;

public class TestPrimsMSTHeap extends TestCase {
    protected PrimsMSTHeap primsMST;
    @Override
    public void setUp() throws Exception {
        primsMST = new PrimsMSTHeap();
    }

    public void testGetMinimumCostSum() {
        AdjacencyListGraph graph = new AdjacencyListGraph(7);
        graph.addEdge(1, 2, 25, false);
        graph.addEdge(1, 6, 5, false);
        graph.addEdge(6, 5, 20, false);
        graph.addEdge(7, 5, 18, false);
        graph.addEdge(7, 4, 14, false);
        graph.addEdge(7, 2, 10, false);
        graph.addEdge(4, 5, 16, false);
        graph.addEdge(2, 3, 12, false);
        graph.addEdge(4, 3, 8, false);


        assertEquals(71, primsMST.getMinimumMSTCost(graph));

    }
}
