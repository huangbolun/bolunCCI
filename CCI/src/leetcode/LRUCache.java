package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
/**
 * Double linkedlist<Node> + HashMap<Integer, Node> [the address of each node]
 * @author Bolun
 *
 */
public class LRUCache {

    public static class Entry {
        public int key = 0;
        public int value = 0;
        
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public LinkedList<Entry> cache;
    public HashSet<Integer> cacheset;
    public int capacity = 0;
    
    public LRUCache(int capacity) {
        cache = new LinkedList<Entry>();
        cacheset = new HashSet<Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cacheset.contains(key)) return -1;
        int i = 0;
        Entry rmv = null;
        for (i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
            	rmv = cache.remove(i);
            	break;
            }
        }
        cache.add(rmv);
        return cache.get(i).value;
    }
    
    public void set(int key, int value) {
        if (!cacheset.contains(key)) {
            cacheset.add(key);
            cache.add(new Entry(key, value));
        } else {
            for (int i = 0; i < cache.size(); i++) {
                if (cache.get(i).key == key) {
                    cache.remove(i);
                    break;
                }
            }
            cache.add(new Entry(key, value));
        }
        if (cache.size() > capacity) {
            Entry lru = cache.peek();
            cacheset.remove(lru.key);
            cache.poll();
        }
        return;
    }
}