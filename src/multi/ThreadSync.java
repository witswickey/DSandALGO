package multi;

import java.util.Scanner;

// this class explain use of volatile and caching probelm with stat

class processor implements Runnable {

	private volatile boolean stat = true;
	private int count = 0;// problem can not be solved by volatile

	public void increment() {// solves probelm
		count++;
	}

	@Override
	public void run() {
		shutdown();

	}

	public synchronized void shutdown() {
	//	stat = false;
		while (stat && count < 100) {
			// System.out.println("Hi Wits" + Thread.currentThread().getName());
			// count++;
			increment();
			System.out.println("Count is " + count);
		}
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class ThreadSync {

	public static void main(String[] args) {

		processor p = new processor();
		Thread t = new Thread(p);
		t.start();
		Thread t2 = new Thread(p);
		t2.start();
		/*
		 * System.out.println("Hit return"); Scanner in = new Scanner(System.in);
		 * in.nextLine(); p.shutdown();
		 */

	}

}
