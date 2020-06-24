package multithreading;
public class EvenOdd {
	private static Object lock = new Object();

	public static void main(String a[]) {
		EvenOdd odd = new EvenOdd();
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 2; i <= 100; i++) {
					if (i % 2 == 0) {
						System.out.println("Thread printing even "+ i + "\n");
						synchronized (lock) {
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
		};

		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					if (i % 2 != 0) {
						System.out.println("Thread printing odd "+ i + "\n");
						synchronized (lock) {
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
		};
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);

		System.out.println("Thread Start: ");
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
