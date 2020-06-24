package multithreading;
import java.util.concurrent.*; 

public class Semaphore1 {

	public static void main(String[] args) {
		Semaphore sem=new Semaphore(1);
		ActionOnCount1 ac=new ActionOnCount1(sem, "A");
		ActionOnCount1 bc=new ActionOnCount1(sem,"B");
		ac.start();
		bc.start();
		try {
			ac.join();
			bc.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
	class SharedResource{
		
		public static int count=0;
		public static int limit=5;
	}
	
	class ActionOnCount1 extends Thread{
		Semaphore sem;
		public ActionOnCount1(Semaphore sem,String name) {
			super(name);
			this.sem=sem;
			// TODO Auto-generated constructor stub
		}
		
		public void run() {
			System.out.println("We are going to access count variable by Thread"+Thread.currentThread().getName());
			while(SharedResource.count<5) {
			try {
				sem.acquire();
				SharedResource.count++;
				System.out.println("Count "+SharedResource.count+" "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				sem.release();
			}
			}
			
			
		}
		
	}

