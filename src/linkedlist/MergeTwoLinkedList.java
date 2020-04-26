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
	Node sortedMerge(Node headA, Node headB) {
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
}
