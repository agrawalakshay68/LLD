package Structural.Composite;

public class MultiThreadDemo {
    static void main() throws InterruptedException {
        Directory root = new Directory("root");

        Runnable addFilesTask = () -> {
            for (int i = 0; i < 10; i++){
                root.add(new File("File_" + i + ".txt"));
            }
        };

        // creating multiple threads trying to do the same
        Thread t1 = new Thread(addFilesTask);
        Thread t2 = new Thread(addFilesTask);
        Thread t3 = new Thread(addFilesTask);

        // start
        t1.start();
        t2.start();
        t3.start();

        // wait for completion
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        root.showDetails(0);
    }
}

/*
C:\Users\akshay\.jdks\openjdk-26.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.0.1\lib\idea_rt.jar=49763" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\akshay\IdeaProjects\LLD\out\production\LLD Structural.Composite.MultiThreadDemo
root
--File_0.txt
--File_1.txt
--File_1.txt
--File_2.txt
--File_2.txt
--File_3.txt
--File_3.txt
--File_4.txt
--File_5.txt
--File_6.txt
--File_5.txt
--File_8.txt
--File_5.txt
--File_9.txt
--File_8.txt
--File_6.txt
--File_9.txt
--File_7.txt
--File_8.txt
--File_9.txt

Process finished with exit code 0

 */
