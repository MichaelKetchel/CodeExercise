package com.emkode.tests;

import com.emkode.SievePrimeGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SievePrimeGeneratorTest {

    // Centrally define lists
    List<Integer> validPrimesA = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
            61, 67, 71, 73, 79, 83, 89, 97, 101);
    List<Integer> validPrimesB = Arrays.asList(7901, 7907, 7919);
    List<Integer> invalidPrimesA = Arrays.asList(0, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 7905, 7902);



    @Test
    void generate() {
    }

    /**
     * Check that basicSieve returns a list of known primes
     */
    @Test
    void basicSievePrimes() {
        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check 0-101
        List<Integer> testListA =  testClass.basicSieve(101);
        assertEquals(validPrimesA, testListA);                 // Lists have same contents
        assertEquals(validPrimesA.size(), testListA.size());   // Length is correct.
        assertNotSame(validPrimesA, testListA);                // Lists are not same object
    }

    /**
     * Check that basicSieve doesn't return any known non-primes.
     */
    @Test
    void basicSieveNonPrimes() {
        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check 0-101
        List<Integer> testListA =  testClass.basicSieve(101);

        for(int i : invalidPrimesA){
            assertFalse(testListA.contains(i));
        }
    }

    @Test
    void isPrime() {
    }
}