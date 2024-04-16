package ru.mirea.practices.practice_6.AbstractFactory;

public class Main {
  public static void main(String[] args) {
    CarsFactory factory = new ToyotaFactory();
    factory.createCoupe();
  }
}
