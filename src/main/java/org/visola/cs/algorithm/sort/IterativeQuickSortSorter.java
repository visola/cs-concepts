package org.visola.cs.algorithm.sort;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.visola.cs.datastructure.Pair;
import org.visola.cs.util.Collections2;

/**
 * Iterative implementation of the quick sort algorithm.
 *
 * @see https://en.wikipedia.org/wiki/Quicksort
 * @see https://stackoverflow.com/questions/12553238/quicksort-iterative-or-recursive
 */
public class IterativeQuickSortSorter<T extends Comparable<? super T>> implements Sorter<T> {

  public void sort(List<T> toSort) {
    Stack<Pair<Integer>> intervals = new Stack<>();

    // First pivot is the last element in the list
    intervals.push(new Pair<Integer>(0, toSort.size() - 1));

    while (!intervals.empty()) {
      Pair<Integer> interval = intervals.pop();
      int start = interval.getLeft();
      int end = interval.getRight();

      // Nothing to do in this interval
      if (end - start <= 0) {
        continue;
      }

      // Reorder and partition the interval
      T pivot = toSort.get(end);
      int newPivotPosition = start - 1;
      for (int i = start; i < end; i++) {
        if (Collections2.compare(toSort.get(i), pivot) <= 0) {
          newPivotPosition++;
          if (newPivotPosition != i) {
            Collections2.swap(toSort, newPivotPosition, i);
          }
        }
      }

      newPivotPosition++;
      Collections2.swap(toSort, end, newPivotPosition);

      intervals.push(new Pair<>(start, newPivotPosition - 1));
      intervals.push(new Pair<>(newPivotPosition + 1, end));
    }
  }

}
