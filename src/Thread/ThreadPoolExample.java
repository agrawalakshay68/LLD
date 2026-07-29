package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    static void main() {
        // create a thread pool with fix number of threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // submit tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor.submit( () -> {
                System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                // simulate task execution
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted " + e.getMessage());
                }
                System.out.println("Task completed by " + Thread.currentThread().getName());
            });
        }

        // shutdown the threadpool
        executor.shutdown();

        // force shut down it exceeds some timeout
        try{
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)){
                // if all task is not completed within time frame we force shutdown
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Thead interrupted " + e.getMessage());
        }
    }
}
