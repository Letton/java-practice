package ru.mirea.practices.practice_6.FactoryMethod;

public class Main {
  public static void main(String[] args) {
    Creator creatorA = new CreatorA();
    Product productA = creatorA.factoryMethod();
    productA.useProduct();
    Creator creatorB = new CreatorB();
    Product productB = creatorB.factoryMethod();
    productB.useProduct();
  }
}
