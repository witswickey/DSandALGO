package arrays;

import java.util.Scanner;

public class ReverseRecur {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        //remeber to skip one new line
		sc.nextLine();
		for (int i = 0; i < T; i++) {

			String s = sc.nextLine();
			printString(s);
			s=new ReverseRecur().reverserecur(s,0,s.length()-1);
			printString(s);
		}

		System.out.println();
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	static void printString(String s) {
		System.out.print(s + " ");
	}

	 String reverserecur(String s,int start,int end) {

		if(start>=end)
			return s;
		else{
			char[] s1=s.toCharArray();
			char temp=s1[start];
			s1[start]=s1[end];
			s1[end]=temp;
			s=String.valueOf(s1);
			printString(s);
			return reverserecur(s, start+1, end-1);
		}
		
		
	}

}
