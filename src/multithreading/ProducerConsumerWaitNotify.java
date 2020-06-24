package multithreading;

public class ProducerConsumerWaitNotify {

	public static final Object lock=new Object();
	public static Integer count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new producer1(lock,count).start();
		new consumer1(lock,count).start();
	}
}
	class producer1 extends Thread{
		public final Object lock;
		public static Integer count=0;
		producer1(Object lock,Integer count){
			super("Producer");
			this.lock=lock;
			this.count=count;
			
		}
		
	 public void run() {
		 synchronized (lock) {
			 while(count<=5) {
				System.out.println("Producing output->"+count++); 
				try {
					lock.notifyAll();
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
			
		}
	 }
	class consumer1 extends Thread{
		//LinkedBlocking	Queue<Integer> sharedqueue;
		public final Object lock;
		public static Integer count=0;
		consumer1(Object lock,Integer count){
			super("Consumer");
			this.lock=lock;
			this.count=count;
			
		}
		
	 public void run() {
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 synchronized (lock) {
			 
			 while(true) {
				 System.out.println("Consuming item ->"+count--);
				 lock.notifyAll();
				 try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			
		}
	 }
	}	

