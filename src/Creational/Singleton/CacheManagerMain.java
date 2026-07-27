package Creational.Singleton;

/*
Lets say you are building an application where multiple components (HTTP handlers, database layer, background jobs) all need to cache expensive data like user profiles, configuration, and query results.

You want one shared cache so that any component's writes are immediately visible to all others, without duplicate maps, stale reads, or wasted memory.

CacheManager cacheA = new CacheManager();
cacheA.put("user:42", userData);

CacheManager cacheB = new CacheManager();
cacheB.get("user:42"); // null! Different instance, different map

// Problems:
// - Duplicate HashMaps wasting memory
// - Writes in one component invisible to others
// - TTL cleanup duplicated across instances

 */

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

enum CacheManager{
    INSTANCE;

    private record CacheEntry(String value, Instant expiry){
        boolean isExpired(){
            return expiry != null && Instant.now().isAfter(expiry);
        }
    }

    private final ConcurrentHashMap<String, CacheEntry> cache = new ConcurrentHashMap<>();

    public void put(String key, String value, long ttlSeconds){
        Instant expiry = ttlSeconds > 0 ? Instant.now().plusSeconds(ttlSeconds) : null;
        cache.put(key, new CacheEntry(value, expiry));
    }

    public void put(String key, String value) {
        put(key, value, 0);
    }

    public String get(String key){
        CacheEntry entry = cache.get(key);
        if (entry == null) return null;

        if (entry.isExpired()){
            cache.remove(key);
            return null;
        }
        return entry.value();
    }

    public int size(){
        cache.entrySet().removeIf(e -> e.getValue().isExpired());
        return cache.size();
    }
}

public class CacheManagerMain {
    public static void main(String[] args) {
        // Both references point to the same CacheManager instance
        CacheManager cache1 = CacheManager.INSTANCE;
        CacheManager cache2 = CacheManager.INSTANCE;

        System.out.println("Same instance? " + (cache1 == cache2)); // true

        // Component A caches data
        cache1.put("user:42", "{name: 'Alice'}", 5); // 5-second TTL
        cache1.put("config:theme", "dark");           // no expiry

        // Component B reads from the same cache
        System.out.println("user:42 = " + cache2.get("user:42"));       // {name: 'Alice'}
        System.out.println("config:theme = " + cache2.get("config:theme")); // dark
        System.out.println("Cache size: " + cache2.size());              // 2
    }
}

/*
Same instance? true
user:42 = {name: 'Alice'}
config:theme = dark
Cache size: 2
 */

/*
Pros
Ensures a single instance of a class and provides a global point of access to it.
Only one object is created, which can be particularly beneficial for resource-heavy classes.
Provides a way to maintain global state within an application.
Supports lazy loading, where the instance is only created when it's first needed.
Guarantees that every object in the application uses the same global resource.

Cons
Violates the Single Responsibility Principle: The pattern solves two problems at the same time.
In multithreaded environments, special care must be taken to implement Singletons correctly to avoid race conditions.
Introduces global state into an application, which might be difficult to manage.
Classes using the singleton can become tightly coupled to the singleton class.
Creational.Singleton patterns can make unit testing difficult due to the global state it introduces.
 */
