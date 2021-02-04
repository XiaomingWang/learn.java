package dp;

/**
 * @author xiaoming
 * @since 2.0
 */
public class MaximumSubarray {


    public int maxSubarray(int[] array) {
        int m = array.length;
        if (m <= 0) {
            return 0;
        }
        int dp[] = new int[m];

        dp[0] = array[0];
        int max = dp[0];

        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] data = new int[]{-1, 2, 3, 1, -1, -3, 7};
        MaximumSubarray solution = new MaximumSubarray();
        int maxValue = solution.maxSubarray(data);
        System.out.println(maxValue);
    }

}
