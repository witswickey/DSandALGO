package backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		
		String str="GOD";
		
		List<Character> out=new LinkedList<Character>();
		boolean used[]=new boolean[256];
		permutation(str ,out,used);
	}

	private static void permutation(String str, List<Character> out, boolean[] used) {
		
		if(out.size()==str.length()) {
			System.out.println(out);
		}
		else {
			for(int i=0;i<str.length();i++) {
				if(!used[i]) {
					out.add(str.charAt(i));
					used[i]=true;
					permutation(str, out, used);
					used[i]=false;
					out.remove(out.size()-1);
				}
			}
			
		}
		
	}

}
