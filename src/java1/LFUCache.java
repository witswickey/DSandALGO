package java1;

import java.util.*;

public class LFUCache {
    
    public static HashMap<Integer,Integer> vals;
    public static HashMap<Integer,Integer> counters;
    public static HashMap<Integer,LinkedHashSet<Integer>> tracker;
    public static int capacity;
    static int min=-1;

    public LFUCache(int capacity) {
        vals=new HashMap<Integer, Integer>();
        counters=new HashMap<Integer, Integer>();
        tracker=new HashMap<Integer, LinkedHashSet<Integer>>();
        LFUCache.capacity=capacity;
    }
    
    public static int get(int key) {
		
    	if (vals.isEmpty() || vals.get(key)==null) {
    		return -1;
    	}
    	int count=counters.get(key);
    	counters.put(key, count+1);
    	if(count==min || tracker.get(min).size()==0) {
    		min++;
    	}
    	if(!tracker.containsKey(count+1)) {
    		tracker.put(count+1, new LinkedHashSet<Integer>());
    	}
    	tracker.get(count+1).add(key);
    	return vals.get(key);
    
        
    }
    
    public void set(int key, int value) {
        if (capacity <= 0)
            return;
        // If key does exist, we are returning from here
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int evit = tracker.get(min).iterator().next();
            tracker.get(min).remove(evit);
            vals.remove(evit);
            counters.remove(evit);       
 }
        // If the key is new, insert the value and current min should be 1 of course
        vals.put(key, value);
        counters.put(key, 1);
        min = 1;
        tracker.get(1).add(key);
    }
   public static void main(String[] args) {
	   
	   int capacity=3;
	   int key=2;
	   int value=2;
	   LFUCache obj = new LFUCache(capacity);
	   int param_1 = obj.get(key);
	   obj.set(key,value);
}
}