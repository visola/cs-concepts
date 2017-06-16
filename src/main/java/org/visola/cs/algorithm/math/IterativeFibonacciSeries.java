package org.visola.cs.algorithm.math;

/**
 * Implementation of the Fibonacci Series using iterative algorithms and no
 * memoization.
 */
public class IterativeFibonacciSeries implements FibonacciSeries {

  public static void main (String [] args) {
    IterativeFibonacciSeries fibo = new IterativeFibonacciSeries();
    for (int i = 0; i < 200; i++) {
      System.out.print(fibo.sumUpTo(i) + "L, ");
    }
  }

  public long getNumberAt(long position) {
    if (position == 0 || position == 1) {
      return 1;
    }
    long previous = 1;
    long current = 1;
    int i = 1;
    while (i < position) {
      long temp = previous + current;
      previous = current;
      current = temp;
      i++;
    }
    return current;
  }

  public long sumUpTo(long position) {
    long result = 1;

    int i = 0;
    long previous = 1;
    long current = 1;
    while (i < position) {
      result += current;
      long temp = previous + current;
      previous = current;
      current = temp;
      i++;
    }
    return result;
  }

}
