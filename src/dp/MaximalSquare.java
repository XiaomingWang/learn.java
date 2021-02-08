package dp;

/**
 * @author xiaoming
 * @since 2.0
 */
public class MaximalSquare {

    int maxSquare(int[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }

        int w = matrix.length;
        int h = matrix[0].length;

        int dp[][] = new int[w + 1][h + 1];
        int max = 0;

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }


    public static void main(String[] args) {

        MaximalSquare solution = new MaximalSquare();
        int[][] matrix = new int[][]{{0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1}};

        System.out.println(solution.maxSquare(matrix));

    }

}
