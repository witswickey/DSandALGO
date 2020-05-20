package tree;

public class BuildTreeFromInorderAndPostOrder {
	// driver program to test above functions
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		Node root = tree.buildTree(in, pre, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		printInorder(root);
	}

	static void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print((char)node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}
}
