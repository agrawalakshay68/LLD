package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    private static final Lock mutex = new ReentrantLock();

    static void main() {
        Thread t1 = new Thread(new Worker(), "Thread 1");
        Thread t2 = new Thread(new Worker(), "Thread 2");

        t1.start();
        t2.start();
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            mutex.lock();
            System.out.println("Work in shared source started by Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                System.out.println("Work completed by Worker: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                mutex.unlock();
            }
        }
    }
}
