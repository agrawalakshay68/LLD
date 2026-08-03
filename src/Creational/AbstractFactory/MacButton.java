package Creational.AbstractFactory;

public class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("Creating a button in MAC style.");
    }
}
