package org.visola.cs.algorithm.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FibonacciSeriesTest {

  private List<FibonacciSeries> allSeries = new ArrayList<>();

  @Before
  public void setup() throws Exception {
    for (Iterator<FibonacciSeries> iterator = ServiceLoader.load(FibonacciSeries.class).iterator(); iterator.hasNext();) {
      allSeries.add(iterator.next());
    }
    assertTrue("At least one implementation is provided.", allSeries.size() > 0);
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
