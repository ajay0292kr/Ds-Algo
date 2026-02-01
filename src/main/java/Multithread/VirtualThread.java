package Multithread;

public class VirtualThread {
    /*
      ⚙️ When to Use Virtual Threads
         Best for I/O-bound workloads (e.g., web servers, microservices, payment gateways).
         Example: A server handling 100K+ concurrent client connections.
         Not ideal for CPU-bound tasks (because CPU work still needs real cores).
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("Running in " + Thread.currentThread());
        };
        // Create a virtual thread
        Thread vt = Thread.ofVirtual().start(task);
        vt.join();
    }
}
