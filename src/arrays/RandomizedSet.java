package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    /** Initialize your data structure here. */
	 ArrayList<Integer> arr;
	 HashMap<Integer, Integer> map;
    public RandomizedSet() {
        arr=new ArrayList<Integer>();
        map=new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the           specified element. */
    public boolean insert(int val) {
        
        if(map.get(val)!=null){
            return false;
        }
        arr.add(val);
        int size=arr.size();
        
        map.put(val,size-1); 
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified             element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
        	return false;
        }
        int index=(int) map.get(val);
        
        int last=(int) arr.get(arr.size()-1);
        arr.set(index,last);
        map.put(last,index);
        arr.remove(arr.size()-1);         
        map.remove(val);
        return true;        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand=new Random();
    	int random=rand.nextInt(arr.size());
    	return (int) arr.get(random);
    }
    public static void main(String[] args) {
		RandomizedSet s=new RandomizedSet();
		System.out.println(s.remove(0));
		System.out.println(s.remove(0));
		System.out.println(s.insert(0));
		System.out.println(s.getRandom());
		System.out.println(s.remove(0));
		
		System.out.println(s.insert(0));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */