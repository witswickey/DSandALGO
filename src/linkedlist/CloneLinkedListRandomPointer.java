package linkedlist;

import java.util.HashMap;

import linkedlist.StackUsingList.Node;

public class CloneLinkedListRandomPointer {

	static class Node {
		int data;
		Node next;
		Node rand;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.rand = null;
		}
	}

	static Node head;

	public static void printbyhead(Node dim) {
		Node cur = dim;
		System.out.println("LinkedList is-----> ");
		if(dim==null) {
			System.out.println("Empty");
		}
		while (cur.next != null) {
			System.out.print(cur.data + "->");
			System.out.println(String.format(" %s ", cur.rand.data));
			cur = cur.next;
		}
		System.out.print(cur.data + "->");
		System.out.println(String.format(" %s ", cur.rand.data));
	}

	public static void main(String[] args) {

		head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		head.rand = head.next.next;
		head.next.rand = head;
		head.next.next.rand = head.next.next.next;
		head.next.next.next.rand = head.next;
		printbyhead(head);

		clonelisttricky(head);
	}

	private static void clonelist(Node head) {

		Node cur = head;
		Node headmain = null, koko = null;
		HashMap<Node, Node> map = new HashMap<>();
		while (cur != null) {
			if (headmain == null) {
				headmain = new Node(cur.data);
				map.put(cur, headmain);
				koko = headmain;
			} else {
				headmain.next = new Node(cur.data);
				map.put(cur, headmain.next);
				headmain = headmain.next;
			}

			cur = cur.next;
		}
		cur = head;
		headmain = koko;
		//printbyhead(koko);
		while (cur != null) {

			Node temp = cur;
			Node jojo = map.get(temp);
			jojo.rand = cur.rand;
			cur = cur.next;
		}
		printbyhead(koko);
	}
	private static void clonelisttricky(Node head) {

		Node cur=head;
		Node cal=null,temp;
		Node koko=null;
		while(cur!=null) {
			
			if(cal==null)
			 {
				cal=new Node(cur.data);
				koko=cal;
				
			 }
			else {
				cal=new Node(cur.data);
			}
				temp=cur.next;
				cur.next=cal;
				cal.next=temp;
				cur=cal.next;
		}
		cur=head;
		while(cur!=null  && cur.next!=null) {
			 temp=cur.rand;
			 cur.next.rand=temp.next;
			 cur=cur.next.next;
		}
		cur=head;
		while(cur!=null && cur.next!=null) {
			 temp=cur.next.next;
			 cur.next=temp;
			 cur=temp;
		}
		
		printbyhead(koko);
	}
}
