package ru.mirea.practices.practice_6.AbstractFactory;

public interface CarsFactory {
  Sedan createSedan();

  Coupe createCoupe();
}