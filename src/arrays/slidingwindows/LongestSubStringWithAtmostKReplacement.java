package arrays.slidingwindows;

public class LongestSubStringWithAtmostKReplacement {

    public static int characterReplacement(String s, int k) {

        int maxfre=Integer.MIN_VALUE,start=0;
        int charindex[]=new int[200];
        int maxlength=Integer.MIN_VALUE;

        for(int end=0;end<s.length();end++){

            charindex[s.charAt(end)-'A']++;

            maxfre=Math.max(maxfre,charindex[s.charAt(end)-'A']);

            if((end-start+1)-maxfre>k){
                charindex[s.charAt(start)-'A']--;
                start++;
            }
            maxlength=Math.max(maxlength,end-start+1);

        }
        return maxlength == Integer.MIN_VALUE ? 0 : maxlength;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
        //System.out.println(characterReplacement(str, K));


    }
}
