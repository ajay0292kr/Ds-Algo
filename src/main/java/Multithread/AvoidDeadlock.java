package Multithread;

public class AvoidDeadlock {
    // Simply reorder it

  /*  Runnable bolck1 = () -> {
        synchronized (b) {
            try {
                // Adding delay so that both threads can start trying to
                // lock resources
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread-1 have A but need B also
            synchronized (a) {
                System.out.println("In block 1");
            }
        }
    };
    // Thread-2
    Runnable block2 = () -> {
        synchronized (b) {
            // Thread-2 have B but need A also
            synchronized (a) {
                System.out.println("In block 2");
            }
        }
    };*/
}
