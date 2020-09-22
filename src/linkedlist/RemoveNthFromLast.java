package linkedlist;


public class RemoveNthFromLast {
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
	public static void main(String[] args) {
		int arr[] = { 1,2 };
		for (int j : arr) {
			add(j);
		}
		print();
		//new NtheFromLast().findmiddle();
		head=new RemoveNthFromLast().removeNthFromLast(3);
		System.out.println("After Removing");
		print();

	}

	private Node removeNthFromLast(int n) {
		  if(head==null){
	            return head;
	        }
	        else if (head.next==null){
	            return null;
	        }
	        int count=1;
	        Node slow=head,fast=head;
	        Node prev=null;
	        while(fast.next!=null){
	            fast=fast.next;
	            count++;
	            if(count>n){
	                prev=slow;
	                slow=slow.next;
	            }
	            System.out.println("count:"+count+" fast data is "+fast.data+ " slow data "+slow.data);
	        }
	        
	        if(prev!=null){
	            prev.next=slow.next;
	        }
	        else {
	        	head=slow.next;
	        }
	        return head;
	}

}
