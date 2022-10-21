package com.ishujaa.my_code_library.tests;

import com.ishujaa.my_code_library.src.dsa.sorting.CycleSort;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestCycleSort extends TestCase {

    protected CycleSort cycleSort;

    @Override
    public void setUp() throws Exception {
        cycleSort = new CycleSort();
    }

    public void testSortDistinct(){
        int[] a = {2,4,5,1,3, 9, 10, 6, 8, 7, 0};
        cycleSort.sortDistinct(a);
        Assert.assertArrayEquals(a, new int[]{0,1,2,3,4,5,6,7,8,9,10});

        int[] b = {0,1,0,1,0,1,0,0,0,1,1,0,2};
        cycleSort.sort(b);
        Assert.assertArrayEquals(b, new int[]{0,0,0,0,0,0,0,1,1,1,1,1,2});
    }
}
