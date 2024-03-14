package ru.mirea.practices.practice_3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> {
  private final Set<E> set = new HashSet<>();
  private final Semaphore semaphore = new Semaphore(1);

  public boolean add(E e) {
    boolean result = false;
    try {
      semaphore.acquire();
      result = set.add(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
    return result;
  }

  public boolean remove(E e) {
    boolean result = false;
    try {
      semaphore.acquire();
      result = set.remove(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
    return result;
  }

  public boolean contains(E e) {
    boolean result = false;
    try {
      semaphore.acquire();
      result = set.contains(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
    return result;
  }

  public int size() {
    int result = 0;
    try {
      semaphore.acquire();
      result = set.size();
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
    return result;
  }

  public boolean isEmpty() {
    boolean result = false;
    try {
      semaphore.acquire();
      result = set.isEmpty();
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
    return result;
  }

  public void clear() {
    try {
      semaphore.acquire();
      set.clear();
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
  }
}
