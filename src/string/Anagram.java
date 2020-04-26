package string;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main (String[] args)
	 {
       Scanner sc=new Scanner(System.in);
	    int T=sc.nextInt();
		 sc.nextLine();
		
		for (int i=0;i<T;i++){
			

		  
		 String t=sc.nextLine();
		  
		 System.out.println(String.valueOf(checkAnageam(t.split(" "))).toUpperCase());
		}
		  
	}

	private static boolean checkAnageam(String[] split) {
		
		String first=split[0];
		String second=split[1];
		
		//System.out.println(first+" "+second);
		
		char [] fi=first.toCharArray();
		char[] se=second.toCharArray();
		
		Arrays.sort(fi);
		Arrays.sort(se);
		
		//System.out.println("hi"+fi+" "+se);
		
		first=String.valueOf(fi);
		second=String.valueOf(se);
		//System.out.println(first+second);
		
		return first.equalsIgnoreCase(second);
		
	}	
	}
