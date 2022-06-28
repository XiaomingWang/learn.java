package basic;


import java.util.HashMap;
import java.util.Map;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * 6. Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class MyAtoi {


    public int myAtoi(String str) {
        Automation automation = new Automation();
        for (int i = 0; i < str.length(); i++) {
            automation.get(str.charAt(i));
        }
        return (int) (automation.sign * automation.ans);
    }

    public int myAtoi_1(String s) {
        int result = 0;
        boolean isNegative = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (Integer.MAX_VALUE / 10 < result) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else if (Integer.MAX_VALUE / 10 == result) {
                    if (!isNegative && c > '7') {
                        c = '7';
                    } else if (isNegative && c > '8') {
                        c = '8';
                    }
                }
                result = result * 10 + (c - '0');
                ++count;
            } else if (count == 0 && (c == '-' || c == '+')) {
                isNegative = (c == '-');
                count++;
            } else if (c == ' ') {
                continue;
            } else {
                break;
            }
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(-(Integer.MAX_VALUE + 1));
        System.out.println(-Integer.MIN_VALUE);
        MyAtoi solution = new MyAtoi();

        String s = "   +01123";
        int a = solution.myAtoi(s);
        System.out.println(a);
        s = "   +02147483647";
        a = solution.myAtoi(s);
        System.out.println(a);
        s = "   +02147483648";
        a = solution.myAtoi(s);
        System.out.println(a);
        s = "   -00002147483649";
        a = solution.myAtoi(s);
        System.out.println(a);
    }

}

class Automation {

    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {
        {
            put("start", new String[] {"start", "signed", "in_number", "end"});
            put("signed", new String[] {"end", "end", "in_number", "end"});
            put("in_number", new String[] {"end", "end", "in_number", "end"});
            put("end", new String[] {"end", "end", "end", "end"});
        }
    };

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1: -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;

    }

}
