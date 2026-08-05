package Structural.Composite;

public class MultiThreadFix {
    static void main() throws InterruptedException {
        DirectoryThreadSafe root = new DirectoryThreadSafe("root");

        Runnable addFilesTask = () -> {
            for (int i = 0; i < 5; i++){
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
C:\Users\akshay\.jdks\openjdk-26.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.0.1\lib\idea_rt.jar=49772" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\akshay\IdeaProjects\LLD\out\production\LLD Structural.Composite.MultiThreadFix
root
--File_0.txt
--File_1.txt
--File_2.txt
--File_3.txt
--File_4.txt
--File_0.txt
--File_1.txt
--File_2.txt
--File_3.txt
--File_4.txt
--File_0.txt
--File_1.txt
--File_2.txt
--File_3.txt
--File_4.txt

Process finished with exit code 0

 */
