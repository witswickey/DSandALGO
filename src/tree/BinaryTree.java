package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;
	static int treeindex=0;

	public int maxDepth(Node root) {

		Node cur = root;

		int t = recurmaxdept(cur, 1);

		return t;

	}

	int heigth(Node root) {

		if (root == null)
			return 0;
		return Math.max(heigth(root.left),heigth(root.right))+1;

	}

	private int recurmaxdept(Node cur, int i) {

		int m = 0, k = 0;
		if (cur == null || (cur.left == null && cur.right == null))
			return i;
		else {
			if (cur.left != null) {
				m = recurmaxdept(cur.left, i + 1);
			}
			if (cur.right != null) {
				k = recurmaxdept(cur.right, i + 1);
			}

			return Math.max(m, k);
		}

	}

	boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;

		else if (root1.data == root2.data && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right))
			return true;
		else
			return false;
	}

	public int getdiameter(Node root2) {

		if (root2 == null)
			return 0;

		int lh = recurmaxdept(root2.left, 1);
		int rh = recurmaxdept(root2.right, 1);

		int ld = getdiameter(root2.left);
		int rd = getdiameter(root2.right);

		return Math.max(lh + rh + 1, ld + rd);

	}

	public void iterativePreorder() {

		Stack<Node> st = new Stack();

		Node cur = root;
		st.push(root);
		while (!st.isEmpty()) {
			Node t = st.pop();
			System.out.print(" " + t.data);
			if (t.right != null) {
				st.push(t.right);
			}
			if (t.left != null) {
				st.push(t.left);
			}

		}

	}

	public void iterativePostorder() {

		Stack<Node> st = new Stack();
		Node parent = null;

		Node cur = root, cu = null;
		// st.push(root);
		// parent=root;
		Node t;
		while (cur != null || !st.isEmpty()) {

			if (cur != null) {
				st.push(cur);
				cur = cur.left;

			} else {
				cu = st.peek().right;
				if (cu == null) {
					t = st.pop();
					System.out.print(" " + t.data);
					while (!st.isEmpty() && t == st.peek().right) {
						t = st.pop();
						System.out.print(" " + t.data);
					}
				} else
					cur = cu;
			}

		}

	}

	public void iterativeInorder() {

		Stack<Node> st = new Stack();
		Node parent = null;

		Node cur = root, cu = null;
		st.push(root);
		// parent=root;
		Node t;
		while (!st.isEmpty()) {
			t = st.peek();
			while (t.left != null && t != parent) {
				st.push(t.left);
				t = t.left;
			}
			cu = st.pop();
			if (!st.isEmpty() && st.peek() != null)
				parent = st.peek();
			System.out.print(" " + cu.data);
			if (cu.right != null)
				st.push(cu.right);
		}

	}

	public void levelorder() {
		Queue<Node> que = new LinkedList<Node>();

		que.add(root);

		while (!que.isEmpty()) {

			Node t = que.poll();

			System.out.print(" " + t.data);

			if (t.left != null)
				que.add(t.left);
			if (t.right != null)
				que.add(t.right);
		}
	}

	public Node buildTree(char[] in, char[] pre, int i, int j) {
		
		if(i>j)
			 return null;
		Node temp=new Node(pre[treeindex++]);
		
		int index=search(in,pre,i,j,temp.data);
		
		temp.left=buildTree(in,pre,i,index-1);
		temp.right=buildTree(in,pre,index+1,j);
		
		return temp;
		
		
	}

	private int search(char[] in, char[] pre, int k, int m,int data) {
		
		int i=0;
		for( i=k;i<=m;i++) {
			
			if(in[i]==data)
				return i;
		}
		 return i; 
		
	}

}
