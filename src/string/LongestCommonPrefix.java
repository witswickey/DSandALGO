package string;

public class LongestCommonPrefix {
	// Driver program to test above function  
    public static void main(String[] args) { 
        String arr[] = {"geeksforgeeks", "geeks", 
            "geek", "geezer"}; 
        int n = arr.length; 
  
        String ans = commonPrefix(arr, 0, n - 1); 
  
        if (ans.length() != 0) { 
            System.out.println("The longest common prefix is "
                    + ans); 
        } else { 
            System.out.println("There is no common prefix"); 
        } 
    }

	private static String commonPrefix(String[] arr, int i, int j) {
		
		int low=i,high=j;
		int mid=-1;
		 if (low == high) { 
	            return (arr[low]); 
	        } 
		
		if(low<high ) {
			mid=(low+high)/2;
			String str1=commonPrefix(arr, i, mid);
			String str2=commonPrefix(arr, mid+1, high);
			return commonPrefixUtil(str1,str2);
		}
		
		return null;
	}

	private static String commonPrefixUtil( String str1, String str2) {
		String result ="";
		int M=str1.length();
		int N=str2.length();
		for(int i=0,j=0;i<M && j<N;i++,j++) {
			
			if(str1.charAt(i)!=str2.charAt(j)) {
				break;
			}
			result+=str1.charAt(i);
		}
		return result;
		
		
		
	} 
}
