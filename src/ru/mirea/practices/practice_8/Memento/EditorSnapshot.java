package ru.mirea.practices.practice_8.Memento;

// Memento
public class EditorSnapshot {
  private final String text;

  public EditorSnapshot(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}