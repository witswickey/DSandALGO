package linkedlist;

public class RotateList {
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
		int arr[] = { 2, 4, 6, 7, 5, 1 ,9};
		for (int j : arr) {
			add(j);
		}
		print();
		// new NtheFromLast().findmiddle();
		//head=new RotateList().rotateListByK(head, 3);
		head=new RotateList().reverseListbyK(head,null,0,3,head);
		// System.out.println("After Sorting");
		print();
	}
	
	
	private Node reverseListbyK(Node cur,Node prev,int i,int k,Node first) {
		if (cur==null) {
			return prev;
		}
		else if (i==k) {
			i=0;
			first.next=reverseListbyK(cur, null, i, k, cur);
			return prev;
		}
		Node temp=cur.next;
		cur.next=prev;
		prev=cur;
		i+=1;
		return reverseListbyK(temp, prev,i , k, first);

	}
	
	private Node reverseList(Node cur,Node prev) {
		if(cur==null) {
			return prev ;
		}
		else {
			Node temp=cur.next;
			cur.next=prev;
			prev=cur;
		    return reverseList(temp, prev);
		}
	}

	private Node rotateListByK(Node head, int n) {

		Node cur=head;
		Node temp,last;
		while (cur.next != null) {
			cur = cur.next;
		}
		last=cur;
		for (int i = 0; i < n; i++) {
			temp = head.next;
			last.next = head;
			head.next = null;
			last=head;
			head = temp;
		}
		return head;

	}
}
