package ru.mirea.practices.practice_7.Facade;

class MultimediaFacade {
  private VideoPlayer videoPlayer = new VideoPlayer();
  private AudioPlayer audioPlayer = new AudioPlayer();

  void playVideo(String file) {
    videoPlayer.playVideo(file);
  }

  void playAudio(String file) {
    audioPlayer.playAudio(file);
  }
}
