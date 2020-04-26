package multi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerByBlockingQueue {

	public static void main(String[] args) {
		LinkedBlockingQueue<Integer> que=new LinkedBlockingQueue<Integer>();
		
		new producer(que).start();
		new consumer(que).start();

	}

}
class producer extends Thread{
	LinkedBlockingQueue<Integer> sharedqueue;
	
	producer(LinkedBlockingQueue<Integer> que){
		super("Producer");
		this.sharedqueue=que;
		
	}
	
 public void run() {
	 for (int i=0;i<5;i++) {
		 System.out.println("Thread "+Thread.currentThread().getName()+" is producing ele->"+i);
		 try {
			sharedqueue.put(i);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
}
class consumer extends Thread{
	LinkedBlockingQueue<Integer> sharedqueue;
	
	consumer(LinkedBlockingQueue<Integer> que){
		super("consumer");
		this.sharedqueue=que;
		
	}
	
 public void run() {
	 while(true){
		 int i=0;
		try {
			i = sharedqueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread "+Thread.currentThread().getName()+" is Consuming ele->"+i);
	 }
 }
}
