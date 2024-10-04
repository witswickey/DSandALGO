package arrays;

import java.util.HashMap;

public class FruitsInBasket {

    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int end = 0; end < fruits.length; end++) {

            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }

                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        int[] fruit = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};


        System.out.println(totalFruit(fruit));


    }
}
