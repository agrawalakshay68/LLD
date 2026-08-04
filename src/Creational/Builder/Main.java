package Creational.Builder;

public class Main {
    static void main() {
        Computer pc = new Computer.Builder()
                .addCpu("Ryzen 7")
                .addGpu("RTX 4060")
                .addRam(32)
                .addStorage(512)
                .build();

        pc.show();
    }
}
