package ru.mirea.practices.practice_3;

public class Main {

  public static void main(String[] args) {
    SemaphoreSet<Integer> semaphoreSet = new SemaphoreSet<>();
    SynchronizedList<Integer> synchronizedList = new SynchronizedList<>();
    Thread one = new Thread(() -> {
      semaphoreSet.add(1);
      semaphoreSet.add(2);
      semaphoreSet.add(3);
      synchronizedList.add(1);
      synchronizedList.add(2);
    });
    Thread two = new Thread(() -> {
      semaphoreSet.add(4);
      semaphoreSet.add(5);
      System.out.println("SemaphoreSet contains 3: " + semaphoreSet.contains(3));
      System.out.println("SemaphoreSet contains 6: " + semaphoreSet.contains(6));
      semaphoreSet.remove(3);
      System.out.println("SemaphoreSet contains 3: " + semaphoreSet.contains(3));
      System.out.println("SemaphoreSet size: " + semaphoreSet.size());
      synchronizedList.add(3);
      synchronizedList.add(4);
      synchronizedList.add(5);
      System.out.println("SynchronizedList[2]: " + synchronizedList.get(2));
      System.out.println("SynchronizedList[4]: " + synchronizedList.get(4));
      synchronizedList.remove(3);
      System.out.println("SynchronizedList contains 3: " + synchronizedList.get(2));
    });
    one.start();
    two.start();

  }

}
