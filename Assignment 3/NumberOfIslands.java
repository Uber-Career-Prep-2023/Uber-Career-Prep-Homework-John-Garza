// Technique: Graph - DFS but BFS also works. Use DFS/BFS to mark visited land as you iterate over the matrix
// Time Complexity: O(N*M) where N = # of rows and M = # of cols
// Space Complexity: O(N*M) since using the recursive stack to traverse the matrix and mark visited land
public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] ex1 = new int[][] { { 1, 0, 1, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0 } };
        System.out.println(numIslands(ex1));

        int[][] ex2 = new int[][] { { 1, 0, 0 }, { 0, 0, 0 } };
        System.out.println(numIslands(ex2));
    }

    public static int numIslands(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    clearConnectingLand(grid, i, j);
                }
            }
        }
        return result;
    }

    public static void clearConnectingLand(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        clearConnectingLand(grid, i + 1, j);
        clearConnectingLand(grid, i - 1, j);
        clearConnectingLand(grid, i, j + 1);
        clearConnectingLand(grid, i, j - 1);
    }
}
// Time Taken: 15 mins
