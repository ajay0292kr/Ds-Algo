package Multithread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureC {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 1";
        });

        future.thenAccept(System.out::println);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10)
                .thenApplyAsync(result -> result * 2)
                .thenApplyAsync(result -> result + 5);

        future.thenAccept(System.out::println);

        // Run multiple futures in parallel using CompletableFuture
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return "Result 1";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return "Result 3";
        });

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            return "Result 4";
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.thenRun(() -> {
            // All futures completed
            String result1 = future1.join();
            String result3 = future3.join();
            String result4 = future4.join();
            System.out.println(result1 + ", " + result3 + ", " + result4);
        });

        // Handling an exception in a single CompletableFuture:
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            int result = 10 / 0; // Causes an ArithmeticException
            return result;
        });

        future.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return String.valueOf(0); // Default value to return if there's an exception
        }).thenAccept(result -> {
            System.out.println("Result: " + result);
        });

    }
}
