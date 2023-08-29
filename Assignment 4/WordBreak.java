
// Technique: DP - Tabulation
// Time: O(n * m * k) where n is length of s, m is length of wordDict, and k is average length of words in wordDict
// Space: O(n) where n is length of dp array
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i] == true)
                    break;
            }
        }
        return dp[0];
    }
}
// Time Taken: 20 mins