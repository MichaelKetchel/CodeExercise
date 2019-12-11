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



    /**
     * Test base example set, from 0-101.
     * Primes are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
     */
    @Test
    void generateExampleSet() {

        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check 0-101
        List<Integer> testListA =  testClass.generate(0, 101);
        assertEquals(validPrimesA, testListA);                 // Lists have same contents
        assertEquals(validPrimesA.size(), testListA.size());   // Length is correct.
        assertNotSame(validPrimesA, testListA);                // Lists are not same object

    }

    /**
     * Test base example set, but reversed input, from 0-101.
     * Primes are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
     */
    @Test
    void generateExampleSetReverse() {

        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check 0-101
        List<Integer> testListA =  testClass.generate(101, 0);
        assertEquals(validPrimesA, testListA);                 // Lists have same contents
        assertEquals(validPrimesA.size(), testListA.size());   // Length is correct.
        assertNotSame(validPrimesA, testListA);                // Lists are not same object

    }


    /**
     * Tests numbers from 7900-7920
     * Should find 7901,7907, 7919
     */
    @Test
    void generate7K() {

        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check 7900-7920
        List<Integer> testList =  testClass.generate(7900, 7920);

        assertEquals(validPrimesB, testList);                  // Lists have same contents
        assertEquals(validPrimesB.size(), testList.size());    // Length is correct.
        assertNotSame(validPrimesB, testList);                 // Lists are not same object

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

    /**
     * Tests prime tester against all primes in provided known prime set.
     */
    @Test
    void isPrime() {
        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check for a handful of entries that we know are prime
        for (int i : validPrimesA){
            assertTrue(testClass.isPrime(i), String.format("%s is prime", i));
        }

    }

    /**
     * Tests prime tester against handful of non-primes, including 1 and 0
     */
    @Test
    void isNotPrime() {
        SievePrimeGenerator testClass = new SievePrimeGenerator();

        // Check for a handful that we know are not prime:
        for (int i : invalidPrimesA){
            assertFalse(testClass.isPrime(i), String.format("%s is prime", i));
        }

    }
}