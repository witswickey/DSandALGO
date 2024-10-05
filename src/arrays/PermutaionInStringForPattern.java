package arrays;

import java.util.HashMap;

public class PermutaionInStringForPattern {

    public static boolean findLength(String str, String pat) {
        int match = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pat.length(); i++) {
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
        }

        for (int end = 0; end < str.length(); end++) {

            if (map.containsKey(str.charAt(end))) {
                char input=str.charAt(end);
                map.put(input, map.get(input)-1);

                if(map.get(input)==0){
                    match++;
                }

            }

            if(match==map.size()){
                return true;
            }

            if (end - start + 1 >= pat.length()) {
                char left=str.charAt(start);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        match--;
                    }
                    map.put(left, map.get(left +1));
                }
                start++;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        System.out.println(findLength("eidbaooo", "ab"));
        System.out.println(findLength("eidboaoo", "ab"));


    }
}
