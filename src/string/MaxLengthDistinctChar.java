package string;

public class MaxLengthDistinctChar {

	public static void main(String[] args) {
		 String str = "geeksforgeeks"; 
	        System.out.println("The input string is " + str); 
	        int len = longestUniqueSubsttr(str); 
	        System.out.println("The length of "
	                           + "the longest non repeating character is " + len); 
	}

	private static int longestUniqueSubsttr(String str) {
		
		int visited[]=new int[300];
		int max_len=Integer.MIN_VALUE;
		int cur_len=0;
		int i=0;
		StringBuilder rs=new StringBuilder();
		char []in=str.toCharArray();
		for ( i=0;i<visited.length;i++) {
			visited[i]=-1;
		}
		i=0;
		visited[in[0]]=0;
		 for (i = 1; i < in.length; i++) { 
	            
			 int prev_index = visited[in[i]]; 
			 System.out.println("char is "+str.charAt(i)+" previndex "+(prev_index));
	  
	            /* If the current character is not present in 
	           the already processed substring or it is not 
	              part of the current NRCS, then do cur_len++ */
			 System.out.println("curlen->"+cur_len+"<-->i-> "+i);
	            if (prev_index == -1 || i - cur_len > prev_index) 
	                {
	            		cur_len++;
	            		System.out.println("char not found and new curlen is "+cur_len);
	                }
	  
	            /* If the current character is present in currently 
	               considered NRCS, then update NRCS to start from 
	               the next character of the previous instance. */
	            else { 
	                /* Also, when we are changing the NRCS, we 
	                   should also check whether length of the 
	                   previous NRCS was greater than max_len or 
	                   not.*/
	                if (cur_len > max_len) 
	                    max_len = cur_len; 
	  
	                cur_len = i - prev_index; 
	            } 
	  
	            // update the index of current character 
	            visited[str.charAt(i)] = i; 
	            System.out.println("Max len"+max_len);
	            System.out.println();
	        } 
	
		return max_len;
	}
}
