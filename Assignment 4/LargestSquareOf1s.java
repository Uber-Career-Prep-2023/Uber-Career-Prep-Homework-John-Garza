// Technique: Dynamic Programming
// Time: O(m * n)
// Space: O(m * n) 
public class LargestSquareOf1s {
    public static void main(String[] args) {
        int[][] grid1 = {
                { 0, 1, 0, 1 },
                { 0, 0, 1, 1 },
                { 0, 1, 1, 1 },
                { 0, 0, 1, 1 }
        };
        largestSquareOf1s(grid1);
        System.out.println();
        int[][] grid2 = {
                { 0, 1, 0, 1, 1 },
                { 0, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 1, 0, 0 }
        };
        largestSquareOf1s(grid2);
    }

    public static void largestSquareOf1s(int[][] grid) {
        if (grid == null) {
            return;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = grid[i][0];
        for (int j = 0; j < n; j++)
            dp[0][j] = grid[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxdp = dp[0][0], maxI = 0, maxJ = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maxdp < dp[i][j]) {
                    maxdp = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        for (int i = maxI; i > maxI - maxdp; i--) {
            for (int j = maxJ; j > maxJ - maxdp; j--) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// Time Taken: 44 mins