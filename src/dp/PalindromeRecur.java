package dp;

public class PalindromeRecur {

	public static void main(String[] args) {
		

		//String str="aaaabaaaa";
		//String str=abababa;
		//String str="ababab";
		String str = "dabad"; 

		System.out.println(isPalindrome(str,0,str.length()-1));
	}

	private static boolean isPalindrome(String str,int i,int j) {
		
		if(i>=j)
			return true;
		else
	       return (isPalindrome(str,i+1,j-1) && str.charAt(i)==str.charAt(j));
			
		
	}

}
