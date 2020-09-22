package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestSubsequence {
	
	// driver program to test above functions 
    public static void main(String args[]) 
    { 
        //int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int arr[]= {4,5,6,3};
        int n = arr.length; 
        System.out.println("Length of lis is "
                           + lis(arr,n) + "\n"); 
        System.out.println(LISUSINGPATEINCESORTING(arr));
    }

	private static int lis(int[] arr,int n) {
		
		
		int t[]=new int[arr.length];
		t[0]=1;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				
				if(arr[i]>arr[j]) {
					if(t[j]+1>t[i]) {
						t[i]=t[j]+1;
					}
				}
			}
		}
		return t[t.length-1];
		
		
	}
	
	//o(nlogn) using patience sorting piles of card printcton lesson
	
	public static int LISUSINGPATEINCESORTING(int[] nums) {
		
		List<Integer> piles=new ArrayList<Integer>(nums.length);
		List<Integer> lis=new LinkedList<Integer>();
		int max=Arrays.stream(nums).max().getAsInt();
		for(int num:nums) {
			int index=Collections.binarySearch(piles,num);
			if(index<0) {
				index=~index;
			}
			if (index==piles.size()) {
				piles.add(num);
				lis.add(num);
			}
			else
			{
				piles.set(index, num);
			}
		}
		System.out.println(lis);
		return piles.size();
		
	}
    
}
