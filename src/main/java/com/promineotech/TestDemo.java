package com.promineotech;
import java.util.Random;
import java.lang.IllegalArgumentException;
import java.util.random.*;

public class TestDemo {
  
  public int getRandomEvenNumber() {
    Random random = new Random();
    int randomNumber = random.nextInt(10) + 1;
    return randomNumber * 2;
  }
  
  int getRandomInt() {
    Random random = new Random();
    return random.nextInt(10) + 1;
     }
  
  int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(10) + 1;
  }
  
int randomNumberSquared()   {
  int randomNumber = getRandomNumber();
  return randomNumber * randomNumber;
}

  public int addPositive(int a, int b) {
    if(a <= 0 || b<= 0) {
      throw new IllegalArgumentException("Both parameters must be positive");
    }
    return a + b;
  }

  public int getRandomNumberInRange(int min, int max) {
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }  
}
