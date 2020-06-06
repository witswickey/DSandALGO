package string;

public class RabinKarp {

	final static int prime = 3;

	public static void main(String[] args) {

		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		// int q = 101; // A prime number
		search(pat, txt);

	}

	private static long createHash(char[] str, int end) {
		long h = 0;

		for (int i = 0; i < end; i++) {
			h += (long) str[i] * Math.pow(prime, i);
		}
		return h;
	}

	// private static recalculateHash(char[] str,)

	static void search(String pat, String txt) {

		int P = pat.length();
		int T = txt.length();

		long ph = createHash(pat.toCharArray(), pat.length());
		
		System.out.println("Ph is "+ph);
		

		long th = createHash(txt.toCharArray(), P);
		System.out.println("Th is "+th);

		for (int i = 1; i < T-P; i++) {

			if (th == ph && checkEqual(pat, txt, i - 1, i + P - 2)) {
				System.out.println("Found at " + (i - 1));
				System.out.println();
				//break;
			} else if (i < T - P+1) {
				System.out.println("old Th is "+th);
				th=recalculateHash(txt.toCharArray(),i-1,i+P-1,th,P);
				System.out.println("new Hash is "+th);
			}

		}
		//System.out.println("Not found");

	}
	private static long recalculateHash(char[] str,int oldIndex, int newIndex,long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash = (long) Math.floor(newHash/prime);
        newHash += str[newIndex]*Math.pow(prime, patternLen - 1);
        return newHash;
    }
	private static boolean checkEqual(String pat, String txt, int start, int end) {

		for (int i = 0; i < pat.length() && start<=end; i++) {
			if (pat.charAt(i) == txt.charAt(start)) {
				start++;
				continue;
			} else
				return false;
		}
		return true;
	}

}
