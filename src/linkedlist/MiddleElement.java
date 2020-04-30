package linkedlist;

import linkedlist.SortUsingHeadOnly.Node;

public class MiddleElement {
 static class Node{
	 int data;
	 Node next;
	 Node(int data){
		 this.data=data;
		 this.next=null;
	 }
 }
 public static Node head;
 
 public static void add(int data) {
	 if (head==null) {
		 head=new Node(data);
	 }
	 else {
		 Node t=new Node(data);
		 t.next=head;
		 head=t;
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
 public void findmiddle() {
	 
	 Node slow=head;
	 Node fast=head.next;
	 while(fast!=null && fast.next!=null) {
		 fast=fast.next.next;
		 slow=slow.next;
	 }
	 System.out.println("Middle ele is"+slow.data);
 }
 // Function to find middle element a linked list
 int getMiddle()
{
      Node cur=head;
      int count=0;
      if(head!=null){
         
         while(cur!=null){
          cur=cur.next;
          count++;
      } 
      //System.out.println("count"+count);
      count=(count+1)/2;
      int i=0;
      cur=head;
      
      while(++i<count){
          cur=cur.next;
          
      }
      return cur.data;
      //return -1;
      }
	return -1;
}
 public static void main(String[] args) {
		int arr[]= {2, 4, 6, 7, 5, 1};
		for(int j:arr) {
			add(j);
		}
		print();
		new MiddleElement().findmiddle();
		System.out.println("Middle ele is"+new MiddleElement().getMiddle());
		//System.out.println("After Sorting");
	}
}
