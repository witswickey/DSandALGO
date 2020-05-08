package linkedlist;

import linkedlist.SortUsingHeadOnly.Node;

public class MergeTwoLinkedList {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	static Node headA=null;
	static Node headB=null;
	Node sortedMerge() {
		    Node apo=headA; 
		    Node bpo=headB;
		    Node headC=null;
		    if (headA.data<headB.data){
		        headC=new Node(headA.data);
		        apo=apo.next;
		    }
		    else
		    {
		         headC=new Node(headB.data);
		        bpo=bpo.next;
		    }
		    Node temp=headC;
		    while (apo!=null &&  bpo!=null){
		        
		        if(apo.data<bpo.data){
		          temp.next=new Node(apo.data);
		          apo=apo.next;
		        }
		        else{
		        temp.next=new Node(bpo.data);
		        bpo=bpo.next;
		        }
		        temp=temp.next;
		    
		    }
		    while (apo!=null){
		        temp.next=new Node(apo.data);
		        apo=apo.next;
		        temp=temp.next;
		    }
		    while (bpo!=null){
		        temp.next=new Node(bpo.data);
		        bpo=bpo.next;
		        temp=temp.next;
		    }
		    return headC;
		   }
	
	 public static Node addToTheLast(Node head,Node node)  
	 { 
	     if (head == null) 
	     { 
	         head = node; 
	         
	     } 
	     else 
	     { 
	         Node temp = head; 
	         while (temp.next != null) 
	             temp = temp.next; 
	         temp.next = node; 
	     }
	     return head;
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
	// Driver Code 
	public static void main(String args[]) 
	{ 
	    /* Let us create two sorted linked 
	       lists to test the methods  
	       Created lists: 
	           llist1: 5->10->15, 
	           llist2: 2->3->20 
	    */
 
	      Node headc;
	    // Node head1 = new Node(5); 
	      headA=addToTheLast(headA,new Node(5)); 
	      headA=addToTheLast(headA,new Node(10)); 
	      headA= addToTheLast(headA,new Node(15)); 
	      
	    // Node head2 = new Node(2); 
	      headB=addToTheLast(headB,new Node(2)); 
	      headB=addToTheLast(headB,new Node(3)); 
	      headB=addToTheLast(headB,new Node(20)); 
	      System.out.println("Given list are ");
	      
	      printbyhead(headA);
	      printbyhead(headB);
	      System.out.println("After merge");
	     headc = new MergeTwoLinkedList().sortedMerge(); 
	     printbyhead(headc);      
	      
}
}
