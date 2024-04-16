package ru.mirea.practices.practice_7.Flyweight;

class Circle implements Shape {
  private String color;

  public Circle(String color) {
    System.out.println("Circle constructor");
    this.color = color;
  }

  @Override
  public void draw(int x, int y, int radius) {
    System.out.println("Circle: Draw() [Color : " + color
        + ", x : " + x + ", y :" + y + ", radius :" + radius);
  }
}