package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Component{
    List<Component> components = new ArrayList<>();
    private String name;

    public Directory(String name){
        this.name = name;
    }

    public void add(Component component){
        components.add(component);
    }

    @Override
    public void showDetails(int depth) {
        System.out.println("--".repeat(depth) + name);
        for (Component component: components){
            component.showDetails(depth+1);
        }
    }
}
