package Multithread;

public class PrintEvenAndOddNumber {
    int counter = 1;
    static int N;

    // Function to print odd number
    public void printOdd() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");

                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }
    }

    // Function to print even number

    // Function to print odd number
    public void printEven() {
        synchronized (this) {
            while(counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");

                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }

    }
    public static void main(String[] args) {
        N = 10;
        PrintEvenAndOddNumber obj = new PrintEvenAndOddNumber();
        // create thread 1
        Thread t1 = new Thread(obj::printEven);

        // create thread 2
        Thread t2 = new Thread(obj::printOdd);

            t1.start();
            t2.start();
    }
}
