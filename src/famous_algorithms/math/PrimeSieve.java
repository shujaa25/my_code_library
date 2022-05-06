package com.ishujaa.my_code_library.src.famous_algorithms.math;

import java.util.Arrays;

public class PrimeSieve {
    private final boolean[] primes;
    private int largestPrime = -1;

    public PrimeSieve(int size){
        primes = new boolean[size+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for(int i=2;i<Math.sqrt(size);i++){
            if(primes[i]){
                int iSquare = i*i;
                for(int j=0; j<=size;j++){
                    int index = iSquare + j*i;
                    if(index <= size) primes[index] = false;
                }
            }
        }
    }

    public int getLargestPrime(){
        if(largestPrime == -1)
            for(int i=primes.length-1; i>1;i--)
                if(primes[i]) return largestPrime = i;

        return largestPrime;
    }

    public boolean[] getPrimes(){
        return primes;
    }
}
