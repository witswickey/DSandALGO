package multithreading;

public class Time_bomb extends Thread {

	@Override
	public void run(){
		
		for(int i=9;i>=0;i--){
			System.out.println(i+"\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String ar[]) throws InterruptedException {
		
		Time_bomb t=new Time_bomb();
		
		t.start();
		
		t.join();
		
		System.out.print("done");

	}
	
}
