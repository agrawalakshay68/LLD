package Creational.AbstractFactory;

public class AbstractFactoryPattern {

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            factory = new WinFactory();
        } else {
            factory = new MacFactory();
        }

        app = new Application(factory);
        return app;
    }

    static void main() {
        Application app = configureApplication();
        app.paint();
    }

}
