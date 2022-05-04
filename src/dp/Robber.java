package dp;

/**
 * @author xiaoming
 * @since 2.0
 */
public class Robber {

    int rob(int[] rooms) {
        int m = rooms.length;
        if (m <= 0) {
            return 0;
        }
        int[] dp = new int[m];
        dp[0] = rooms[0];
        if (m <= 1) {
            return rooms[0];
        }
        dp[1] = Math.max(dp[0], rooms[1]);
        for (int i = 2; i < m; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + rooms[i]);
        }

        return dp[m - 1];
    }

    public static void main(String... args) {
        int[] room = new int[]{3, 1, 5, 1, 3, 7, 8, 3};
        Robber robber = new Robber();
        int total = robber.rob(room);
        System.out.println(total);
    }
}
