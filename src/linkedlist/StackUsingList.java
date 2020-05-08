package linkedlist;

import linkedlist.RotateList.Node;

public class StackUsingList {
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

	if(head==null) {
		head=new Node(data);
	}
	else {
		Node cur=new Node(data);
		cur.next=head;
		head=cur;
	}
	}
	
	public static int pop() {
		
		if(head==null)
			return -1;
		else {
			Node cur=head;
			head=head.next;
			return cur.data;
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
		int arr[] = { 2, 4, 6, 7, 5, 1 ,9};
		for (int j : arr) {
			push(j);
		}
		print();
		int d=pop();
		System.out.println("Removed ele is "+d);
		d=pop();
		System.out.println("Removed ele is "+d);
		push(8);
		print();
		d=pop();
		System.out.println("Removed ele is "+d);
		print();
	}
	
}
