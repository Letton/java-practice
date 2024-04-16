package ru.mirea.practices.practice_8.Memento;

// Originator
public class Editor {
  private String text;

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public EditorSnapshot createSnapshot() {
    return new EditorSnapshot(text);
  }

  public void restore(EditorSnapshot snapshot) {
    this.text = snapshot.getText();
  }
}