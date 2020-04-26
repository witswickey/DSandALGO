package snippet;

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     public  static void reverse(int arr[],int start,int end){
         
        while(start<=end) {
        	 int temp=arr[start];
             arr[start]=arr[end];
             arr[end]=temp;
             start+=1;
             end-=1;
        }
     }
     
     public static void rotate(int[] arr,int n,int d){
        
        reverse(arr,0,d-1);
        //printArray(arr);
        reverse(arr,d,n-1);
        //printArray(arr);
        reverse(arr,0,n-1);
         
     }
	public static void main (String[] args)
	 {
        Scanner sc=new Scanner(System.in);
	    int T=sc.nextInt();
		for (int i=0;i<T;i++){
		    int N=sc.nextInt();
		    int[] arr=new int[N];
		    int d=sc.nextInt();
		    for (int j=0;j<N;j++){
		        arr[j]=sc.nextInt();
		    }
		    rotate(arr,arr.length,d);
		    printArray(arr);
		    
		}
	 }
	public static void printArray(int arr[]) 
	    { 
	        for (int i = 0; i < arr.length; i++) 
	            System.out.print(arr[i] + " "); 
	        System.out.println();
	    } 
	//System.out.println();
}