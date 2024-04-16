package ru.mirea.practices.practice_6.Builder;

class ConcreteHouseBuilder extends HouseBuilder {
  @Override
  public void buildFoundation() {
    house.setFoundation("Concrete foundation");
  }

  @Override
  public void buildStructure() {
    house.setStructure("Concrete structure");
  }

  @Override
  public void buildRoof() {
    house.setRoof("Concrete roof");
  }

  @Override
  public void buildGarage() {
    house.setHasGarage(true);
  }
}