package Creational.Singleton;

/*
* 1. Lazy Initialization (Not Thread-Safe)
This approach creates the singleton instance only when it is needed, saving resources if the singleton is never used in the application
*  */

public class LazySingleton {
    // single shared instance
    private static LazySingleton instance;

    // we will have private constructor
    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
