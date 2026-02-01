package Multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorWithVirtual {
    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                int id = i;
                executor.submit(() -> {
                    System.out.println("Task " + id + " running in " + Thread.currentThread());
                });
            }
        } // Auto-closes & waits for tasks
    }
}
/*
    🔮 Why Important?
      Before: Handling 100K concurrent users needed complex async frameworks (Netty, reactive programming).
      Now: You can write simple blocking code with virtual threads, and still scale.
 */