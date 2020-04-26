package arrays;

import java.util.Scanner;

public class SubArraySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();

			int[] arr = new int[N];
			
			int sum = sc.nextInt();

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}

			//sc.nextInt();
			printsum(arr, sum);
			// printArray(arr);
		}

	}

	private static int printsum(int[] arr, int sum) {
		int cursum = arr[0], start = 0;
		
	 //System.out.println("sum is"+sum+" "+cursum);

		for (int i = 1; i <= arr.length; i++) {
			
			while (cursum > sum && start < i - 1) {
				System.out.println(cursum+" - "+arr[start]+" = "+(cursum - arr[start]));
				cursum -= arr[start];
				start++;
			}
			if (cursum == sum) {
				System.out.println((start+1) + " " + (i));
				return 1;
			}

			if (i < arr.length) {
				System.out.println(cursum + " + " + arr[i]+" = "+(cursum + arr[i]));
				cursum += arr[i];
			}
			

		}
		System.out.println("-1");
		return -1;
	}
}
