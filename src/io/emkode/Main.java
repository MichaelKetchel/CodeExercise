package io.emkode;

import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

/**
 * Drive some sample cases.
 */
public class Main {

    public static void main(String[] args) {
        BruteForcePrimeGenerator primeGenerator = new BruteForcePrimeGenerator();

        // If args on command line, use those, otherwise ask.
        if(args.length > 0){
            int start = Integer.parseInt(args[0]);
            int end = Integer.parseInt(args[1]);
            List<Integer> primes = primeGenerator.generate(start, end);
            System.out.println(primes);

        } else {
            System.out.print("Enter a negative number to exit.\n\n");

            Scanner in = new Scanner(System.in);
            while(true){

                System.out.print("Enter starting value: ");
                int start = in.nextInt();
                if(start < 0) break;

                System.out.print("Enter ending value: ");
                int end = in.nextInt();
                if(end < 0) break;

                List<Integer> primes = primeGenerator.generate(start, end);

                System.out.print(format("Primes in range %s:%s:\n%s\n", start, end, primes));
            }
        }


    }
}
