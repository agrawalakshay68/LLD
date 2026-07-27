package Creational.Singleton;

/*
In eager initialization, the Creational.Singleton instance is created as soon as the class/module is loaded, before any thread can access it.
That makes it inherently thread-safe without explicit locks, because initialization happens once during load/initialization.

This approach is suitable if your application always creates and uses the singleton instance, or the overhead of creating it is minimal.
 */

public class EagerSingleton {
    // Holds the single shared instance (created immediately at class load time)
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor prevents creating objects from outside the class
    private EagerSingleton() {}

    // Global access point to get the Creational.Singleton instance
    public static EagerSingleton getInstance() {
        // Return the already-created shared instance
        return instance;
    }
}
