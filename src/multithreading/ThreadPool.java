package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool implements Runnable {

	public int id;


	public ThreadPool(int i) {
		this.id=i;
	}
	public void run() {

		System.out.println("Id is " + id);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Id is " + id);

	}

	public static void main(String[] args) {

		ExecutorService exec=Executors.newFixedThreadPool(3);
		
		for(int i=0;i<2;i++) {
			exec.submit(new ThreadPool(i));
		}
		exec.shutdown();
		
		try {
			exec.awaitTermination(10, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
