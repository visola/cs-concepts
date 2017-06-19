package org.visola.cs.algorithm.sort;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import org.visola.cs.util.Collections2;

public class SorterTest {

  private List<Sorter> allSorters = new ArrayList<>();

  @Before
  public void setup() {
    for (Iterator<Sorter> iterator = ServiceLoader.load(Sorter.class).iterator(); iterator.hasNext();) {
      allSorters.add(iterator.next());
    }
    assertTrue("At least one implementation is provided.", allSorters.size() > 0);
  }

  @Test
  public void sortsNumbersCorrectly() {
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> toSort = Arrays.asList(2, 5, 1, 10, 9, 8, 6, 3, 4, 7);

    for (Sorter sorter : allSorters) {
      sort(sorter, toSort);
      Integer previous = null;
      assertEquals("Expected "+sorter.getClass().getName()+" to sort elements.", expected, toSort);
    }
  }

  @Test
  public void sortsRandomlyShuffledNumbersCorrectly() {
    Random random = new Random();
    for (Sorter sorter : allSorters) {
      for (int i = 0; i < 10; i++) {
        List<Integer> toSort = new ArrayList<>();
        random.ints(100).forEach(toSort::add);
        sort(sorter, toSort);

        Integer previous = null;
        for (Integer element : toSort) {
          if (previous != null) {
            assertThat("Must sort all elements correctly.", element, greaterThanOrEqualTo(previous));
          }
          previous = element;
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void sort(Sorter sorter, List<Integer> toSort) {
    Collections2.reset();
    sorter.sort(toSort);
    System.out.printf("--- Statistics for %s", sorter.getClass().getName());

    int size = toSort.size();
    System.out.printf("N is: %d, For reference: N^2 = %d, N Log N = %f%n", size, size * size, size * Math.log(size));

    int compareCount = Collections2.getCompareCount();
    int swapCount = Collections2.getSwapCount();
    System.out.printf("Comparison: %d%n", compareCount);
    System.out.printf("Swaps: %d%n", swapCount);
    System.out.printf("Total operations: %d%n", swapCount + compareCount);
  }

}
