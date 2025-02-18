package arrays.slidingwindows;

import java.util.Arrays;

public class MaxAvgSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        double sum=0;
        int c=0;
        double result[]=new double[nums.length-k+1];

        for(int window=0;window<nums.length;window++){
            sum+=nums[window];
            if(window>=k-1){
                result[c]=sum/k;
                sum-=nums[c];
                System.out.println(result[c]);
                c++;
            }

        }
        return (double)Arrays.stream(result).max().orElse(nums[0]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
    }
}