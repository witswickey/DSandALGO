package tree;

import java.util.LinkedList;
import java.util.List;

public class LCA {

	static List<Node> l1;
	static List<Node> l2;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(3);
		tree.root.left = new Node(6);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(11);
		tree.root.left.right.left = new Node(9);
		tree.root.left.right.right = new Node(5);
		// tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(13);
		tree.root.right.right.right = new Node(7);

		System.out.println("LCA(5, 9): " + findLCAiterativeecur(tree.root, 5, 9));

		System.out.println("LCA(13, 7): " + findLCARecur(tree.root, 13, 7).data);

	}

	private static Node findLCARecur(Node root, int k, int j) {
		if (root == null) {
			return null;
		}
		if (root != null && root.left == null && root.right == null && root.data != k && root.data != j) {
			return null;
		}
		if (root.data == k || root.data == j) {
			return root;
		}
		Node left = findLCARecur(root.left, k, j);
		Node right = findLCARecur(root.right, k, j);
		if (left != null && right != null) {
			return root;
		} else if (left == null && right == null)
			return null;
		return left != null ? left : right;

	}

	private static int findLCAiterativeecur(Node root, int k, int j) {

		l2 = new LinkedList<Node>();
		l1 = new LinkedList<Node>();
		pathTOLCA(root, k, l1);
		pathTOLCA(root, j, l2);

		int c = 0;

		while (l1 != null && l2 != null) {
			if (l1.get(l1.size() - c - 1) == l2.get(l2.size() - c - 1)) {
				return l1.get(l1.size() - c - 1).data;
			}
			c++;
		}
		return root.data;

	}

	private static boolean pathTOLCA(Node root, int k, List<Node> l) {

		if (root == null)
			return false;

		if (root.data == k)
			return true;

		l.add(root);

		if (root.left != null && pathTOLCA(root.left, k, l)) {

			return true;

		}
		if (root.right != null && pathTOLCA(root.right, k, l)) {

			return true;

		}
		l.remove(l.size() - 1);
		return false;
	}

}
