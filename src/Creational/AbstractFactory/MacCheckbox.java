package Creational.AbstractFactory;

public class MacCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Creating a checkbox in Mac Style.");
    }
}
