package ru.mirea.practices.practice_8.Memento;

public class Main {
  public static void main(String[] args) {
    Editor editor = new Editor();
    History history = new History();

    editor.setText("This is the first sentence.");
    history.save(editor);

    editor.setText("This is the second sentence.");
    history.save(editor);

    editor.setText("This is the third sentence.");

    System.out.println(editor.getText());

    history.undo(editor);
    System.out.println(editor.getText());

    history.undo(editor);
    System.out.println(editor.getText());
  }
}
