package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSiblings {

	static class Node {
		Node left;
		Node right;
		Node next;
		int data;

		Node(int d) {

			this.data = d;
		}
	}

	static Node root;

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		createSibling(root);
		createSiblingRecur(root);

	}

	private static void createSiblingRecur(Node root2) {

		Node cur = root2;
		
		cur.next=null;

		while (cur != null) {
			Node p = cur;
			while (p != null) {

				if (p.left != null) {
					if (p.right != null) {
						p.left.next = p.right;
					} else {
						p.left.next = getNext(p);
					}
				}
				if (p.right != null) {
					p.right.next = getNext(p);
				}
				p = p.next;
			}
			// start from the first node of next level
			if (cur.left != null)
				cur = cur.left;
			else if (cur.right != null)
				cur = cur.right;
			else
				cur = getNext(cur);
		}

	}

	private static Node getNext(Node qt) {

		Node temp = qt.next;
		if (temp != null) {

			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.next;
		}
		return null;
	}

	private static void createSibling(Node root2) {

		Queue<Node> que = new LinkedList<Node>();

		que.add(root);

		que.add(null);

		while (!que.isEmpty()) {

			Node t = que.poll();
			if (t != null) {
				t.next = que.peek();

				if (t.left != null)
					que.add(t.left);
				if (t.right != null)
					que.add(t.right);
			} else {
				if (!que.isEmpty())
					que.offer(null);
			}

		}

	}
}
