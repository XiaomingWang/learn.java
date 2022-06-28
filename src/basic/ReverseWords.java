package basic;


/**
 *
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) return s;
        StringBuffer sb = new StringBuffer();

        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')) {
                if (len == 0 && sb.length() > 0) {
                    sb.insert(0,' ');
                }
                sb.insert(len, c);
                len++;
            } else {
                len = 0;
            }

        }

        return sb.toString();
    }

    public String reverseWords_1(String s) {
        if (s == null || s.length() < 1) return s;
        String[] words = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer("");
        for (int i = words.length; i > 0; i--) {
            if (words[i - 1].equals("")) continue;
            sb.append(words[i - 1]);
            if (i > 1) {
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords solution = new ReverseWords();

        String s = "   a good   example ";
        String ans = solution.reverseWords(s);
        System.out.println(ans);

        s = "  hello world  ";
        ans = solution.reverseWords(s);
        System.out.println(ans);
        s = "  123231112 332  ";
        ans = solution.reverseWords_1(s);
        System.out.println(ans);
        s = "  1  2 3 ";
        ans = solution.reverseWords(s);
        System.out.println(ans);

    }

}
