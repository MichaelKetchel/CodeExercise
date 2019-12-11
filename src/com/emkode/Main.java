package com.emkode;

/**
 * Drive some sample cases.
 */
public class Main {

    public static void main(String[] args) {
	    // Test a few cases

        BruteForcePrimeGenerator bfpg = new BruteForcePrimeGenerator();

        System.out.println(String.format("Is 2 prime? %s", bfpg.isPrime(2)));
        System.out.println(String.format("Is 4 prime? %s", bfpg.isPrime(4)));
        System.out.println(String.format("Is 8 prime? %s", bfpg.isPrime(8)));

        System.out.println(String.format("Primes from 1 to 20: %s", bfpg.generate(0, 20)));
        System.out.println(String.format("Primes from 1 to 20: %s", bfpg.generate(7900, 7920)));

        

    }
}
