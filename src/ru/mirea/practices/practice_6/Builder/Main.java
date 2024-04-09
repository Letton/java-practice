package ru.mirea.practices.practice_6.Builder;

public class Main {
  public static void main(String[] args) {
    HouseBuilder builder = new ConcreteHouseBuilder();
    ConstructionEngineer engineer = new ConstructionEngineer(builder);
    House house = engineer.constructHouse();
    System.out.println("House: " + house);
  }
}
