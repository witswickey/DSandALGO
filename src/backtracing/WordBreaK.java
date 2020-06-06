package backtracing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreaK {

	// set to hold dictionary values 
    private static Set<String> dictionary = new HashSet<>(); 
	public static void main(String[] args) {
		
		// array of strings to be added in dictionary set. 
        String temp_dictionary[] = {"mobile","samsung","sam","sung",  
                            "man","mango","icecream","and",  
                            "go","i","like","ice","cream"}; 
                              
        // loop to add all strings in dictionary set  
        for (String temp :temp_dictionary) 
        { 
            dictionary.add(temp); 
        } 
        
        wordBreak("ilikelikeimangoiii"); 
          
        // sample input cases 
         //wordBreak("ilikesamsung"); 
         /*wordBreak("iiiiiiii"); 
         wordBreak(""); 
        
         wordBreak("samsungandmango"); 
         wordBreak("samsungandmangok"); */
          
	}
	private static void wordBreak(String string) {
		
		int len=string.length();
		
		//List<String> result=new LinkedList<String>();
		
		String result=" ";
		wordBreakUtil(string,len,result);
		
		//print(result);
		System.out.println();
		
	}
	private static void wordBreakUtil(String string,int n,String result) {
		  for (int i=1; i<=
				  n; i++) 
		    { 
		        //extract substring from 0 to i in prefix 
		        String prefix = string.substring(0, i); 
		  
		        // if dictionary conatins this prefix, then 
		        // we check for remaining string. Otherwise 
		        // we ignore this prefix (there is no else for 
		        // this if) and try next 
		        if (dictionary.contains(prefix)) 
		        { 
		            // if no more elements are there, print it 
		            if (i == n) 
		            { 
		                // add this element to previous prefix 
		                result+=prefix; 
		                print(result); 
		                return; 
		            } 
		            //result.add(prefix+" ");
		            wordBreakUtil(string.substring(i,n), n-i, 
		                                result+prefix+" "); 
		        } 
		    }      //end for 
		}//end function 
	private static void print(String result) {
		// TODO Auto-generated method stub
		System.out.println(result);
	}
}













