package com.ishujaa.my_code_library.src.famous_algorithms.math;

public class LCM {
    public long findLCM(long a, long b){
        return a*b/new GCD().findGCD(a, b);
    }
}
