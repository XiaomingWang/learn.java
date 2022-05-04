package dp;

/**
 *
 * @author xiaoming
 * @since 2.0
 */
public class ShortestPath {


    int seek(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? (dp[i][j - 1] + arr[i][j]) : (dp[i - 1][j] + arr[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        ShortestPath resolution = new ShortestPath();
        int[][] paths = new int[][]{{1, 2, 3, 2}, {1, 3, 4, 1}, {3, 1, 5, 3}, {1, 1, 2, 7}};

        int total = resolution.seek(paths);

        System.out.println(total);
    }


}
