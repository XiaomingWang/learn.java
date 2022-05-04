package dp;

/**
 * @author xiaoming
 * @since 2.0
 */
public class CoinChange {

    public int change(int[] coins, int amount) {
        int m = coins.length;
        if (coins.length <= 0 || amount <= 0) {
            return -1;
        }
        // int minCoin = min(coins);
        // int maxCoin = max(coins);
        // if (minCoin > amount) {
        // return -1;
        // }

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] > 0) {
                continue;
            }
            int value = 0;
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i && dp[i - coins[j]] > -1) {
                    value = Math.min(value, dp[i - coins[j]]) + 1;
                }
            }
            if (value > 0) {
                dp[i] = value;
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{2, 4, 3, 8};
        int amount = 11;
        CoinChange solution = new CoinChange();
        int count = solution.change(coins, amount);
        System.out.println(count);
    }

}
