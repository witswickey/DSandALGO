package linkedlist;

public class LinkedListInBinaryTree {
	public static ListNode head;
	public static TreeNode root;

	public LinkedListInBinaryTree() {

		head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(8);

		root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(11);// 8
		root.right.left.right.left = new TreeNode(1);
		root.right.left.right.right = new TreeNode(3);

	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null)
			return false;

		if (isSubPathUtil(head, root))
			return true;
		else
			return isSubPathUtil(head, root.left) || isSubPathUtil(head, root.right);
	}

	public boolean isSubPathUtil(ListNode head, TreeNode root) {
		if (head == null) {
			return true;
		}
		if (root == null || root.val != head.val) {
			return false;
		} else {
			return (isSubPath(head.next, root.left) || isSubPath(head.next, root.right));
		}

		// return false;

	}

	public static void main(String[] args) {
		boolean rs = new LinkedListInBinaryTree().isSubPath(head, root);
		System.out.println(rs);

	}

}
