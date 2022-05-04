package basic;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 *
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 */
public class Anagram {

    /**
     *
     * Time complexity: O(n)
     * Space complexity: O(S), S = 26
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            table[c - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            table[c - 'a'] -= 1;
            if (table[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = (map.get(c) == null ? 0 : map.get(c));
            map.put(c, count + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = map.get(c) == null ? 0 : map.get(c);
            if (count <= 0) {
                return false;
            }
            map.put(c, count - 1);
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "levis";
        String t = "evils";

        Anagram anagram = new Anagram();

        System.out.println("Result is: " + anagram.isAnagram(s, t));

        t = "river";
        System.out.println("Result is: " + anagram.isAnagram(s, t));

    }

}
