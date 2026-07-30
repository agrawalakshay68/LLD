package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreSample {
    // Semaphore to control access to the restroom
    private static final Semaphore restroomSemaphore = new Semaphore(3); // at most 3 permits

    static void main() {
        // now say we have multiple persons trying to use Restroom
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=1; i <= 5; i++){
            Runnable person = new Person(i);
            executor.execute(person);
        }

        executor.shutdown();
    }

    static class Person implements Runnable{
        private int number;

        public Person(int number){
            this.number = number;
        }

        @Override
        public void run() {
            // we acquire the permit if present
            try {
                restroomSemaphore.acquire();
                System.out.println("Restroom occupied by Person: " + number);
                Thread.sleep(2000);
                System.out.println("Restroom vacated by Person: " + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                restroomSemaphore.release(); // release the permit
            }
        }
    }
}
