import java.util.*;
class TTLCache<K, V> {
    private class CacheEntry {
        V value;
        long expiryTime; 
        CacheEntry(V value, long ttlMillis) {
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + ttlMillis;
        }
        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }
    private final Map<K, CacheEntry> map = new HashMap<>();
    public void put(K key, V value, long ttlMillis) {
        map.put(key, new CacheEntry(value, ttlMillis));
    }
    public V get(K key) {
        CacheEntry entry = map.get(key);
        if (entry == null) return null;
        if (entry.isExpired()) {
            map.remove(key); 
            return null;
        }
        return entry.value;
    }
    public int size() {
        map.entrySet().removeIf(e -> e.getValue().isExpired());
        return map.size();
    }
}
public class TTLCaches {
    public static void main(String[] args) throws InterruptedException {
        TTLCache<String, String> cache = new TTLCache<>();
        cache.put("a", "Apple", 2000);
        cache.put("b", "Banana", 4000); 
        System.out.println("Initial get a: " + cache.get("a")); 
        Thread.sleep(2500);
        System.out.println("After 2.5s get a: " + cache.get("a")); 
        System.out.println("Get b: " + cache.get("b")); 
        System.out.println("Cache size: " + cache.size()); 
    }
}
