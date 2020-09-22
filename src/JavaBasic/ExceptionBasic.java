package JavaBasic;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

interface base{
	
	 void readInt() throws NoSuchElementException;
}
public class ExceptionBasic implements base {

	public static void main(String[] args) {
		new ExceptionBasic().readInt();
		new ExceptionBasic().readmsg();
		int t = 0;
		System.out.println(t);
	}

	@Override
	public void readInt() throws InputMismatchException {// can not throw more geenral excepton than base
		
		Scanner sc=new Scanner(System.in);
		
		int i=sc.nextInt();
		
		System.out.println(i);		
		
	}
	
	public void readmsg() {
		
		try (Scanner sc=new Scanner(System.in)){
			@SuppressWarnings("unused")
			String msg=sc.nextLine();
			throw new CustomException(msg);
		}
	}

}
