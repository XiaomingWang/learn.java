package basic;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1：
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * @authtor Xiaoming Wang
 */
public class Palindrome {


    public boolean isPalindrome(String str) {
        if (str.length() < 1) {
            return true;
        }
        int n = str.length();
        int i = 0, j = n - 1;
        while (j > i) {
            char c1 = str.charAt(i);
            while (!isAlphaNumberic(c1) && i < j) {
                i++;
                c1 = str.charAt(i);
            }
            c1 = toLowercase(c1);
            char c2 = str.charAt(j);
            while (!isAlphaNumberic(c2) && i < j) {
                j--;
                c2 = str.charAt(j);
            }

            c2 = toLowercase(c2);
            if (c1 != c2) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    boolean isAlphaNumberic(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    char toLowercase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ('a' + c - 'A');
        }
        return c;
    }


    public static void main(String[] args) {
        // String s = "A man, a plan, a canal: Panama";
        // String s = "race a car";
        String s = " 1 ";
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(s));
    }


}
