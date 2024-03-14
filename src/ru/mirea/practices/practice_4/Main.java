package ru.mirea.practices.practice_4;

import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    SimpleExecutorService executorService = new SimpleExecutorService(5);

    for (int i = 0; i < 5; i++) {
      int taskId = i;
      executorService.submit(() -> {
        System.out.println("Task " + taskId +
            " в потоке " + Thread.currentThread().getName());
      });
    }

    executorService.shutdown();

    executorService.awaitTermination(1, TimeUnit.MINUTES);

    System.out.println("All tasks done");

    executorService.close();
  }
}
