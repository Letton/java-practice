package ru.mirea.practices.practice_6.FactoryMethod;

public class CreatorB extends Creator {
  @Override
  public Product factoryMethod() {
    return new ProductB();
  }
}
