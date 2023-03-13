// Technique: Fixed-size sliding window
// Time Complexity: O(n) - Iterates over the array once to find the sum of all numbers, then once to find the maxMean so O(2n) = O(n)
// Space Complexity: O(1) - Only created variables to track indices, sum, and mean so O(1) 
public class MaxMeanSubArray {
    // Assumption: k <= nums.length
    public static void main(String[] args) {
        int[] arr1 = new int[] { 4, 5, -3, 2, 6, 1 };
        int[] arr2 = new int[] { 1, 1, 1, 1, -1, -1, 2, -1, -1 };
        int[] arr3 = new int[] { 1, 1, 1, 1, -1, -1, 2, -1, -1, 6 };

        System.out.println("Test 1: " + meanSubArray(arr1, 2)); // expected output: 4.5
        System.out.println("Test 2: " + meanSubArray(arr1, 3)); // expected output: 3
        System.out.println("Test 3: " + meanSubArray(arr2, 3)); // expected output: 1
        System.out.println("Test 4: " + meanSubArray(arr3, 5)); // expected output: 1
    }

    public static double meanSubArray(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxMean = sum / k;

        for (int l = 0, r = k; r < nums.length; l++, r++) {
            sum += (nums[r] - nums[l]);
            maxMean = Math.max(maxMean, sum / k);
        }
        return maxMean;
    }
}
// Time taken for solution : ~18 mins
