package Multithread;

import java.util.concurrent.Semaphore;

public class EvenOddSemaphore {
    private static final int MAX = 10;
    private static final Semaphore oddSemaphore = new Semaphore(1); // start with odd
    private static final Semaphore evenSemaphore = new Semaphore(0); // block even
    public static void main(String[] args) {
      Thread oddThread = new Thread(() -> {
          for (int i = 1; i <= MAX; i+=2) {
              try {
                  oddSemaphore.acquire();
                  System.out.println(i);
                  evenSemaphore.release();
              }catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
          }
      });

      Thread evenThread = new Thread(() -> {
          for (int i = 2; i <=MAX; i+=2) {
              try {
                 evenSemaphore.acquire();
                 System.out.print(i);
                 oddSemaphore.release();
              }catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
          }
      });

      oddThread.start();
      evenThread.start();
    }
}
