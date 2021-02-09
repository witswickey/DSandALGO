package string;

import java.util.Arrays;
import java.util.Collections;

public class IsDistinct {

	public static void main(String[] args) {
		
		String str="geeksforgeeks";
		
		System.out.println(isDistinct(str));

	}

	private static boolean isDistinct(String str) {
		
		char[] arr=str.toCharArray();
		Arrays.sort(arr);
		System.out.println(arr);
		return false;
		
		
	}

}
