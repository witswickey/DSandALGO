package linkedlist;

import linkedlist.Sort01and2.Node;

public class AddTwoNumber {
	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node head1;
	public static Node head2;

	public void printbyhead(Node dim) {
		Node cur = dim;
		System.out.print("LinkedList is-----> ");
		while (cur.next != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println(cur.data);
	}

	public static void main(String[] args) {

		AddTwoNumber list = new AddTwoNumber();

		// creating first list
		list.head1 = new Node(4);
		list.head1.next = new Node(5);
		System.out.print("First List is ");
		list.printbyhead(head1);

		// creating seconnd list
		list.head2 = new Node(3);
		list.head2.next = new Node(4);
		list.head2.next.next = new Node(5);
		System.out.print("Second List is ");
		list.printbyhead(head2);

		// add the two lists and see the result
		Node rs = list.addTwoLists(head1, head2);
		System.out.print("Resultant List is ");
		list.printbyhead(rs);
	}

	private Node addTwoLists(Node headA, Node headB) {
		headA = reverselist(headA, null);
		headB = reverselist(headB, null);
		// printbyhead(headA);

		Node headC = null,mainNode = null;
		int sum, carry = 0, rem;

		while (headA != null && headB != null) {

			sum = headA.data + headB.data+carry;
			rem = sum % 10;
			carry = sum / 10;
			if(headC==null) {
				headC = new Node(rem);
				mainNode = headC;
			}
			else {
				headC.next=new Node(rem);
				headC=headC.next;
			}
			headA=headA.next;
			headB=headB.next;
		}
		while(headA!=null) {
			sum = headA.data +carry;
			rem = sum % 10;
			carry = sum / 10;
			headC.next=new Node(rem);
			headC=headC.next;
			headA=headA.next;
		}
		while(headB!=null) {
			sum = headB.data +carry;
			rem = sum % 10;
			carry = sum / 10;
			headC.next=new Node(rem);
			headC=headC.next;
			headB=headB.next;
		}
		return mainNode;

	}

	private Node reverselist(Node headA, Node prev) {
		if (headA == null) {
			return prev;
		} else {
			Node temp = headA.next;
			headA.next = prev;
			prev = headA;
			return reverselist(temp, prev);
		}
	}
}
