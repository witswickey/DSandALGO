package linkedlist;

public class SortUsingHeadOnly {

	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public static Node head;
	
	public Node sortlist(Node main) {
		
		if(main.next==null) {
			return main;
		}
		Node cur=main;
		Node min=main;
		Node previous=null;
		while(cur.next!=null) {
			if(min.data>cur.next.data) {
				min=cur.next;
				previous=cur;
			}
			cur=cur.next;
		}
		
		if(min!=main) {
			Node ptr=main;
			Node headref=min;
			
			previous.next=ptr;
			Node temp=min.next;
			min.next=previous;
			ptr.next=temp;
			main=headref;
		}
		
		main.next=sortlist(main.next);
		return main;
		
	}
/*	private Node swap(Node headref,Node main, Node min, Node previous) {
		
		Node ptr=main;
		headref=min;
		
		previous.next=ptr;
		Node temp=min.next;
		min.next=previous;
		ptr.next=temp;
		
		return headref;
		
	}
*/
	public static void push(int data) {
		if(head==null) {
			head=new Node(data);
		}
		else {
		Node cur=head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		cur.next=new Node(data);
		}
	}
	
	public static void  print() {
		Node cur=head;
		System.out.print("LinkedList is-----> ");
		while(cur.next!=null) {
			System.out.print(cur.data+"->");
			cur=cur.next;
		}
		System.out.println(cur.data);
	}
	public static void main(String[] args) {
		int arr[]= {3,4,1,2,6,8,7};
		for(int j:arr) {
			push(j);
		}
		print();
		head=new SortUsingHeadOnly().sortlist(head);
		System.out.println("After Sorting");
		print();
	}
}
