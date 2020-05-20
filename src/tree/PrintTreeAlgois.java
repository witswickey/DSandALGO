package tree;

import java.util.LinkedList;

public class PrintTreeAlgois {

	static LinkedList<Node> list = new LinkedList<Node>();

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.iterativePreorder();
		System.out.println();
		tree.iterativePostorder();
		System.out.println();
		tree.iterativeInorder();
		System.out.println();
		tree.levelorder();
		System.out.println();

		rootToLeafPath(tree.root);
	}

	private static void rootToLeafPath(Node root) {

		if (root == null)
			return;
		if (root != null && root.left == null && root.right == null) {
			list.add(root);
			print(list);
			list.remove(list.size() - 1);
			// print(list);
		} else {
			list.add(root);
			if (root.left != null)
				rootToLeafPath(root.left);
			if (root.right != null)
				rootToLeafPath(root.right);
		}

	}

	private static void print(LinkedList<Node> list) {
		System.out.print("Path is->");
		for (Node n : list) {
			System.out.print(" " + n.data);
		}
		System.out.println();

	}
}
