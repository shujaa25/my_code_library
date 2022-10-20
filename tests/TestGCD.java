package com.ishujaa.my_code_library.tests;

import com.ishujaa.my_code_library.src.famous_algorithms.math.GCD;
import junit.framework.TestCase;

public class TestGCD extends TestCase {

    protected GCD gcd;

    @Override
    public void setUp() throws Exception {
        gcd = new GCD();
    }

    public void testFindGCD(){
        assertEquals(gcd.findGCD(18,24), 6);
        assertEquals(gcd.findGCD(68,51), 17);
    }
}
