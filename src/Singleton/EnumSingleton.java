package Singleton;

/*The JVM provides four guarantees that no other approach offers:

Thread-safe initialization: Enum constants are initialized exactly once when the enum class is loaded, and class loading is thread-safe.
Serialization safety: Serializing and deserializing an enum returns the same instance.
Reflection safety: The JVM prevents creating enum instances via reflection. Constructor.newInstance() throws an IllegalArgumentException.
Single instance guarantee: Enforced at the JVM level, not by your code.
The only limitation is that enums cannot extend other classes (they implicitly extend java.lang.Enum), so if your Singleton needs a base class, you cannot use this approach.
 */

enum EnumSingleton{
    INSTANCE;

    public void doSomething(){
        // Add any singleton logic here
    }
}