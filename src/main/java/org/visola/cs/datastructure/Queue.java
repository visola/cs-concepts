package org.visola.cs.datastructure;

public interface Queue<T> {

  boolean enQueue(T value);

  boolean deQueue();

  T front();

  T rear();

  boolean isEmpty();

  boolean isFull();

}
