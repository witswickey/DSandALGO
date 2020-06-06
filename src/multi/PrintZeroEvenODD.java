package multi;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenODD {
	private static int n=5;
	static Semaphore sm = new Semaphore(1);
	static Semaphore pm = new Semaphore(0);
	static Semaphore dm = new Semaphore(0);
	volatile static int evencount = 2;
	volatile static int oddcount = 1;
	volatile static int zerocount = 1;
	volatile static boolean flag = false;

	public PrintZeroEvenODD(int n) {
		this.n = n;
	}

	static class Zero implements Runnable {
		public void zero() throws InterruptedException {

			while (zerocount <= n) {

				sm.acquire();

				System.out.println("0");
				zerocount += 1;

				if (flag) {
					pm.release();
				} else {
					dm.release();
				}
			}

		}

		@Override
		public void run() {
			try {
				zero();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	static class Even implements Runnable {

		public void even() throws InterruptedException {

			while (evencount <= n) {
				pm.acquire();
				System.out.println(evencount);
				evencount += 2;
				flag = false;
				sm.release();
			}

		}

		@Override
		public void run() {
			try {
				even();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	static class Odd implements Runnable {

		public void odd() throws InterruptedException {

			while (oddcount <= n) {
				dm.acquire();
				System.out.println(oddcount);
				oddcount += 2;
				flag = true;
				sm.release();
			}

		}

		@Override
		public void run() {
			try {
				odd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		Runnable zt = new Zero();
		Runnable et = new Even();
		Runnable ot = new Odd();

		Thread z = new Thread(zt);
		Thread e = new Thread(et);
		Thread o = new Thread(ot);
		z.start();
		e.start();
		o.start();
		try {
			z.join();
			e.join();
			o.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}