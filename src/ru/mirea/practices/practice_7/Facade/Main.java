package ru.mirea.practices.practice_7.Facade;

public class Main {
  public static void main(String[] args) {
    MultimediaFacade multimedia = new MultimediaFacade();

    multimedia.playVideo("video.mp4");
    multimedia.playAudio("audio.mp3");
  }
}
