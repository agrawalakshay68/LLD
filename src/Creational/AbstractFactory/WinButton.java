package Creational.AbstractFactory;

public class WinButton implements Button{
    @Override
    public void paint() {
        System.out.println("Creating a button in Windows Style.");
    }
}
