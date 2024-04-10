package ru.mirea.practices.practice_8.Memento;

import java.util.Stack;

public class History {
  private final Stack<EditorSnapshot> snapshots = new Stack<>();

  public void save(Editor editor) {
    snapshots.push(editor.createSnapshot());
  }

  public void undo(Editor editor) {
    if (!snapshots.isEmpty()) {
      EditorSnapshot snapshot = snapshots.pop();
      editor.restore(snapshot);
    }
  }
}