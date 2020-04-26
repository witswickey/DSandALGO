package arrays;

import java.util.Scanner;

public class LargestSub {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(maxLen(arr));

	}
	static int maxLen(int[] arr) {
        int i=0,j=0;
        int count=0;
    for (;i<arr.length;i++){
        if (arr[i]==0){
            count+=1;
        }
        else{
            count-=1;
        }
        if(count==0){
        	System.out.println("count "+count);
            j+=2;
        }
    }
    if (j==0)
        return 2;
    else
        return j;
    }   
}
