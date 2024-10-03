package arrays;

public class MinimumSubarrayLength {
    public int minSubArrayLen(int target, int[] nums) {

        int windowStart = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];
            while (sum >= target) {
                min = Math.min(min, windowEnd - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}