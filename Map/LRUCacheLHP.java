import java.util.LinkedHashMap;
import java.util.Map;
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; 
    }
}
public class LRUCacheLHP {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache after adding 1,2,3: " + cache);
        cache.get(1); 
        cache.put(4, "D"); 
        System.out.println("Cache after accessing 1 and adding 4: " + cache);
        cache.put(5, "E"); 
        System.out.println("Cache after adding 5: " + cache);
    }
}
