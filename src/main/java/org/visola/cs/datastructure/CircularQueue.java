package org.visola.cs.datastructure;

public class CircularQueue<T> implements Queue<T> {

  private final Object[] items;

  private int head = -1;
  private int tail = -1;

  public CircularQueue(int size) {
    this.items = new Object[size];
  }

  @Override
  public boolean enQueue(T value) {
    int newPos = nextPos(tail);
    if (newPos == head) {
      return false;
    }

    tail = newPos;
    items[tail] = value;

    if (head == -1) {
      head = tail;
    }

    return true;
  }

  @Override
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }

    items[head] = null;
    head = nextPos(head);

    int nextTail = nextPos(tail);
    if (head == nextTail) {
      head = -1;
      tail = -1;
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
    return (T) items[head];
  }

  @Override
  @SuppressWarnings("unchecked")
  public T rear() {
    if (isEmpty()) {
      return null;
    }
    return (T) items[tail];
  }

  @Override
  public boolean isEmpty() {
    return head == -1 && tail == -1;
  }

  @Override
  public boolean isFull() {
    return nextPos(tail) == head;
  }

  private int nextPos(int curPos) {
    int nextPos = curPos + 1;
    if (nextPos == items.length) {
      return 0;
    }
    return nextPos;
  }

}
