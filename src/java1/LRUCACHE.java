package java1;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class LRUCACHE {

	public static Deque<Integer> pg;
	public static HashSet<Integer> map;
	static int Max_size;

	LRUCACHE(int max) {
		this.pg = new LinkedList<Integer>();
		this.map = new HashSet<Integer>();
		Max_size = max;
	}

	public static void refer(int page) {
		
		if(!map.contains(page)) {
			if(pg.size()==Max_size) {
				int pgh=pg.removeLast();
				map.remove(pgh);
			}
		}
		else {
			int index=0,i=0;
			Iterator<Integer> itr = pg.iterator(); 
	        while (itr.hasNext()) { 
	            if(itr.next()==page) {
	            	index=i;
	            }
	            i++;
	        }
	        pg.remove(i);
		
		}
        pg.push(page);
        map.add(page);
	}
    // display contents of cache 
    public void display() 
    { 
        Iterator<Integer> itr = pg.iterator(); 
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
    } 
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		LRUCACHE ca = new LRUCACHE(4);
		ca.refer(1); 
        ca.refer(2); 
        ca.refer(3); 
        ca.refer(1); 
        ca.refer(4); 
        ca.refer(5); 
        ca.display(); 

	}

}
