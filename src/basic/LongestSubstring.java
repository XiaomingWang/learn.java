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

    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int max = 0;
        int j = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (set.contains(c)) {
                while (j < i) {
                    if (s.charAt(j) != c) {
                        set.remove(s.charAt(j));
                        j++;
                    } else {
                        j++;
                        break;
                    }
                }
            }

            set.add(c);
            max = Math.max(set.size(), max);
        }

        return max;

    }

    public static void main(String[] args) {
        // String s = "ecdsfkcnag1dd";
        String s = "aabbcc";

        LongestSubstring solution = new LongestSubstring();
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("The longest substring length is " + length);
    }
}
