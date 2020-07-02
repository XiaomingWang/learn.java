package basic;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        Set<Character> occ = new HashSet<>();
        int longest = 0;
        int rPos = 0;
        for(int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            if(i != 0) {
                occ.remove(s.charAt(i-1));
            }
            while(rPos < len && !occ.contains(s.charAt(rPos))){
                occ.add(s.charAt(rPos));
                rPos++;
            }
            longest = Math.max(longest, occ.size());
        }

        return longest;
    }

    public static void main(String[] args) {
        String s = "ecdsfkcnag1dd";

        LongestSubstring solution = new LongestSubstring();
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("The longest substring length is " + length);
    }
}
