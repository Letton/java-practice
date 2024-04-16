package ru.mirea.practices.practice_8.Observer;

public class Subscriber implements Observer {
  private String name;

  public Subscriber(String name) {
    this.name = name;
  }

  @Override
  public void update(String article) {
    System.out.println(name + " received a new article: " + article);
  }
}