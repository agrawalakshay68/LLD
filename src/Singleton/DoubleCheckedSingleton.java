package Singleton;

// as we are locking in every request this can cause performance issues
// so we will lock only at first request

/*
Double-checked locking reduces the performance overhead by only synchronizing during the first object creation. After the instance exists, threads skip the lock entirely.
 */

public class DoubleCheckedSingleton {
    // Holds the single shared instance (requires safe publication)
    // volatile prevents reordering of instructions in: instance = new Singleton()
    // since it involves three steps: allocate memory, call constructor, assign reference
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton(){

    }

    public static DoubleCheckedSingleton getInstance(){
        // Fast path: first check without locking
        if (instance == null){
            // Lock only when the instance might need to be created
            synchronized (DoubleCheckedSingleton.class) {
                // Second check inside the lock (prevents double creation)
                if (instance == null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
