package arrays;

public class OverlappingSubarray {

	public static void main(String[] args) {
		
		//int arr[]={2, 1, 4, 9, 2, 3, 8, 3, 4} ;
		int arr[] = {1, 2, 3, 2, 3, 4, 1} ;
		int k=4;
		calculatelength(arr,arr.length,k);

	}

	private static void calculatelength(int[] arr, int n,int k) {
		
		int count=0;
		int ans=0;
		int flag=0;
		for(int i=0;i<n;) {
			
			while(i<n) {
				if(arr[i]==k)
					flag=1;
				if(arr[i]<=k) {
					//System.out.println("Ele is"+arr[i]);
					count++;
					i++;
				}
				else if(arr[i]>k && flag==1)
				{
					i++;
					ans+=count;
					//System.out.println("count "+count);
					count=0;
					flag=0;
				}
				else {
					count=0;
					i++;
				}
			}
			if(count>0 && flag==1) {
				ans+=count;
			}
			
		}
		System.out.println(" "+ans);
		
	}

}
