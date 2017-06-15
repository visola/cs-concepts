package org.visola.cs.algorithms;

/**
 * Implementation of the Fibonacci Series using iterative algorithms and no
 * memoization.
 */
public class FibonacciSeries {

  public int getNumberAt(int position) {
    if (position == 0 || position == 1) {
      return 1;
    }
    int previous = 1;
    int current = 1;
    int i = 1;
    while (i < position) {
      int temp = previous + current;
      previous = current;
      current = temp;
      i++;
    }
    return current;
  }

  public int sumUpTo(int position) {
    int result = 1;

    int i = 0;
    int previous = 1;
    int current = 1;
    while (i < position) {
      result += current;
      int temp = previous + current;
      previous = current;
      current = temp;
      i++;
    }
    return result;
  }

}
