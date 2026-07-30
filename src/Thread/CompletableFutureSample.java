package Thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSample {
    static void main() {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync( () -> {
            System.out.println("Task 1 is executing asynchronously started");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 is executing asynchronously ended");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync( () -> {
            System.out.println("Task 2 is executing asynchronously started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2 is executing asynchronously ended");
        });

        // wait for both task to complete
        CompletableFuture.allOf(future1, future2).join();
        System.out.println("Both tasks completed");
    }
}
