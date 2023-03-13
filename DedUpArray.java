// Technique: Growing/Shrinking Sliding Window
// Time Complexity: O(n) - traverses the entire array only once, modifying as it traverses
// Space Complexity: O(1) - modifies the array in place
public class DedUpArray {
    public static void main(String[] args) {
        int[] test1 = dedUpArray(new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 });
        System.out.print("[ ");
        for (int n : test1)
            System.out.print(n + ", ");
        System.out.println("]\n");

        int[] test2 = dedUpArray(new int[] { 0, 0, 1, 4, 5, 5, 5, 8, 9, 9, 10, 11, 15, 15 });
        System.out.print("[ ");
        for (int n : test2)
            System.out.print(n + ", ");
        System.out.println("]\n");

        int[] test3 = dedUpArray(new int[] { 1, 3, 4, 8, 10, 12 });
        System.out.print("[ ");
        for (int n : test3)
            System.out.print(n + ", ");
        System.out.println("]\n");

        int[] test4 = dedUpArray(new int[] { 5 });
        System.out.print("[ ");
        for (int n : test4)
            System.out.print(n + ", ");
        System.out.println("]\n");

        int[] test5 = dedUpArray(new int[] { 2, 2 });
        System.out.print("[ ");
        for (int n : test5)
            System.out.print(n + ", ");
        System.out.println("]\n");
    }

    public static int[] dedUpArray(int[] nums) {
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[l] != nums[r])
                // nums not equal so this moves the unique elements to front and -1s back
                nums[++l] = nums[r];

            if (l != r)
                // indices arent same so duplicate been found
                nums[r] = -1;
            r++;
        }
        return nums;
    }
}
// Time Taken: 27 mins
