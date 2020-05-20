package tree;

import java.util.LinkedList;
import java.util.Queue;

public class KthAncester {
	// Driver code 
	
	// A Binary Tree Node 
	static class Node 
	{ 
	    int data; 
	    Node left, right; 
	}

	private static int Count = 0;; 
	  
	// temporary node to keep track of Node returned 
	// from previous recursive call during backtrack 
	static Node temp = null; 
	static int k; 
	// Utility function to create a new tree node 
	static Node newNode(int data) 
	{ 
	    Node temp = new Node(); 
	    temp.data = data; 
	    temp.left = temp.right = null; 
	    return temp; 
	} 
	public static void main(String args[]) 
	{ 
	    // Let us create binary tree shown in above diagram 
	    Node root = newNode(1); 
	    root.left = newNode(2); 
	    root.right = newNode(3); 
	    root.left.left = newNode(4); 
	    root.left.right = newNode(5); 
	  
	    k = 2; 
	    int node = 5; 
	    int[] anc=new int[6];
	    // print kth ancestor of given node 
	     kthAncestorBFS(root,anc); 
	    int parent =printKthAnces(anc,node,k);
	      
	    System.out.println(parent); 
	}
	private static int printKthAnces(int[] anc, int node,int k) {

		while(node!=-1) {
			 node=anc[node];
			Count++;
			if(Count==k)
				break;
		
		}
		return node;
		
	}
	private static void kthAncestorBFS(Node root,int[] anc) {
		Queue<Node> q=new LinkedList();
		
		q.add(root);
		anc[root.data]=-1;
		while(!q.isEmpty()) {
			Node te=q.peek();
			q.poll();
			
			if(te.left!=null) {
				q.add(te.left);
				anc[te.left.data]=te.data;
				
			}
			if (te.right!=null) {
				q.add(te.right);
				anc[te.right.data]=te.data;
			}
			
		}
	}
	private static Node kthAncestorDFS(Node root, int node) {
		return root;
		
	} 
	} 