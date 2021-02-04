package dp;

/**
 * @author xiaoming
 * @since 2.0
 */
public class MinDistance {

    int solution(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        int m = str1.length(), n = str2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int minStep = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = minStep + 1;
                }

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "HelloWorld", word2 = "111word111";
        MinDistance resolution = new MinDistance();

        int distance = resolution.solution(word1, word2);
        System.out.println(distance);

    }


}
