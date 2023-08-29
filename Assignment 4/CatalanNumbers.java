// Technique: Dynamic Programming - Memoization
// Time: O(n^2) since we are finding the nth catalan numbers n times
// Space: O(n)
public class CatalanNumbers {
    static int[] dp;

    public static void main(String[] args) {
        int[] ex1 = catalanNumbers(1);
        System.out.println("EXAMPLE 1");
        for (int num : ex1) {
            System.out.print(num + " ");
        }
        int[] ex2 = catalanNumbers(5);
        System.out.println("\nEXAMPLE 2");
        for (int num : ex2) {
            System.out.print(num + " ");
        }

    }

    public static int[] catalanNumbers(int num) {
        dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        solve(num);
        return dp;
    }

    public static int solve(int num) {
        if (num <= 1)
            return 1;
        if (dp[num] != 0)
            return dp[num];

        int nthCatlan = 0;
        for (int i = 0; i < num; i++) {
            nthCatlan += solve(i) * solve(num - i - 1);
        }
        dp[num] = nthCatlan;
        return dp[num];
    }

    public static int retreiveFactorial(int num, int[] factorials) {
        if (factorials[num] == 0)
            factorials[num] = num * retreiveFactorial(num - 1, factorials);
        return factorials[num];
    }
}
// Time Taken: 40 mins