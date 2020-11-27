package string;

public class Volatile {
      private static boolean ready;
      private static int number;

      private static class ReaderThread extends Thread {
          @Override
          public void run() {
              while(!ready) {
                  Thread.yield();
              }
              System.out.println(number);
          }
     }


     public static void main(String[] args) {
          new ReaderThread().start();
          new ReaderThread().start();
          ready = true;
          number = 55;

      }
}
