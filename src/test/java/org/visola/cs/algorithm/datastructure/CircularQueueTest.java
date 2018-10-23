package org.visola.cs.algorithm.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.visola.cs.datastructure.CircularQueue;

public class CircularQueueTest {

  private static final int SIZE = 3;

  private CircularQueue<Integer> circularQueue;

  @Before
  public void setup() {
    circularQueue = new CircularQueue<>(SIZE);
  }

  @Test
  public void testEnQueueWorks() {
    for (int i = 0; i < SIZE; i++) {
      assertTrue("Should enqueue correclty", circularQueue.enQueue(i));
    }
    assertFalse("Should not enqueue when queue is full", circularQueue.enQueue(40));
  }

  @Test
  public void testDeQueueWorks() {
    testEnQueueWorks();
    for (int i = 0; i < SIZE; i++) {
      assertTrue("Should dequeue correclty", circularQueue.deQueue());
    }
    assertFalse("Should not dequeue when queue is empty", circularQueue.deQueue());
  }

  @Test
  public void testFront() {
    circularQueue.enQueue(10);
    assertEquals("Should match value", 10, (int) circularQueue.front());
    circularQueue.deQueue();
    assertNull("Should return null when empty", circularQueue.front());
  }

  @Test
  public void testRear() {
    circularQueue.enQueue(10);
    assertEquals("Should match value", 10, (int) circularQueue.rear());
    circularQueue.deQueue();
    assertNull("Should return null when empty", circularQueue.rear());
  }

  @Test
  public void fullTest() {
    assertTrue("Should now when it is empty", circularQueue.isEmpty());

    circularQueue.enQueue(10);
    circularQueue.enQueue(20);
    assertEquals("Should return correct head", 10, (int) circularQueue.front());
    assertEquals("Should return correct head", 20, (int) circularQueue.rear());

    circularQueue.enQueue(30);
    assertTrue("Should now when it is full", circularQueue.isFull());

    assertTrue("Should deQueue", circularQueue.deQueue());

    circularQueue.enQueue(40);
    assertTrue("Should now when it is full", circularQueue.isFull());

    assertTrue("Should deQueue", circularQueue.deQueue());
    assertTrue("Should deQueue", circularQueue.deQueue());
    assertTrue("Should deQueue", circularQueue.deQueue());

    assertTrue("Should now when it is empty", circularQueue.isEmpty());
  }

}
