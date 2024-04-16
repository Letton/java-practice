package ru.mirea.practices.practice_6.FactoryMethod;

public class CreatorA extends Creator {
  @Override
  public Product factoryMethod() {
    return new ProductA();
  }
}
