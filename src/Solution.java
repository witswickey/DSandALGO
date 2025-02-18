import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    public static void filMapAgain(HashMap map, char[] patr) {
        for (int i = 0; i < patr.length; i++) {
            map.put(patr[i], map.getOrDefault(patr[i] + 1, 1));
        }
    }

    static int search(String txt, String pat) {

        int end = 0, start = 0;

        char[] text = txt.toCharArray();
        char[] patr = pat.toCharArray();

        HashMap<Character, Integer> map1 = new HashMap<>();

        HashMap<Character, Integer> map2 = new HashMap<>();

        filMapAgain(map1, patr);

        int k = patr.length, count = 0;

        while (end < text.length) {
            if (map1.containsKey(text[end])) {
                map2.put(text[end], map2.getOrDefault(text[end] + 1, 1));
            }
            if (end - start + 1 == k) {
                if (checkcontent(map1, map2)) {
                    count++;
                }
                if (map2.containsKey(text[start])) {
                    map2.put(text[start], map2.get(text[start]) - 1);
                    if (map2.get(text[start]) == 0) {
                        map2.remove(text[start]);
                    }
                }
                start++;
            }
            end++;
        }

        return count;
    }

    private static boolean checkcontent(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {

        AtomicBoolean flag = new AtomicBoolean(true);
        map2.forEach((key, value) -> {
            if (!(map1.containsKey(key) && map1.get(key) == value)) {
                flag.set(false);
            }
        });
        return flag.get();
    }

    public static void main(String[] args) {

        System.out.println(search("forxxorfxdofr", "for"));
    }

}