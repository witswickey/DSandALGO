package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int num[] = { 1, 10, 2, 6, 4 };
		mergeSort(num, 0, num.length-1);
		System.out.println(Arrays.toString(num));
		printArray(num);
	}

	private static void mergeSort(int[] num, int l, int h) {

		if (l < h) {
			int mid = (l + h) / 2;
			mergeSort(num, l, mid);
			mergeSort(num, mid + 1, h);
			merge(num, l, mid, h);
		}

	}
	/* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	private static void merge(int[] num, int l, int mid, int h) {

		int leftlen = mid - l + 1;
		int rightlen = h - mid;
		int[] left = new int[leftlen];
		int[] right = new int[rightlen];
		int i = 0, j = 0, c = l;
		int k = 0;
		for (k = 0; k < leftlen; k++) {
			left[k] = num[k+l];
		}
		for (k = 0; k < rightlen; k++) {
			right[k] = num[k+mid+1];
		}

		while (i < leftlen && j < rightlen) {
			if (left[i] <= right[j]) {
				num[c] = left[i];
				i++;
			} else {
				num[c] = right[j];
				j++;
			}
			c++;
		}
		while (i < leftlen) {
			num[c] = left[i];
			c++;
			i++;
		}
		while (j < rightlen) {
			num[c] = right[j];
			c++;
			j++;
		}

	}

}
