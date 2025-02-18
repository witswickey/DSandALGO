package arrays.slidingwindows;

public class MinimumSubarrayLength {


    public static int minSubArrayLen(int target, int[] nums) {

        long sum = 0;
        int start = 0;
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length;) {
            while (sum >= target) {
                if (sum == target && (minlen > (i - start ))) {
                    minlen = i - start;
                }
                sum -= nums[start];
                start++;
            }
            sum += nums[i++];

        }
        //System.out.println(minlen);
        return Math.max(minlen, 0);

    }

    public int minSubArrayLen1(int target, int[] nums) {

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

    public static void main(String[] args) {
        int[] arr={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,arr));

    }
}