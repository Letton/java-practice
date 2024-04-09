package ru.mirea.practices.practice_6.FactoryMethod;

public class ProductB implements Product {
  @Override
  public void useProduct() {
    System.out.println("Using Product B");
  }
}