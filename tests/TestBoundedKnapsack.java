package com.ishujaa.my_code_library.tests;

import com.ishujaa.my_code_library.src.famous_algorithms.dp.BoundedKnapsack;
import junit.framework.TestCase;

public class TestBoundedKnapsack extends TestCase {

    protected BoundedKnapsack boundedKnapsack;

    @Override
    protected void setUp() throws Exception {
        boundedKnapsack = new BoundedKnapsack();
    }

    public void testGetMaximumValue() {
        assertEquals(boundedKnapsack.getMaximumValue(new int[]{10, 20, 30},
                new int[]{60,100,120}, 3, 50), 220);

    }
}
