package linkedlist;

public class DetectAndRemoveLoop {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node head;

	public static void add() {
         head = new Node(50); 
         head.next = new Node(20); 
         head.next.next = new Node(15); 
         head.next.next.next = new Node(4); 
         head.next.next.next.next = new Node(10); 
  
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next; 
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
		add();
		new DetectAndRemoveLoop().detectandremoveloop(head);
		printbyhead(head);
	}

	private void detectandremoveloop(Node head) {
		Node fast=head,slow=head,cur = null;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			if(slow.next==fast) {
				removeloop(slow,head);
				break;
				
			}
			slow=slow.next;
		
		}
    }

	private void removeloop(Node slow, Node head) {
		
		Node ptr1=slow,ptr2=slow;
		int k=1;
		
		while(ptr1.next!=ptr2) {
			k++;	
			ptr1=ptr1.next;
		}
		
		ptr1=head;
		ptr2=head;
		int i=0;
		while(i++<k) {
			ptr2=ptr2.next;
		}
	/*  Move both pointers at the same pace, 
        they will meet at loop starting node */
       while (ptr2 != ptr1) { 
           ptr1 = ptr1.next; 
           ptr2 = ptr2.next; 
       } 
    // Get pointer to the last node 
       while (ptr2.next != ptr1) { 
           ptr2 = ptr2.next; 
       } 
       /* Set the next node of the loop ending node 
       to fix the loop */
      ptr2.next = null; 
 	}
		
}
