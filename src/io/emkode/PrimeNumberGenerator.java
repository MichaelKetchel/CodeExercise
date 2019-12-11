package io.emkode;

import java.util.LinkedList;
import java.util.List;


/**
 * Generates prime numbers within a range, or returns the prime-ness of a single value.
 */
public interface PrimeNumberGenerator {
    /**
     * @param startingValue The first boundary of the range of numbers to be generated.
     * @param endingValue The first boundary of the range of numbers to be generated.
     * @return List of prime numbers within range.
     */
    List<Integer> generate(int startingValue, int endingValue);

    /**
     * Returns true if `value` prime, false if it is not.
     * @param value The value to check for prime-ness.
     * @return True if prime, false if not.
     */
    boolean isPrime(int value);
}

