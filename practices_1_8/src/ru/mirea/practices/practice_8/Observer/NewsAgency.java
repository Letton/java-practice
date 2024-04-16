package ru.mirea.practices.practice_8.Observer;

import java.util.List;
import java.util.ArrayList;

public class NewsAgency implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private String latestArticle;

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(latestArticle);
    }
  }

  public void publishArticle(String article) {
    this.latestArticle = article;
    notifyObservers();
  }
}
