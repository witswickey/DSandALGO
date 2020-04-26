package string;

import java.util.Arrays;

//JAVA program for implementation of KMP pattern 
//searching algorithm 

public class KMP { 
	void KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 
		int lps[] = new int[M]; 
		computeLPSArray(pat, M, lps);
		System.out.println(Arrays.toString(lps));
		int j=0;
		for(int i=0;i<N;) {
			if(txt.charAt(i)==pat.charAt(j)) {
				i++;
				j++;
			}
			if(j==M && j>0) {
				System.out.println("Found at "+(i-j));
				//lps[j]=lps[j-1];
			}
			else  if (i < N && pat.charAt(j) != txt.charAt(i)) { 
				if(j!=0) {
					j=lps[j-1];
				}
				else {
					i=i+1;
				}
			}
		}
		
	} 

	void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		int j=0;
		int i=1;
		for(;i<M;) {
			
			if(pat.charAt(i)==pat.charAt(j)) {
				
				lps[i]=j+1;
				i++;
				j++;
				
			}
			else {
				if(j!=0) {
					j=lps[j-1];
				}
				else {
					lps[i]=j;
					i+=1;
				}
				
			}
			
		}
	} 

	// Driver program to test above function 
	public static void main(String args[]) 
	{ 
        String txt = "ABABDABACDABABCABAB"; 
        String pat = "ABABCABAB"; 
		new KMP().KMPSearch(pat, txt); 
	} 
} 
//This code has been contributed by Amit Khandelwal. 

