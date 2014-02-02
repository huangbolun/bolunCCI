package leetcode;

import java.util.HashMap;
/**
 * Double linkedlist<Node> + HashMap<Integer, Node> [the address of each node]
 * @author Bolun
 *
 */
class DoublyListNode {
    
    public int key;
    public int val;
    public DoublyListNode next = null;
    public DoublyListNode pre = null;
    
    public DoublyListNode(int _key, int _val) {
        val = _val;
        key = _key;
    }
}

public class LRUCache {
    
	public int capacity = 10; // default
    public int count = 0; // count of entry in the cache
    public DoublyListNode cache; // the head of cache
    public DoublyListNode tail; // the tail of cache
    public HashMap<Integer, DoublyListNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = null;
        map = new HashMap<Integer, DoublyListNode>();
    }
    
    // get the value and then move it to the head
    public int get(int key) {
        if (!map.containsKey(key)) return -1; // not found!
        else {
            // remove the node
            DoublyListNode tmp = map.get(key);
            DoublyListNode next = tmp.next;
            DoublyListNode pre = tmp.pre;
            
            if (pre == null) { // ***already head, don't move***
            	return tmp.val;
            } else {
            	if (tmp.next == null) { // we happened to get the tail!!!
                	this.tail = pre; // tail points to the previous node
                }
            	pre.next = next;
                if (next != null) next.pre = pre;
                // add the node to head;
                moveToHead(tmp);
                return tmp.val; // return the value
            }
        }
    }
    
    public void moveToHead(DoublyListNode node) {
        DoublyListNode tmp = this.cache;
        node.next = tmp;
        if (tmp != null) tmp.pre = node;
        this.cache =node; // update the cache head
        //System.out.println("head: ("+this.cache.key+","+this.cache.val+")");
        
    }
    
    // find the node and set the value; if not found, add it to the head
    // don't forget the capacity
    // set tail to be the node at the first set
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            // add to the head
            DoublyListNode newNode = new DoublyListNode(key, value);
            moveToHead(newNode);
            map.put(newNode.key, newNode); // add to hashMap
            count += 1;
            if (count == 1) {
            	this.tail = newNode; // newNode is also tail!!!
            }
            if (count > capacity) {
            	// remove tail
                removeTail();
                count -= 1;
            }
        } else {
            // change the value
            DoublyListNode node = map.get(key);
            node.val = value;
            // move to head after set
         // remove the node
            DoublyListNode tmp = map.get(key);
            DoublyListNode next = tmp.next;
            DoublyListNode pre = tmp.pre;
            
            if (pre == null) { // ***already head, don't move***
            	return;
            } else {
            	if (tmp.next == null) { // we happened to get the tail!!!
                	this.tail = pre; // tail points to the previous node
                }
            	pre.next = next;
                if (next != null) next.pre = pre;
                // add the node to head;
                moveToHead(tmp);
                return; // return the value
            }
        }
    }
    
    public void removeTail() {
    	/*
        DoublyListNode p = cache;
        while (p.next != null) {
            p = p.next;
        }
        // remove p
        DoublyListNode pre = p.pre;
        if (pre == null) cache = null; // cache is empty
        else pre.next = null; // pre points to the end
        */
    	DoublyListNode tmp = this.tail;
    	this.tail = tmp.pre;
    	this.tail.next = null; // set next to **null**
    	this.map.remove(tmp.key);
    	//this.count -= 1;
    }
    
    public void printCache() {
    	DoublyListNode p = cache;
    	while (p != null) {
    		System.out.print("("+p.key+","+p.val+")");
    		p = p.next;
    	}
    	System.out.print(" map size: "+map.size());
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	LRUCache mycache = new LRUCache(3);
    	mycache.set(2, 1);
    	mycache.printCache();
    	mycache.set(1, 1);
    	mycache.printCache();
    	mycache.set(2, 3);
    	mycache.printCache();
    	mycache.set(4, 1);
    	mycache.printCache();
    	mycache.set(5, 7);
    	mycache.printCache();
    	mycache.set(6, 6);
    	mycache.printCache();
    	
    	System.out.println(mycache.get(1));
    	mycache.printCache();
    	System.out.println(mycache.get(4));
    	mycache.printCache();
    	System.out.println(mycache.get(5));
    	mycache.printCache();
    }
}


/**
 * @deprecated
 * @author Bolun
 *
 */
/*
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
}*/