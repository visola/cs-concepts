package org.visola.cs.algorithm.sort;

import java.util.List;

/**
 * Represents a sort algorithm.
 */
public interface Sorter<T extends Comparable<? super T>> {

  /**
   * Sorts a list in place.
   */
  void sort(List<T> toSort);

}
