package io.emkode;

import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

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

        // If for some reason we're given a value lower than 2, bring it up to two.
        if (lowVal < 2 )
            lowVal = 2;

        // Calculate up to the sqrt of the max using the basic sieve
        int upperLimit = (int) floor(sqrt(highVal)) + 1;
        List<Integer> rootPrimes = this.basicSieve(upperLimit);

        // New prime list include those calculated by basicSieve
        List<Integer> primeNumbers = new LinkedList<>();

        // Set up a new sieve
        int numberRangeSize = highVal - lowVal + 1;
        List<Boolean> primeSieve = new ArrayList<>(Arrays.asList(new Boolean[numberRangeSize+1]));
        Collections.fill(primeSieve, Boolean.FALSE);

        // Calculate the sieve
        for (int curPrime : rootPrimes) {
            // Calculate an appropriate lower limit for sieve calculations.
            int lowerLimit = (int) (floor(lowVal / curPrime) * curPrime);
            if (lowerLimit < lowVal)
                lowerLimit += curPrime;
            if (lowerLimit == curPrime)
                lowerLimit += curPrime;

            // Mark non-primes in sieve
            for (int j = lowerLimit; j <= highVal; j += curPrime)
                primeSieve.set(j - lowVal, true);
        }

        // Get primes from sieve
        for (int i = lowVal; i <= highVal; i++)
            if(!primeSieve.get(i - lowVal))
                primeNumbers.add(i);

        return primeNumbers;
    }


    /**
     * Generates primes from 2 to upperLimit using the Sieve of Eratosthenes
     * @param upperLimit The maximum range to check for primes
     * @return Returns list of prime integers
     */
    public List<Integer> basicSieve(int upperLimit){
        // Create list to store primes in, and a prepared "sieve" array.
        List<Integer> primeNumbers = new LinkedList<>();
        List<Boolean> primeSieve = new ArrayList<>(Arrays.asList(new Boolean[upperLimit + 1]));
        Collections.fill(primeSieve, Boolean.FALSE);

        // Calculate primes using Sieve of Eratosthenes
        for (int i=2; i <= upperLimit; ++i){
            if(!primeSieve.get(i)){
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
        // Run the number through the sieve.
        List<Integer> primeNumbers = basicSieve(value);
        return primeNumbers.contains(value);
    }
}
