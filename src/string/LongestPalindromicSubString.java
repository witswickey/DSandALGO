package string;

import dp.PrintMatrix;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String str = "aacabdkacaa";

		System.out.println("The input string is " + str);
		int len = lengthOfLongestPalindromicSubstring(str);
		System.out.println("The length of " + "the longest palindromic string is " + len);

	}

	private static int lengthOfLongestPalindromicSubstring(String s) {
		char[] str = s.toCharArray();
		int T[][] = new int[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			T[i][i] = 1;
		}
		for (int l = 2; l <= str.length; l++) {
			for (int i = 0; i < str.length - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && str[i] == str[j]) {
					T[i][j] = 2;
				} else if (str[i] == str[j]) {
					T[i][j] = T[i + 1][j - 1] + 2;
				} else {
					T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
				}
			}
		}
		PrintMatrix.printMatrix(T);
		System.out.println();

		// PrintMatrix.printMatrix(n);
		int ln = T[0][str.length - 1];
		int l = str.length;
		for (int i = 0; i <= l - ln; i++) {
			int p = i + ln;
			String sub = s.substring(i, p);
			if (ispalindromic(sub)) {
				System.out.println(sub);
				// break;
			}
		}
		return ln;
	}

	public static boolean ispalindromic(String s) {
		StringBuilder str = new StringBuilder(s);
		String rev = str.reverse().toString();

		return s.equals(rev);
	}
}