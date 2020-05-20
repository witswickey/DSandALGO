package tree;

public class CheckBST {

	static int lmax = Integer.MIN_VALUE;
	static int rmin = Integer.MAX_VALUE;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	};

	// Driver Code
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(7);
		root.right = new Node(16);
		root.left.left = new Node(1);
		root.left.right = new Node(12);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		// root.left.left = new Node(1);
		// root.left.right = new Node(4);

		// 15 7 16 1 12 N N N 2 10 14
		if (isBST(root))
			System.out.print("Is BST");
		else
			System.out.print("Not a BST");
		System.out.println((float)(3/2));
	}

	private static boolean isBST(Node root) {

		if (root == null)
			return true;
		if (root != null && root.left == null && root.right == null)
			return true;
		if (root.left != null && root.left.data > lmax) {
			lmax = root.left.data;
		}
		if (root.right != null && root.right.data < rmin) {
			rmin = root.right.data;
		}
		if (root.left != null) {
			if (!((root.data > root.left.data) && root.data >= lmax && isBST(root.left))) {
				return false;
			}
		}
		if (root.right != null) {
			if (!((root.data < root.right.data) && (root.data <= rmin) && isBST(root.right))) {
				return false;
			}
		}
		return true;
	}
}
