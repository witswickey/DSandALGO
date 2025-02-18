package arrays;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class TripeltToZero {

    public static List<List<Integer>> TripeltToZero(int[] fruits) {
        Arrays.sort(fruits);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i] == fruits[i - 1]) {
                searchPair(-fruits[i], fruits, i, res);
            } else {
                searchPair(-fruits[i - 1], fruits, i - 1, res);
            }

        }
        return res;
    }

    private static void searchPair(int targetSum, int[] fruits, int loc, List<List<Integer>> res) {

        int left = loc + 1;
        int right = fruits.length - 1;
        while (left < right) {
            if (fruits[left] + fruits[right] == targetSum) {
                List<Integer> li = new ArrayList<>();
                li.add(fruits[left]);
                li.add(fruits[loc]);
                li.add(fruits[right]);
                res.add(li);
            }
            if(left<fruits.length-2 && fruits[left]==fruits[left+1]){
                left++;
            }
            if (fruits[left] + fruits[right] < targetSum) {
                left++;
            }
            if (fruits[left] + fruits[right] > targetSum) {
                right--;
            }
            left++;
        }

    }

    public static void main(String[] args) {
        int[] fruit = {-5, 2, -1, -2, 3};

        int[] fruit1 = {-3, 0, 1, 2, -1, 1, -2};


        System.out.println(TripeltToZero(fruit));
        System.out.println(TripeltToZero(fruit1));


    }
}
