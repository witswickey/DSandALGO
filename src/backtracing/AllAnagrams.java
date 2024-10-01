package backtracing;

import java.util.Arrays;
import java.util.LinkedList;


public class AllAnagrams {

	public static void main(String[] args) {

		String str = "God";
		new AllAnagrams().printallanagram(str);

	}

	private void printallanagram(String str) {

		LinkedList<Character> result = new LinkedList();
		boolean used[] = new boolean[256];
		Arrays.fill(used,false);
		printallAnagramUtil(str.toCharArray(), result, used);
		// print(result);
	}

	private void print(LinkedList<String> result) {
		// TODO Auto-generated method stub
		for (String str : result) {
			System.out.println(str);
		}
	}

	private  void printallAnagramUtil(char[] input, LinkedList<Character> result,boolean[] used) {

			if(result.size()==input.length) {
				System.out.println(String.valueOf(result));
				return;
			}
			
			for(int i=0;i<input.length;i++) {
				if(!used[input[i]]) {
				used[input[i]]=true;
				result.add(input[i]);
				printallAnagramUtil(input, result, used);
				used[input[i]]=false;
				result.remove(result.size()-1);
				}
			}
		}

	public void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
