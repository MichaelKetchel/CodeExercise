package com.emkode;

import java.util.List;


// I feel like this is backwards -- the interface should be "Generator" or "NumberGenerator" and the implementation
// should be "PrimeNumberGenerator"
public interface PrimeNumberGenerator {
    List<Integer> generate(int startingValue, int endingValue);
    boolean isPrime(int value);


}

class Generator implements PrimeNumberGenerator{

    @Override
    public List<Integer> generate(int startingValue, int endingValue){

    }

    @Override
    public boolean isPrime(int value){
      return false;
    };
}