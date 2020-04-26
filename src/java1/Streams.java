package java1;

import java.util.*;
import java.util.function.Predicate;

public class Streams {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<Integer>();

		for (int i = 1; i < 99; i++) {
			list.add(i);
		}
		Predicate<Integer> pr=new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		usestreams(list);
	}

	private static void usestreams(List<Integer> list) {

		list.stream().filter(i -> i > 10).forEach(i -> System.out.println(i));

	}

}
