package com.ishujaa.my_code_library.tests;

import com.ishujaa.my_code_library.src.dsa.sorting.WayMerge;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestWayMerge extends TestCase {

    protected WayMerge wayMerge;

    @Override
    public void setUp() throws Exception {
        wayMerge = new WayMerge();
    }

    public void testMerge(){

        int[] a = {1,2,3,4};
        int[] b = {1,2,3,4,5};
        int[] c = {1,2,3,4,5,6};

        Assert.assertArrayEquals(wayMerge.merge(a, b, c),
                new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5,5,6});
        Assert.assertArrayEquals(wayMerge.merge(a, c),
                new int[]{1,1,2,2,3,3,4,4,5,6});
    }
}
