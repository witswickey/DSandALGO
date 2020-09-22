package JavaBasic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionExample {

	private static void listops(ArrayList<Integer> list) {
		int i = 100;
		while (i >=0) {
			list.add(i);
			i -= 10;
		}
	}
	private static void linklistops(LinkedList<Integer> list) {
		int i = 0;
		while (i <= 100) {
			list.add(i);
			i += 10;
		}
	}
	private static void veclistops(Vector<Integer> list) {
		int i = 0;
		while (i <= 100) {
			list.add(i);
			i += 10;
		}
	}
	
	private static void LinkedHashtops(LinkedHashSet<Integer> list) {
		int i = 100;
		while (i >=0) {
			list.add(i);
			i -= 10;
		}
	}
	private static void HashSetops(HashSet<Integer> list) {
		int i = 0;
		while (i <= 100) {
			list.add(i);
			i += 10;
		}
	}
	private static void TreeSettops(TreeSet<Integer> list) {
		int i = 0;
		while (i <= 100) {
			list.add(i);
			i += 10;
		}
		list.add(5);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> linklist = new LinkedList<Integer>();
		Vector<Integer> vec = new Vector<Integer>();

		listops(list);
		linklistops(linklist);
		veclistops(vec);

		System.out.println("list->"+list);
		System.out.println("Linkedlist->"+linklist);
		System.out.println("Vector->"+vec);
		System.out.println(list.equals(linklist));
		System.out.println(list.equals(vec));
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedHashSet<Integer> Lset= new LinkedHashSet<Integer>();
		TreeSet<Integer> Tset = new TreeSet<Integer>();

		LinkedHashtops(Lset);
		HashSetops(set);
		TreeSettops(Tset);
		System.out.println("HashSet>"+set);
		System.out.println("LinkedHashSet->"+Lset);
		System.out.println("TreeSet->"+Tset);		
		System.out.println(set.equals(Lset));
		System.out.println(Lset.equals(Tset));
		

	}
}
