package sorting;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);

	}

	private void sort(int[] arr) {
		
		int n=arr.length;
		
		// build heap ->heapify ->extract->heapify
		
		for(int i=(n/2-1);i>=0;i--) {
			heapify(arr, n,i);
		}
		printArray(arr);
		for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
	}
	
	private void heapify(int [] arr, int n,int i) {
		
		int big=i;
		int l=2*i+1;
		int r=2*i+2;
		
		if (l<n && arr[l]>arr[big]) {
			big=l;
		}
		if (r<n && arr[r]>arr[big]) {
			big=r;
		}
		
		if(big!=i) {
			swap(arr, big, i);
			heapify(arr, n, big);
		}
		
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;

	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
