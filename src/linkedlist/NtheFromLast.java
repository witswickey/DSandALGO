package linkedlist;

import linkedlist.MiddleElement.Node;

public class NtheFromLast {
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

	public void findmiddle() {

		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("Middle ele is" + slow.data);
	}

	// Function to find middle element a linked list
	int getNthFromLast(int n) {
		Node cur = head;
		int count = 1;
		Node fast=head,slow=head;
		
		while(fast.next!=null) {
			fast=fast.next;
			count++;
			
			if(count>n) {
				slow=slow.next;
			}
			System.out.println("count:"+count+" fast data is "+fast.data+ " slow data "+slow.data);
		}
		if(count!=n)
			return -1;
		else
		return slow.data;

	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 7, 5, 1 };
		for (int j : arr) {
			add(j);
		}
		print();
		//new NtheFromLast().findmiddle();
		System.out.println("3th from last is ele is" + new NtheFromLast().getNthFromLast(7));
		// System.out.println("After Sorting");
	}
}
