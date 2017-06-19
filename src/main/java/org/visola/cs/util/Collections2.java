package org.visola.cs.util;

import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Utility class to help with algorithms that involve collections. Also useful
 * to calculate the number of operations executed.
 */
public class Collections2 {

  private static AtomicInteger compareCount = new AtomicInteger();
  private static AtomicInteger swapCount = new AtomicInteger();

  public static <T extends Comparable<? super T>> int compare(T tis, T that) {
    compareCount.incrementAndGet();
    if (tis == null && that != null) {
      return -1;
    }
    if (that == null && tis != null) {
      return +1;
    }
    return tis.compareTo(that);
  }

  public static <T> void swap(List<T> toSwap, int from, int to) {
    swapCount.incrementAndGet();
    T temp = toSwap.get(from);
    toSwap.set(from, toSwap.get(to));
    toSwap.set(to, temp);
  }

  public static int getCompareCount() {
    return compareCount.get();
  }

  public static int getSwapCount() {
    return swapCount.get();
  }

  public static void reset() {
    compareCount.set(0);
    swapCount.set(0);
  }

}
