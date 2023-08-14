// Technique: Dynamic Programming
// Time Complexity: O(n) where n is the size of cost array
// Space Complexity: O(1)
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost1 = { 4, 1, 6, 3, 5, 8 };
        System.out.println(minCostClimbingStairs(cost1));
        int[] cost2 = { 11, 8, 3, 4, 9, 13, 10 };
        System.out.println(minCostClimbingStairs(cost2));
        int[] cost3 = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost3));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];

        int n = cost.length;
        if (n <= 2)
            return Math.min(first, second);

        for (int i = 2; i < n; i++) {
            int cur = cost[i] + Math.min(first, second);
            first = second;
            second = cur;
        }
        return Math.min(first, second);
    }
}
// Time Taken: 30 mins