package linkedlist;

import java.util.Stack;

public class CheckPlaindrome {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node head;

	public static void add(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}

			cur.next = new Node(data);

		}
	}

	public static void print() {
		Node cur = head;
		System.out.print("LinkedList is-----> ");
		while (cur.next != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println(cur.data);
	}

	public static void printbyhead(Node dim) {
		Node cur = dim;
		System.out.print("LinkedList is-----> ");
		while (cur.next != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println(cur.data);
	}

	public static void main(String[] args) {
		//int arr[] = { 2, 4, 6, 7, 5, 1, 9 };
		int arr[] = { 1,2,2,1 };
		for (int j : arr) {
			add(j);
		}
		print();
		boolean rs = new CheckPlaindrome().CheckPalindrome(head);
		System.out.println(rs);
	}

	private boolean CheckPalindrome(Node head2) {

		int count = 0;
		Node cur = head2;
		Stack<Node> com=new Stack<>();
		
		while (cur != null) {
			com.push(cur);
			cur = cur.next;
		}
		cur=head2;
		while(!com.isEmpty() || cur!=null) {
			Node st=com.pop();
			if(cur.data!=st.data)
				break;
			cur=cur.next;
		}
		if(com.isEmpty() && cur==null) {
			return true;
		}

		
		return false;

	}

}
