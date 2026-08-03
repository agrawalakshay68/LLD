package Creational.AbstractFactory;

public class WinCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Creating checkbox in Windows style.");
    }
}
