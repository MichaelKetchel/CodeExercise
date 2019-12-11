package com.emkode;

import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * An implementation of PrimeNumberGenerator, using the Sieve of Eratosthenes.
 * Generates prime numbers within a range, or returns the prime-ness of a single value.
 */
public class SievePrimeGenerator implements PrimeNumberGenerator{

    @Override
    public List<Integer> generate(int startingValue, int endingValue){
        // Address flipped inputs.
        int lowVal = min(startingValue, endingValue);
        int highVal = max(startingValue, endingValue);

        int upperLimit = floor(sqrt(end))
        List<Integer> rootPrimes = this.basicSieve()

        List<Integer> primeNumbers = new LinkedList<>();

        return primeNumbers;
    }


    /**
     * Generates primes from 0 to upperLimit using the Sieve of Eratosthenes
     * @param upperLimit The maximum range to check for primes
     * @return Returns list of prime integers
     */
    public List<Integer> basicSieve(int upperLimit){
        // Create list to store primes in, and a prepared "sieve" array.
        List<Integer> primeNumbers = new LinkedList<>();
        List<Boolean> primeSieve = new ArrayList<Boolean>(Arrays.asList(new Boolean[upperLimit+1]));
        Collections.fill(primeSieve, Boolean.FALSE);

        // Calculate primes using Sieve of Eratosthenes
        for (int i=2; i <= upperLimit; ++i){
            if(primeSieve.get(i) == false){
                primeNumbers.add(i);
                for (int j=i; j<= upperLimit; j += i){
                    primeSieve.set(j, true);
                }
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
