package Structural.Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryThreadSafe implements Component{
    List<Component> components = Collections.synchronizedList(new ArrayList<>());
    private String name;

    public DirectoryThreadSafe(String name){
        this.name = name;
    }

    public void add(Component component){
        synchronized (components) {
            components.add(component);
        }
    }

    @Override
    public void showDetails(int depth) {
        synchronized (components) {
            System.out.println("--".repeat(depth) + name);
            for (Component component : components) {
                component.showDetails(depth + 1);
            }
        }
    }
}
