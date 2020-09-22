package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {

	static class Node {
		ListNode ele;

		public ListNode getEle() {
			return ele;
		}

		public int getArray_row() {
			return array_row;
		}

		int array_row;

		Node(ListNode l, int r) {
			ele = l;
			array_row = r;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Node> pr = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.getEle().val - o2.getEle().val;
			}
		});
		
		PriorityQueue<ListNode> pm=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            
			public int compare(ListNode o1,ListNode o2){
                
                ListNode n1=(ListNode)o1;
                ListNode n2=(ListNode)o2;
                
                return n1.val-n2.val;                   
            }
        });
		ListNode head = null, last = null;
		for (int i = 0; i < lists.length; i++) {
			Node nio = new Node(lists[i], i);
			pr.add(nio);
		}
		int c = 0;
		while (!pr.isEmpty()) {
			Node nio = pr.peek();
			pr.poll();
			ListNode ns = nio.getEle();
			int index = nio.getArray_row();
			if(lists[index].next!=null)
				{Node newNode=new Node(lists[index].next,index+1);
				pr.add(newNode);}
			lists[index] = lists[index].next;
			if (head == null) {
				head = new ListNode(ns.val);
				last = head;
			} else {
				ListNode cur = head;
				while (cur.next != null) {
					cur = cur.next;
				}
				cur.next = new ListNode(ns.val);
			}
		}
		ListNode cur = head;
		while (cur != null) {
			System.out.println(cur.val + " ");
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args) {

		ListNode ls = new ListNode(1);
		ls.next = new ListNode(4);
		ls.next.next = new ListNode(5);

		ListNode ds = new ListNode(1);
		ds.next = new ListNode(3);
		ds.next.next = new ListNode(4);

		ListNode ms = new ListNode(2);
		ms.next = new ListNode(6);

		ListNode list[] = new ListNode[3];
		list[0] = ls;
		list[1] = ds;
		list[2] = ms;

		new MergeKList().mergeKLists(list);

	}

}
