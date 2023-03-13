
// Technique: Hash the Elements
// Time Complexity: O(n) - traverse the entire array only once, hash the elements to track count and get/put data in O(1)
// Space Complexity: O(n) - created a hashmap with n possible elements
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[] { 1, 10, 8, 3, 2, 5, 7, 2, -2, -1 }, 10));
        System.out.println(twoSum(new int[] { 1, 10, 8, 3, 2, 5, 7, 2, -2, -1 }, 9));
        System.out.println(twoSum(new int[] { 4, 3, 3, 5, 7, 0, 2, 3, 8, 6 }, 6));
        System.out.println(twoSum(new int[] { 4, 3, 3, 5, 7, 0, 2, 3, 8, 6 }, 1));
        System.out.println(twoSum(new int[] { 1, 1, 2, 3, 0 }, 3));
    }

    public static int twoSum(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>(); // to track the number of occurrences of number
        for (int i = 0; i < nums.length; i++) {
            int req = k - nums[i];
            if (map.containsKey(req)) {
                // required number to reach k is found, add # occurrences to number of pairs
                pairs += map.get(req);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return pairs;
    }
}
// Time Taken: 13 mins
