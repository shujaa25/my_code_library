package com.ishujaa.my_code_library.src.famous_algorithms.math;

public class GCD {
    public long findGCD(long a, long b){
        if(b == 0)
            return a;
        return findGCD(b, a%b);
    }
}
