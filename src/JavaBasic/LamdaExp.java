package JavaBasic;


public class LamdaExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable r=()->	System.out.println("Lambda blast");
		
		Thread t=new Thread(r);
		
		t.start();
		

	}

}
