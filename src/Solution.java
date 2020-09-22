import java.util.ArrayList;
import java.util.List;

class Solution {
	// static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int nums[] = { 1, 5, 11, 5 };

		boolean rs = new Solution().canPartition(nums);
		System.out.println(rs);
		
	}

	public boolean canPartition(int[] nums) {

		int rs = sum(nums, 0, nums.length);
		if ((rs) % 2 != 0) {
			return false;
		}
		boolean used[] = new boolean[nums.length];
		return PartUtilDP(nums, rs / 2);

	}

	public static int sum(int[] nums, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += nums[i];
		}
		return sum;
	}

	public boolean PartUtilDP(int[] nums, int sum) {

		
		boolean[][] dp=new boolean[nums.length+1][sum+1];
		dp[0][0]=true;
		for(int i=1;i<dp.length;i++) {
			dp[i][0]=true;
		}
		for(int i=1;i<dp[0].length;i++) {
			dp[0][i]=false;
		}
		
		for(int i=1;i<dp.length;i++)
		{
			int ele=nums[i-1];
			for(int j=1;j<dp[0].length;j++) {
				if(ele>j)
				{
					dp[i][j]=dp[i-1][j];
				}
				else {
					dp[i][j]=dp[i-1][j] || dp[i-1][j-ele];
				}
			}
		}
		return dp[nums.length][sum];
	}
	
	public boolean PartUtil(int[] nums, int N, int sum) {

		if(N<0) {
			return false;
		}
		else if(sum==0)
			return true;
		else if(sum<0) {
			return false;
		}
		else
			return PartUtil(nums,N-1,sum-nums[N-1]) ||PartUtil(nums,N-1,sum);
	}

}