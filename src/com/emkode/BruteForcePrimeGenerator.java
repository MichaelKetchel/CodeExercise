package com.emkode;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * An implementation of PrimeNumberGenerator based on a brute force method, testing up to the square root,
 * for efficiency.
 * Generates prime numbers within a range, or returns the prime-ness of a single value.
 */
public class BruteForcePrimeGenerator implements PrimeNumberGenerator{

    @Override
    public List<Integer> generate(int startingValue, int endingValue){
        // Address flipped inputs.
        int lowVal = min(startingValue, endingValue);
        int highVal = max(startingValue, endingValue);

        List<Integer> primeNumbers = new LinkedList<>();

        for (int i = lowVal; i <= highVal; i++){
            if(this.isPrime(i)){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


    @Override
    public boolean isPrime(int value){
        // Zero isn't actually prime.
        if (value == 0 || value == 1){
            return false;
        }
        // Check all numbers up to the square root of the number
        for (int i = 2; i*i < value+1; i++) {
            if (value % i == 0) {
                return false;
            }
        }
      return true;
    }
}
