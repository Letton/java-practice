package ru.mirea.practices.practice_5;

public class Main {
  public static void main(String[] args) {
    LazySingleton lazySingleton1 = LazySingleton.getInstance();
    LazySingleton lazySingleton2 = LazySingleton.getInstance();

    System.out.println(lazySingleton1 == lazySingleton2);

    EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
    EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
    enumSingleton1.doSomething();

    System.out.println(enumSingleton1 == enumSingleton2);

    StaticBlockSingleton staticBlockSingleton1 = StaticBlockSingleton.getInstance();
    StaticBlockSingleton staticBlockSingleton2 = StaticBlockSingleton.getInstance();

    System.out.println(staticBlockSingleton1 == staticBlockSingleton2);
  }
}
