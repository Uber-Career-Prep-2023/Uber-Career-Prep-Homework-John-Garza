
// Technique: Dynamic Programming
// Time Complexity: O(n * m) where n is the # coins and m is sum
// Space Complexity: O(m) where m is sum 
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coin1 = { 2, 5, 10 };
        System.out.println(coinChange(coin1, 20));
        System.out.println(coinChange(coin1, 15));
    }

    public static int coinChange(int[] coins, int sum) {
        if (sum < 0 || coins.length == 0 || coins == null) {
            return 0;
        }
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[sum];
    }
}
// Time Taken: 43 mins