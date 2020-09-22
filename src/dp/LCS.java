package dp;

import java.util.ArrayList;
import java.util.List;

public class LCS {

	List<Character> l=new ArrayList<>();
	public static void main(String[] args) 
	  { 
		LCS lcs = new LCS(); 
	    String s1 = "ABCDGH"; 
	    String s2 = "AEDFHR"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	    
	    	System.out.println("Length of LCS is" + " " + 
                    lcs.lcs( X, Y, m, n,0 ) ); 
	  }

	private int lcs(char[] x, char[] y, int m, int n,int len) {
		
		if(m<=0 || n<=0) {
			return len;
		}
		else if(x[m-1]==y[n-1]) {
			
			len=lcs(x,y,m-1,n-1,len+1);
		}
		else {
			int l1=lcs(x,y,m,n-1,len);
			int l2=lcs(x,y,m-1,n,len);
			return Math.max(l1,l2);
		}
		return len;
		
	} 

}
