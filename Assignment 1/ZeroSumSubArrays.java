
// Technique: One directional computation/total
// Time Complexity: O(n) - Iterated over array once to find the overall result
// Space Complexity: O(n) - Created a hashmap with n elements
import java.util.*;

public class ZeroSumSubArrays {
    public static void main(String[] args) {
        System.out.println(zeroSumArrays(new int[] { 4, 5, 2, -1, -3, -3, 4, 6, -7 })); // expected output: 2
        System.out.println(zeroSumArrays(new int[] { 1, 8, 7, 3, 11, 9 })); // expected output: 0
        System.out.println(zeroSumArrays(new int[] { 8, -5, 0, -2, 3, -4 })); // expected output: 2
        System.out.println(zeroSumArrays(new int[] { 0, 0, 0 })); // expected output: 6
    }

    public static int zeroSumArrays(int[] nums) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // to track the sum at current index and number of occurrences
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum))
                res += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
// Time Taken: 24 mins
