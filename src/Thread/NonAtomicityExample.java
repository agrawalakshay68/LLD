package Thread;

public class NonAtomicityExample {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    static void main() throws InterruptedException {
        NonAtomicityExample example = new NonAtomicityExample();
        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 1000; i++)
                example.increment();
        });

        Thread t2 = new Thread( () -> {
            for (int i = 0; i < 1000; i++)
                example.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final count : " + example.getCount());
    }
}

/*
C:\Users\akshay\.jdks\openjdk-26.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.0.1\lib\idea_rt.jar=59375" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\akshay\IdeaProjects\LLD\out\production\LLD Thread.NonAtomicityExample
final count : 1883

Process finished with exit code 0

 */
