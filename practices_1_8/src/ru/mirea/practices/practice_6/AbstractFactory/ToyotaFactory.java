package ru.mirea.practices.practice_6.AbstractFactory;

public class ToyotaFactory implements CarsFactory {
  @Override
  public Sedan createSedan() {
    return new ToyotaSedan();
  }

  @Override
  public Coupe createCoupe() {
    return new ToyotaCoupe();
  }
}