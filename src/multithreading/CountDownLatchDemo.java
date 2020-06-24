package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

abstract class Teams {
	String teamName;
	int n=10;
	CountDownLatch latch;
	public abstract void dowork();
}

class Devteam extends Teams implements Runnable {

	Devteam(CountDownLatch latch){
		this.latch=latch;
	}
	public void dowork() {

		int i = 0;
		while (i++ < n) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Print Dev" + i);
		}

	}

	@Override
	public void run() {
		dowork();
		latch.countDown();

	}

}
class Testingteam extends Teams implements Runnable {

	Testingteam(CountDownLatch latch){
		this.latch=latch;
	}
	public void dowork() {

		int i = 0;
		while (i++ < n) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Print Testing " + i);
		}

	}

	@Override
	public void run() {
		dowork();
		latch.countDown();

	}

}
class QATteam extends Teams implements Runnable {

	QATteam(CountDownLatch latch){
		this.latch=latch;
	}
	public void dowork() {

		int i = 0;
		while (i++ < n) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Print QAT " + i);
		}

	}

	@Override
	public void run() {
		dowork();
		latch.countDown();

	}

}

public class CountDownLatchDemo {
	
	public static void main(String[] args) {
		CountDownLatch la=new CountDownLatch(2);
		Devteam d=new Devteam(la);
		QATteam q=new QATteam(la);
		Testingteam t=new Testingteam(la);
		
		new Thread(d).start();
		new Thread(t).start();
		
		
		try {
			la.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(q).start();
	}
	
	
	
}
