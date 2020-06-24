package multithreading;


class CoffeeMachine implements Runnable{
	public static String coffee=null;
	public  final static Object lock=new Object();
	public static int coffenumber=1;
	
	public void makecoffee() {
		
		synchronized (CoffeeMachine.lock) {
			
		if (CoffeeMachine.coffee!=null) {
			
			System.out.println("Waiting for waiter to take a coffee");
			try {
				CoffeeMachine.lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			CoffeeMachine.coffee= "Coffee ready no is "+CoffeeMachine.coffenumber++;
			System.out.println(CoffeeMachine.coffee);
			
			CoffeeMachine.lock.notifyAll();
		
		}
	}
	public void run() {
		while(true) {
			makecoffee();
			try {
				System.out.println("Coffee machine: Making another coffee now");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class Waiter implements Runnable{
	
	public void getcoffee() {
		synchronized (CoffeeMachine.lock) {
			if(CoffeeMachine.coffee==null) {
				System.out.println("waiting for cofee machine to make coffee");
				
				try {
					CoffeeMachine.lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print("Delievring cofeee from machine ,it says->");
				System.out.println(CoffeeMachine.coffee);
				
				CoffeeMachine.coffee=null;
				
				CoffeeMachine.lock.notifyAll();
				
		}
	}

	@Override
	public void run() {
		while(true) {
			getcoffee();
		}

		
	}
}

public class ProducerConsumer {

	public static void main(String[] args) {
	CoffeeMachine cof=new CoffeeMachine();
	Waiter wo=new Waiter();
	
	Thread t1=new Thread(cof);
	Thread t2=new Thread(wo);
	
	t1.start();
	t2.start();
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
