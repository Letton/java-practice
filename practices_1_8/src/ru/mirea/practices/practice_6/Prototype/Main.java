package ru.mirea.practices.practice_6.Prototype;

public class Main {
  public static void main(String[] args) {
    Car originalCar = new Car("Toyota", "Corolla");
    Car clonedCar = originalCar.clone();

    clonedCar.setModel("Camry");

    System.out.println(originalCar.getModel());
    System.out.println(clonedCar.getModel());
  }
}