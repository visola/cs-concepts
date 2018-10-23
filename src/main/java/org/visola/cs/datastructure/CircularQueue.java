package org.visola.cs.datastructure;

public class CircularQueue<T> implements Queue<T> {

  private final Object[] items;

  private int headIndex = -1;
  private int tailIndex = -1;

  public CircularQueue(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Size must be greater than zero, was: " + size);
    }
    this.items = new Object[size];
  }

  @Override
  public boolean enQueue(T value) {
    int newPos = nextPos(tailIndex);
    if (newPos == headIndex) {
      return false;
    }

    tailIndex = newPos;
    items[tailIndex] = value;

    if (headIndex == -1) {
      headIndex = tailIndex;
    }

    return true;
  }

  @Override
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }

    items[headIndex] = null;
    headIndex = nextPos(headIndex);

    int nextTailIndex = nextPos(tailIndex);
    if (headIndex == nextTailIndex) {
      headIndex = -1;
      tailIndex = -1;
      // Queue is now empty
      return true;
    }

    return true;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T front() {
    if (isEmpty()) {
      return null;
    }
    return (T) items[headIndex];
  }

  @Override
  @SuppressWarnings("unchecked")
  public T rear() {
    if (isEmpty()) {
      return null;
    }
    return (T) items[tailIndex];
  }

  @Override
  public boolean isEmpty() {
    return headIndex == -1 && tailIndex == -1;
  }

  @Override
  public boolean isFull() {
    return nextPos(tailIndex) == headIndex;
  }

  private int nextPos(int curPos) {
    return (curPos + 1) % items.length;
  }

}
