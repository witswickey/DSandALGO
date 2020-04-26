package string;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {

		int T = 0;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		sc.nextLine();
		String result ;
		for (int i = 0; i < T; i++) {

			String str = sc.nextLine();
			
			String[] jam=str.split("\\.");

			reverse(jam, 0, jam.length-1);
			for(String s:jam) {
				System.out.println(s);
			}

		}

	}

	private static void reverse(String[] str, int low,int high) {
		
		if(low<high) {
			String temp=str[low];
			str[low]=str[high];
			str[high]=temp;
			reverse(str,low+1,high-1);
		}

	}
}