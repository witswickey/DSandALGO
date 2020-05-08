package linkedlist;

import linkedlist.MergeTwoLinkedList.Node;

public class Sort01and2 {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
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

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(0);
		head.next.next.next = new Node(1);
		System.out.println("Linked List Before Sorting");
		printbyhead(head);
		head = sortList(head);
		System.out.println("\nLinked List After Sorting");
		printbyhead(head);
	}

	private static Node sortList(Node head) {

		Node zerod = null, oned = null, twod = null;
		Node cur = head;
		Node headm = null, heado = null, headt = null;
		while (cur != null) {

			if (cur.data == 0) {
				if (zerod == null) {
					zerod = new Node(cur.data);
					headm = zerod;
				} else {
					zerod.next = new Node(cur.data);
					zerod = zerod.next;
				}
			} else if (cur.data == 1) {
				if (oned == null) {
					oned = new Node(cur.data);
					heado = oned;
				} else {
					oned.next = new Node(cur.data);
					oned = oned.next;
				}
			} else if (cur.data == 2) {
				if (twod == null) {
					twod = new Node(cur.data);
					headt = twod;
				} else {
					twod.next = new Node(cur.data);
					twod = twod.next;
				}
			}
			cur = cur.next;

		}
		if(zerod!=null){
		    if(heado!=null)
		        zerod.next = heado;
		    else if(headt!=null)
		        zerod.next = headt;
		    
		}
		if(oned!=null)
		    oned.next = headt;
		return headm;

	}
}
