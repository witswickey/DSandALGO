package arrays;

// Java program to merge 
// K sorted arrays 
import java.util.*;

public class MergeKsortedArrays {

	static class Node {
		int ele;

		public int getEle() {
			return ele;
		}

		public int getArray_row() {
			return array_row;
		}

		public int getIndex() {
			return index;
		}

		int array_row;
		int index;

		Node(int l, int r, int y) {
			ele = l;
			array_row = r;
			index = y;
		}
	}

	// Driver Code
	public static void mergeusingminheap(int k, int[] output, int arr[][]) {

		PriorityQueue<Node> pr = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.getEle()-o2.getEle();
			}
		});

		for (int i = 0; i < k; i++) {
			Node nio = new Node(arr[i][0], i, 0);
			pr.add(nio);
		}
		int c = 0;
		while (!pr.isEmpty()) {
			Node nio = pr.peek();
			pr.poll();
			output[c++] = nio.getEle();
			int inc = nio.getArray_row();
			int index = nio.getIndex();
			if (index < arr[inc].length-1) {
				int ele = arr[inc][index+1];
				Node jio = new Node(ele, inc, index+1);
				pr.add(jio);
				//c++;
			}

		}
		for (int ele : output) {
			System.out.print(ele + " ");
		}
	}

	public static void main(String[] args) {
		// input 2D-array
		int arr[][] = { { 1, 5, 9, 13 },
						{ 2, 6, 10, 14 }, 
						{ 3, 7, 11, 15}, 
						{ 4, 8, 12, 16 } };

		// Number of arrays
		int k = arr.length;

		// Output array
		int[] output = new int[4 * k];
		mergeusingminheap(k, output, arr);

	}
}
