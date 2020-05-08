package queue;

public class PetrolProb {

	static class ptrolpump{
		int petrol;
		int distance;
		public ptrolpump(int pt,int dis) {
			this.petrol=pt;
			this.distance=dis;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// {4, 6}, {6, 5}, {7, 3} and {4, 5}
		ptrolpump[] arr = { new ptrolpump(4, 6), new ptrolpump(6, 5), new ptrolpump(7, 3),new ptrolpump(4, 5) };

		int start = printTour(arr, arr.length);

		System.out.println(start == -1 ? "No Solution" : "Start = " + start);
	}
	private static int printTour(ptrolpump[] arr, int length) {
		
		int diff=0,start=0,sum=0;
		for(int i=0;i<arr.length;i++) {
			
			sum+=arr[i].petrol-arr[i].distance;
			
			if(sum<0) {
				start=i+1;
				diff+=sum;
				sum=0;
			}
		}
		return sum+diff>0?start:-1;
		
	}

}
