package dp;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	//static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> permute(int[] nums) {
	   List<List<Integer>> result = new ArrayList<>();
		int start = 0;
		int end = nums.length;
		List<Integer> temp = new ArrayList<Integer>();
		boolean used[] = new boolean[end];

		permuteUtil(nums, temp, used,result);

		return result;

	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		new Permutation().permute(nums);
		//System.out.println(result);
	}

	private void permuteUtil(int[] nums, List<Integer> temp, boolean used[], List<List<Integer>> result) {

		if (temp.size() == nums.length) {
			System.out.println(temp);
			result.add(new ArrayList<Integer>(temp));
			return ;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				temp.add(temp.size(), nums[i]);
				permuteUtil(nums, temp, used,result);
				used[i] = false;
				temp.remove(temp.size() - 1);
				// return result;
			}
		}
		

	}
}