package Creational.Singleton;

/*
2. Thread-Safe Creational.Singleton
This approach extends lazy initialization by ensuring the Creational.Singleton is safe to use in multi-threaded environments.

When multiple threads try to access the instance at the same time, synchronization (or locking) ensures that only one thread can create the object, while others wait.
 */

public class LazySingletonThreadSafe {
    private static LazySingletonThreadSafe instance;

    private LazySingletonThreadSafe() {
    }

    public static synchronized LazySingletonThreadSafe getInstance(){
        if (instance == null){
            instance = new LazySingletonThreadSafe();
        }
        return instance;
    }
}
