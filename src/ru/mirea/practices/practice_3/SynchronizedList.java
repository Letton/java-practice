package ru.mirea.practices.practice_3;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedList<E> {
  private final List<E> list = new ArrayList<>();

  public synchronized boolean add(E e) {
    return list.add(e);
  }

  public synchronized boolean remove(Object o) {
    return list.remove(o);
  }

  public synchronized E get(int index) {
    return list.get(index);
  }

  public synchronized int size() {
    return list.size();
  }

}
