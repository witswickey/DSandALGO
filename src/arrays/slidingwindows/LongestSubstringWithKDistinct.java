package arrays.slidingwindows;

import java.util.HashMap;

public class LongestSubstringWithKDistinct {
    public static int findLength(String str, int k) {

        char arr[] = str.toCharArray();
        int length = arr.length;

        int start = 0;
        int maxLength = Integer.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();


        for (int end = 0; end < length; end++) {

            if (!map.containsKey(arr[end])) {
                map.put(arr[end], 1);
            }
            while (map.size() > k) {

                map.remove(arr[start]);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        String str = "cbbebi";
        int K = 3;


        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength(str, K));


    }
}
