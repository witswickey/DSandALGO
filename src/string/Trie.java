package string;

public class Trie {
	public static int Alpabet_size = 26;

	static class TrieDS {
		TrieDS children[] = new TrieDS[Alpabet_size];
		boolean isLeaf;

		public TrieDS() {

			for (int i = 0; i < Alpabet_size; i++) {
				children[i] = null;
			}
		}
	}

	static TrieDS root;

	public static void insertKey(String str) {

		TrieDS ptr = root;
		int index;

		for (int i = 0; i < str.length(); i++) {
			index = str.charAt(i) - 'a';
			if (ptr.children[index] == null) {
				ptr.children[index] = new TrieDS();
			}
			ptr = ptr.children[index];
		}
		ptr.isLeaf = true;

	}

	static boolean search(String key) {
		int len = key.length();

		TrieDS cur = root;
		int index;
		for (int i = 0; i < len; i++) {
			index = key.charAt(i) - 'a';
			if(cur.children[index]!=null) {
				cur=cur.children[index];
			}
			else
				return false;
		}
		return (cur!=null && cur.isLeaf);
	}

	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieDS();

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			insertKey(keys[i]);
		// Search for different keys 
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
	}
}
