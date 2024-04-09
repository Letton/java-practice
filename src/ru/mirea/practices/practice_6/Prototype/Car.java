package ru.mirea.practices.practice_6.Prototype;

public class Car implements Cloneable {
  private String make;
  private String model;

  public Car(String make, String model) {
    this.make = make;
    this.model = model;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Car clone() {
    try {
      return (Car) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}