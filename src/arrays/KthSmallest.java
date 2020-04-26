package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

public class KthSmallest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();

			int[] arr = new int[N];

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			int k = sc.nextInt();
			// printArray(arr);
			System.out.println();
			System.out.println("" + kthSmallest(arr, 0, arr.length, k));
		}
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;

	}

	public static int buildminheap(int[] arr, int k) {
		int n = arr.length - 1;// 6
		for (int i = n / 2; i >= 0; i--) {
			heapify(arr, n, i);
			// printArray(arr);
		}
		 printArray(arr);
		for (int i = 0; i < k; i++) {
			 //printArray(arr);
			swap(arr, 0, n - i);
			 System.out.println("before heapify");
			printArray(arr);
			// call max heapify on the reduced heap
			heapify(arr, n - i-1 , 0);
			System.out.println("after heapify");
			printArray(arr);
		}
	   // printArray(arr);
		return arr[n -k+1 ];

	}

	private static void heapify(int[] arr, int n, int i) {

		System.out.println("n is "+n+" i is "+i);
		// int min = arr[i];
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l <= n && arr[l] < arr[largest])
			largest = l;
		if (r <= n && arr[r] < arr[largest])
			largest = r;
		// System.out.println("largest is "+largest);
		if (largest != i) {
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}

	private static int kthSmallest(int[] arr, int i, int j, int k) {
		// we are solving this problem using customized heapsort
		int num = buildminheap(arr, k);
		// printArray(arr);
		return num;

	}
}