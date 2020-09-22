package sorting;

public class InsertionSort {

	public static void main(String[] args) {

		int[] num = { 3, 0, 1, 7, 8, 2, 6, 5, 4 };
		new InsertionSort().sort(num, num.length-1);
		print(num);

	}

	public static void print(int[] num) {
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private void sort(int[] num, int length) {
		int j = 0;
		for (int i = 1; i <=length; i++) {
			j = i-1;
			int ele=num[i];
			while (j >=0 && num[j] > ele) {
				num[j+1]=num[j];
				j--;
			}
			num[j+1]=ele;
			//print(num);
		}
	}

	private void swap(int[] num, int i, int j) {

		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
