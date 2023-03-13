// Technique: Binary Search Variation
// Time Complexity: O(log(N))
// Space Complexity:O(1)
public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(missingInteger(new int[] { 1, 2, 3, 4, 6, 7 }, 7));
        System.out.println(missingInteger(new int[] { 1 }, 2));
        System.out.println(missingInteger(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12 }, 12));
        System.out.println(missingInteger(new int[] { 1, 2, 3 }, 4));
    }

    public static int missingInteger(int[] nums, int n) {
        if (nums[0] != 1)
            return 1;
        if (nums[nums.length - 1] != n)
            return n;

        int left = 0, right = n - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            // if the offset between the left and mid value is not the same,
            // missing value has to be to left of mid
            if ((nums[left] - left) != (nums[mid] - mid))
                right = mid;
            else
                left = mid;
        }
        // once there are only 2 numbers left in the BS, the missing integer is the one
        // after nums[left]
        return nums[left] + 1;
    }
}
// Time Taken: 24 mins
