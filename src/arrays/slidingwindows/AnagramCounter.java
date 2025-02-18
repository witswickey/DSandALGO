package arrays.slidingwindows;

import java.util.HashMap;

public class AnagramCounter {
    // Function to find if two strings are anagrams
    public static boolean areAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Increment frequency of characters in s1
        for (char c : s1.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        // Decrement frequency of characters in s2
        for (char c : s2.toCharArray()) {
            if (!freqMap.containsKey(c) || freqMap.get(c) == 0)
                return false;
            freqMap.put(c, freqMap.get(c) - 1);
        }

        return true;
    }

    // Function to count occurrences of anagrams of word in text
    public static int countAnagrams(String text, String word) {
        int res = 0;
        int wordLength = word.length();
        int textLength = text.length();

        for (int i = 0; i <= textLength - wordLength; ++i) {
            String sub = text.substring(i, i + wordLength);
            if (areAnagram(sub, word))
                res++;
        }

        return res;
    }

    // Driver code
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";

        System.out.println(countAnagrams(text, word));
    }
}
