package tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class BinaryTreeOpeartions {

	static int max = Integer.MIN_VALUE;

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		findMaxSum(tree.root);
		PrintSpiral(tree.root);
		System.out.println();
		printlevelorder(tree);
		System.out.println();
		printvertical(tree);
		System.out.println();
		System.out.println("Max is " + max);
	}

	private static void printvertical(BinaryTree tree) {

		HashMap<Node, Integer> map = new HashMap();

		Node root = tree.root;

		setheight(map, root, 0);

		for (Entry<Node, Integer> e : map.entrySet()) {
			System.out.println(" " + e.getKey().data + "->" + e.getValue());
		}
		System.out.println();

		prinvertcialorder(map, root);

	}

	private static void prinvertcialorder(HashMap<Node, Integer> map, Node root) {

		List<Map.Entry<Node, Integer>> list = new LinkedList<Map.Entry<Node, Integer>>(map.entrySet());

		// Sort the list on map values
		Collections.sort(list, new Comparator<Map.Entry<Node, Integer>>() {
			public int compare(Map.Entry<Node, Integer> o1, Map.Entry<Node, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		for (Entry<Node, Integer> e :list) {
			System.out.print(" " + e.getKey().data);
		}

	}

	private static void setheight(HashMap<Node, Integer> map, Node root, int hd) {

		if (root == null)
			return;

		map.put(root, hd);

		setheight(map, root.left, hd - 1);
		setheight(map, root.right, hd + 1);

	}

	private static void printlevelorder(BinaryTree tree) {

		int h = tree.maxDepth(tree.root);

		for (int i = 1; i <= h; i++) {
			pritnlevelbydepth(tree.root, i);
		}
	}

	private static void pritnlevelbydepth(Node root, int level) {

		if (root == null)
			return;
		if (level == 1) {
			System.out.print(" " + root.data);
		} else if (level > 1) {
			pritnlevelbydepth(root.left, level - 1);
			pritnlevelbydepth(root.right, level - 1);
		}

	}

	private static void PrintSpiral(Node root) {

		sprialutil(root);

	}

	private static void sprialutil(Node root) {

		Stack<Node> st = new Stack<Node>();
		Stack<Node> sp = new Stack<Node>();

		st.push(root);

		while (!st.isEmpty() || !sp.isEmpty()) {

			while (!st.isEmpty()) {
				Node t = st.pop();
				System.out.print(" " + t.data);
				if (t.left != null)
					sp.push(t.left);
				if (t.right != null)
					sp.push(t.right);
			}
			while (!sp.isEmpty()) {
				Node t = sp.pop();
				System.out.print(" " + t.data);
				if (t.right != null)
					st.push(t.right);
				if (t.left != null)
					st.push(t.left);
			}

		}

	}

	private static int findMaxSum(Node root) {

		if (root == null) {
			return 0;
		}

		int ld = 0, rd = 0, sum = 0, sum1 = 0;
		if (root.left != null) {
			ld = findMaxSum(root.left);
		}
		if (root.right != null) {
			rd = findMaxSum(root.right);
		}
		sum = Math.max(Math.max(ld, rd) + root.data, root.data);

		sum1 = Math.max(sum, ld + rd + root.data);

		if (sum1 > max)
			max = sum1;

		return sum;
	}
}
