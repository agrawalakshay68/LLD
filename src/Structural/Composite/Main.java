package Structural.Composite;

public class Main {
    static void main() {
        Component file1 = new File("File1.txt");
        Component file2 = new File("File2.txt");
        Component file3 = new File("File3.txt");

        Directory dir1 = new Directory("Dir1");
        dir1.add(file1);
        dir1.add(file2);

        Directory dir2 = new Directory("Dir2");
        dir2.add(file3);

        Directory root = new Directory("root");
        root.add(dir1);
        root.add(dir2);

        root.showDetails(0);
    }
}

/*
root
--Dir1
----File1.txt
----File2.txt
--Dir2
----File3.txt
 */