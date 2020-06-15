package dp;

public class LongestSubsequence {
	
	// driver program to test above functions 
    public static void main(String args[]) 
    { 
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int n = arr.length; 
        System.out.println("Length of lis is "
                           + lis(arr,n) + "\n"); 
    }

	private static int lis(int[] arr,int n) {
		
		
		int t[]=new int[arr.length];
		t[0]=1;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				
				if(arr[i]>arr[j]) {
					if(t[j]+1>t[i]) {
						t[i]=t[j]+1;
					}
				}
			}
		}
		return t[t.length-1];
		
		
	} 
    
}
