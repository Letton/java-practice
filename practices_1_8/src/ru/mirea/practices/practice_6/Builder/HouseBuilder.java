package ru.mirea.practices.practice_6.Builder;

abstract class HouseBuilder {
  protected House house;

  public void createHouse() {
    house = new House();
  }

  public House getHouse() {
    return house;
  }

  public abstract void buildFoundation();

  public abstract void buildStructure();

  public abstract void buildRoof();

  public abstract void buildGarage();
}