package ru.mirea.practices.practice_5;

public class StaticBlockSingleton {
  private static final StaticBlockSingleton instance;

  static {
    try {
      instance = new StaticBlockSingleton();
    } catch (Exception e) {
      throw new RuntimeException("Exception occured in creating singleton instance");
    }
  }

  private StaticBlockSingleton() {
    System.out.println("StaticBlockSingleton");
  }

  public static StaticBlockSingleton getInstance() {
    return instance;
  }
}
