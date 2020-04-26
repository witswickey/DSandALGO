package arrays;

import java.util.Scanner;

import javax.sound.sampled.ReverbType;

public class RotateArrayByd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int i=0;i<T;i++){
		    
		    int N=sc.nextInt();
		    
		    int[] arr=new int[N];
		    
		    for (int j=0;j<N;j++){
		        arr[j]=sc.nextInt();
		    }
		    int d=sc.nextInt();
		    //printArray(arr);
		    //System.out.print("After roatation");
		    rotatebyd(arr,N,d);
		    printArray(arr);
		    System.out.println();
		}
	

	}
	 static void printArray(int arr[]) 
	    { 
	        for (int i = 0; i < arr.length; i++) 
	            System.out.print(arr[i] + " "); 
	    } 
	  
	private static void rotatebyd(int[] arr, int n,int d) {

		reverse(arr,0,d-1);
		reverse(arr, d,n-1);
		reverse(arr, 0, n-1);
	
		
	}

	public static void reverse(int[] arr ,int start,int end){
		

		while(start<end){
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		
	}
}
