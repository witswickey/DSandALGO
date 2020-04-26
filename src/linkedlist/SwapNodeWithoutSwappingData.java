package linkedlist;

import linkedlist.SortUsingHeadOnly.Node;

public class SwapNodeWithoutSwappingData {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node head;

	public static void push(int data) {
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

	public static void main(String[] args) {
		int arr[] = { 3, 4, 1, 2, 6, 8, 7 };
		for (int j : arr) {
			push(j);
		}
		print();
		try {
			SwapWithoutData(1, 8);
			SwapWithoutData(2, 6);
			SwapWithoutData(2, 6);
			SwapWithoutData(3,8);
			SwapWithoutData(4,7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After swapping");
		print();

	}

	private static void SwapWithoutData(int i, int j) throws Exception {

		Node cur = head;

		Node before_i = null;
		Node i_node = null;

		Node before_j = null;
		Node j_node = null;

		if (i == j) {
			return;
		}

		while (cur.next != null) {

			if (cur.next.data == i) {
				before_i = cur;
				i_node = cur.next;
			} else if (cur.next.data == j) {
				before_j = cur;
				j_node = cur.next;
			} else if (cur.data == i) {
				i_node = cur;
			} else if (cur.data == j) {
				j_node = cur;
			}
			cur = cur.next;

		}
		if (i_node == null || j_node == null) {
			throw new Exception("Node is not present");
		}
		
		if(before_i==null) {
			head=j_node;
		}
		else
			before_i.next=j_node;
		
		if(before_j==null) {
			head=i_node;
		}
		else
			before_j.next=i_node;
		
		Node temp = j_node.next;
		j_node.next = i_node.next;
		i_node.next = temp;

	}

	private static void swap(Node before_i, Node i_node, Node before_j, Node j_node) {

		Node temp = j_node.next;

		before_i.next = j_node;
		j_node.next = i_node.next;
		before_j.next = i_node;
		i_node.next = temp;

	}
}
