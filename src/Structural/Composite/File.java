package Structural.Composite;

public class File implements Component{
    private String name;

    public File(String name){
        this.name = name;
    }

    @Override
    public void showDetails(int depth) {
        System.out.println("--".repeat(depth) + name);
    }
}
