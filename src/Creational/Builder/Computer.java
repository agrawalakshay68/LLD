package Creational.Builder;

public class Computer {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;

    private Computer(Builder builder){
        cpu = builder.cpu;
        gpu = builder.gpu;
        ram = builder.ram;
        storage = builder.storage;
    }

    public void show(){
        System.out.println("cpu: " + cpu + "\ngpu: " + gpu + "\nram: " + ram + "GB \nstorage: " + storage + "GB");
    }

    public static class Builder{
        private String cpu;
        private String gpu;
        private int ram;
        private int storage;

        public Builder addCpu(String cpu){
            this.cpu = cpu;
            return this;
        }

        public Builder addGpu(String gpu){
            this.gpu = gpu;
            return this;
        }

        public Builder addRam(int ram){
            this.ram = ram;
            return this;
        }

        public Builder addStorage(int storage){
            this.storage = storage;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
