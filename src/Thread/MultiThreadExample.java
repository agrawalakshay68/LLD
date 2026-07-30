package Thread;

public class MultiThreadExample {
    static void main() {
        for (int i = 1; i <= 5; i++) {
            Runnable task = new NumberPrinter(i);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}

class NumberPrinter implements Runnable{
    private int number;

    public NumberPrinter(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number is : " + number);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + e.getMessage());
        }
    }
}
