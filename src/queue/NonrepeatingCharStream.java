package queue;

import java.util.LinkedList;
import java.util.Queue;

public class NonrepeatingCharStream {
	// Driver function
	public static void main(String[] args) {
		String str = "AQIZQAZPN";
		firstNonRepeating(str);
	}

	private static void firstNonRepeating(String str) {
		
		Queue<Character> que=new LinkedList();
		
		int hasharr[]=new int[26];
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			hasharr[ch-'A']=hasharr[ch-'A']+1;
			que.add(ch);
			while(!que.isEmpty()) {
			if(hasharr[que.peek()-'A']>1) {
				que.remove();
			}
			else {
				System.out.print(" "+que.peek());
				break;
			}
			}
			
		}
		while(que.isEmpty()) {
			System.out.print(" "+que.peek());
			que.remove();
		}
		

	}
}
