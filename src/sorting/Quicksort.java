package sorting;

import java.util.Arrays;

public class Quicksort {

	public Quicksort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		

		int arr[]= {8,5,4,1,2,3,6};
		System.out.println(Arrays.toString(arr));
		quicksort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void quicksort(int[] arr, int start, int end) {
	    if (start < end) {
	       int index = partition(arr, start, end);
	        quicksort(arr, start, index - 1);
	        quicksort(arr, index + 1, end);
	    }

		
	}

	private static int partition(int[] arr, int start, int end) {
	    int pivotele=arr[end];
	    int i=start-1;
	    for (int j = start; j <=end- 1; j++) {
	        if(arr[j]<pivotele) {
	            i+=1;
	            swap(arr,i,j);
	        	}
	    }
	    i+=1;
	    swap(arr,i,end);
		return i;
	}
	    

	private static void swap(int[] arr, int i, int j) {
				int temp=arr[j];
	    	    arr[j]=arr[i];
	    	    arr[i]=temp;
		
	}

}
