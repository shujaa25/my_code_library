package com.ishujaa.my_code_library.test;

import com.ishujaa.my_code_library.src.famous_algorithms.greedy.OptimalMergePatterns;
import junit.framework.TestCase;

public class TestOptimalMergePattern extends TestCase {
    protected OptimalMergePatterns optimalMergePatterns;
    @Override
    protected void setUp() throws Exception {
        optimalMergePatterns = new OptimalMergePatterns();
    }

    public void testGetMinimumMovements() {
        int[] files = {2,3,4};
        assertEquals(14, optimalMergePatterns.getMinimumMovements(files));
    }
}
