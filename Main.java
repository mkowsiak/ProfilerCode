import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Main {

  private static int NO_THREADS_MINIMUM = 2;   // these are arbitrary
  private static int NO_THREADS_MAXIMUM = 4;  // numbers

  private static int SLEEP_MIN = 5;            // I think it makes no sense
  private static int SLEEP_MAX = 10;           // to sleep longer than 10 seconds

  private static int MEM_MIN = 512 * (int) Math.pow(10, 3);     // 512 KB is the minimum
  private static int MEM_MAX = 512 * (int) Math.pow(10, 6);     // 512 MB is the maximum
  
  public static void main(String [] arg) {

    int loopIndex = 0;

    while( true ) {
      // Each time, I create random number of threads
      // Each thread will sleep for random time
      // Each thread will allocate random ammount of memory
      int numberOfThreads = ThreadLocalRandom.current().nextInt( NO_THREADS_MINIMUM, NO_THREADS_MAXIMUM + 1);
      
      System.out.println("Startin loop: " + loopIndex + " there will be " + numberOfThreads + " threads" );

      ArrayList<MemoryThread> threadsArray = new ArrayList<MemoryThread>( numberOfThreads );
      for( int i=0; i<numberOfThreads; i++ ) {
 
        ThreadLocalRandom.current().nextInt( NO_THREADS_MINIMUM, NO_THREADS_MAXIMUM + 1);

        threadsArray.add( new MemoryThread(  loopIndex
                                           , i
                                           , ThreadLocalRandom.current().nextInt( SLEEP_MIN, SLEEP_MAX + 1) 
                                           , ThreadLocalRandom.current().nextInt( MEM_MIN, MEM_MAX + 1)));
      }

      for(MemoryThread thread : threadsArray) {
        thread.start();
      }
      
      for(MemoryThread thread : threadsArray) {
        try {
          thread.join();
        } catch(InterruptedException ex) {
          // I don't care about errors here
        }
      }

      for( int i=0; i<numberOfThreads; i++ ) {
        threadsArray.set( i, null );
      }

      threadsArray = null;

      loopIndex ++;

    }
  }
}

class MemoryThread extends Thread {

  private int loop;
  private int idx;
  private int sleep;
  private int memorySize;

  public MemoryThread(int loop, int idx, int sleep, int memorySize) {
    this.sleep      = sleep;
    this.memorySize = memorySize;
    this.loop       = loop;
    this.idx        = idx;
  }

  public void run() {
    System.out.println("Loop: " + loop + " thread No: " + idx + " memory: " + memorySize + " sleep: " + sleep);
    byte [] array = new byte[memorySize]; 
    try {
      Thread.sleep( sleep * 1000 ); 
    } catch(InterruptedException ex) {
      System.out.println("Ups! I was woken up!");
    }
    array = null;
  }

}
