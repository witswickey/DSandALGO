package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedQueueDesign {

	Queue<Integer> q;
	int capacity;
	
	public BoundedQueueDesign(int c) {
		// TODO Auto-generated constructor stub
		this.q=new LinkedList<Integer>();
		this.capacity=c;
	}
	public synchronized void enqueue(int data) throws InterruptedException {
		
		while(this.q.size()==this.capacity) {
			wait();
		}
		this.q.add(data);
		if(this.q.size()==1) {
			notifyAll();
		}
		
	}
	public synchronized void dequeue() throws InterruptedException {
		while(this.q.size()==0) {
			wait();
		}
		if(this.q.size()==this.capacity) {
			notifyAll();
		}
		this.q.remove(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
