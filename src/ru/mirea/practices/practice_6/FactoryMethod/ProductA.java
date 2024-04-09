package ru.mirea.practices.practice_6.FactoryMethod;

public class ProductA implements Product {
  @Override
  public void useProduct() {
    System.out.println("Using Product A");
  }
}