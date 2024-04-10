package ru.mirea.practices.practice_8.Observer;

public class Main {
  public static void main(String[] args) {
    NewsAgency newsAgency = new NewsAgency();
    Subscriber subscriber1 = new Subscriber("John Doe");
    Subscriber subscriber2 = new Subscriber("Jane Doe");

    newsAgency.registerObserver(subscriber1);
    newsAgency.registerObserver(subscriber2);

    newsAgency.publishArticle("Understanding the Observer Pattern");

    newsAgency.removeObserver(subscriber1);

    newsAgency.publishArticle("Observer Pattern in Java");
  }
}
