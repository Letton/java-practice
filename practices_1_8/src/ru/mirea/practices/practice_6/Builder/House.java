package ru.mirea.practices.practice_6.Builder;

class House {
  private String foundation;
  private String structure;
  private String roof;
  private boolean hasGarage;

  public void setFoundation(String foundation) {
    this.foundation = foundation;
  }

  public void setStructure(String structure) {
    this.structure = structure;
  }

  public void setRoof(String roof) {
    this.roof = roof;
  }

  public void setHasGarage(boolean hasGarage) {
    this.hasGarage = hasGarage;
  }

  @Override
  public String toString() {
    return "House{" +
        "foundation='" + foundation + '\'' +
        ", structure='" + structure + '\'' +
        ", roof='" + roof + '\'' +
        ", hasGarage=" + hasGarage +
        '}';
  }
}