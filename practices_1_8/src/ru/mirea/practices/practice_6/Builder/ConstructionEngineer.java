package ru.mirea.practices.practice_6.Builder;

class ConstructionEngineer {
  private HouseBuilder builder;

  public ConstructionEngineer(HouseBuilder builder) {
    this.builder = builder;
  }

  public House constructHouse() {
    builder.createHouse();
    builder.buildFoundation();
    builder.buildStructure();
    builder.buildRoof();
    builder.buildGarage();
    return builder.getHouse();
  }
}