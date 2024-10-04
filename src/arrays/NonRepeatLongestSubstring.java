package arrays;

import java.util.HashSet;

public class NonRepeatLongestSubstring {
    public static int nonRepeatLongestSubstring(char[] fruits) {
        HashSet<Character> map = new HashSet<>();
        int start = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int end = 0; end < fruits.length; end++) {

            while (map.contains(fruits[end]) ) {
               map.remove(fruits[start]);
               start++;

            }
            map.add(fruits[end]);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;

    }

    public static void main(String[] args) {
        String str = "aabccbb";


        System.out.println(nonRepeatLongestSubstring(str.toCharArray()));


    }
}
