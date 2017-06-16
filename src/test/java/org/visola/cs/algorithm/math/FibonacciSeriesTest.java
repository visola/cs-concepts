package org.visola.cs.algorithm.math;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FibonacciSeriesTest {

  private static final Class<? extends FibonacciSeries> [] ALL_IMPLEMENTATIONS = new Class [] {
    IterativeFibonacciSeries.class
  };

  private List<FibonacciSeries> allSeries = new ArrayList<>();

  @Before
  public void setup() throws Exception {
    for (Class<? extends FibonacciSeries> c : ALL_IMPLEMENTATIONS) {
      allSeries.add(c.newInstance());
    }
  }

  @Test
  public void calculateNthFibonacciNumber() {
    for (FibonacciSeries fibonacciSeries : allSeries) {
      for (int index = 0; index < FibonacciSeries.FIBONACCI_NUMBERS.length; index++) {
        assertEquals(
          "Wrong Fibonacci number at "+index+" for series "+fibonacciSeries.getClass().getName(),
          FibonacciSeries.FIBONACCI_NUMBERS[index],
          fibonacciSeries.getNumberAt(index)
        );
      }
    }
  }

  @Test
  public void calculateSumOfNthFibonacciNumbers() {
    for (FibonacciSeries fibonacciSeries : allSeries) {
      for (int index = 0; index < FibonacciSeries.FIBONACCI_SUM.length; index++) {
        assertEquals(
          "Wrong sum result at "+index+" for series "+fibonacciSeries.getClass().getName(),
          FibonacciSeries.FIBONACCI_SUM[index],
          fibonacciSeries.sumUpTo(index)
        );
      }
    }
  }

}
