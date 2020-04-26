package arrays;

public class KadanesAlgo {

	public static void main(String[] args) 
    { 
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
    int n = a.length;    
    int max_sum = maxSubArraySum(a, n); 
    System.out.println("Maximum contiguous sum is " 
                       + max_sum); 
    }

	private static int maxSubArraySum(int[] a, int n) {
		
		int max_sofar=0;
		int cur_max=0;
		int start=0,end=0;
		for(int i=0;i<a.length;i++) {
			
			max_sofar+=a[i];
			
			if(max_sofar<0) {
				max_sofar=0;
				start=i+1;
			}
			if(max_sofar>cur_max){
				cur_max=max_sofar;
				end=i;
			}
			
		}
		System.out.println(start+" "+end);
		return cur_max;
	} 

}
