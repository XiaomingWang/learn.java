package basic;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        dfs("", 0, 0, n, ans);

        return ans;
    }

    void dfs(String curString, int left, int right, int n, List<String> ans) {
        if (left == n && right == n) {
            ans.add(curString);
            return;
        }

        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(curString + "(", left + 1, right, n, ans);
        }
        if (right < n) {
            dfs(curString + ")", left, right + 1, n, ans);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        GenerateParenthesis solution = new GenerateParenthesis();
        List<String> ans = solution.generateParenthesis(n);
        System.out.println(ans.size());

    }


}
