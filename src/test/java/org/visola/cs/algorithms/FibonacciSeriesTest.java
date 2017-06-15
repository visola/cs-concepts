package org.visola.cs.algorithms;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FibonacciSeriesTest {

  private FibonacciSeries fibonacciSeries;

  @Before
  public void setup() {
    fibonacciSeries = new FibonacciSeries();
  }

  @Test
  public void calculateNthFibonacciNumber() {
    int [] expected = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
    for (int index = 0; index < expected.length; index++) {
      assertEquals("Wrong Fibonacci number at "+index, expected[index], fibonacciSeries.getNumberAt(index));
    }
  }

  @Test
  public void calculateSumOfNthFibonacciNumbers() {
    int [] expected = {1, 2, 4, 7, 12, 20, 33, 54, 88, 143, 232, 376};
    for (int index = 0; index < expected.length; index++) {
      assertEquals("Wrong sum result at "+index, expected[index], fibonacciSeries.sumUpTo(index));
    }
  }

}
