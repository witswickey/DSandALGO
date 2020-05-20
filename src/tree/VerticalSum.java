package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalSum {
	public static int count = 0;

	public static class Pair {
		Node t;
		int distance;

		Pair(Node t, int r) {
			this.t = t;
			this.distance = r;
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left=new Node(6);
		tree.root.right.right = new Node(7);
		verticalsum(tree.root);

	}

	private static void verticalsum(Node root) {

		TreeMap<Integer, LinkedList<Integer>> map = new TreeMap();

		setHash(map, root, 0, 0);
		int sum=0;
		
		for(Map.Entry<Integer, LinkedList<Integer>> en:map.entrySet()) {
			
			for(Integer n:map.get(en.getKey())) {
				sum+=n;
				
			}
			System.out.print("sum is "+sum);
			System.out.println();
			sum=0;
		}

	}

	private static void setHash(TreeMap<Integer, LinkedList<Integer>> map, Node root, int level, int count) {

		Queue<Pair> que = new LinkedList<Pair>();

		que.add(new Pair(root, 0));

		while (!que.isEmpty()) {

			Pair p = que.poll();

			Node temp = p.t;
			int distance = p.distance;

			if (map.get(distance) == null) {
				LinkedList<Integer> l = new LinkedList<Integer>();
				l.add(temp.data);
				map.put(distance, l);
			} else {
				LinkedList<Integer> l = map.get(distance);
				l.add(temp.data);
				map.put(distance, l);
			}

			if (temp.left != null)
				que.add(new Pair(temp.left, distance - 1));
			if (temp.right != null)
				que.add(new Pair(temp.right, distance + 1));
		}

	}
}
