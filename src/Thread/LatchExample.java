package Thread;

import java.util.concurrent.CountDownLatch;

public class LatchExample {
    static void main() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // initialize the count with 3

        for (int i = 0; i < 3; i++){
            Thread workerThread = new Thread(new Worker(latch));
            workerThread.start();
        }

        latch.await(); // wait until all threads get completed count == 0
        System.out.println("All threads have completed the execution.");
    }

    static class Worker implements Runnable{
        private CountDownLatch latch;
        
        public Worker(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            double v = Math.random() * 2000;
            try {
                Thread.sleep((long) v);
                System.out.println("Work completed by: " + Thread.currentThread().getName());
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
