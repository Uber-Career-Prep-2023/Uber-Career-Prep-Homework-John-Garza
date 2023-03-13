
// Technique: Sort then solve
// Time Complexity: O(nlogn) - sorted the list of intervals which is O(nlogn) then iterated over the array to merge the intervals so O(nlogn) + O(n) = O(nlogn)
// Space Complexity: O(n) - created a result array and list to keep track of the merged arrays so O(2n) = O(n)
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] test1 = mergeIntervals(new int[][] { { 2, 3 }, { 4, 8 }, { 1, 2 }, { 5, 7 }, { 9, 12 } });
        for (int[] interval : test1)
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        System.out.println();

        int[][] test2 = mergeIntervals(new int[][] { { 5, 8 }, { 6, 10 }, { 2, 4 }, { 3, 6 } });
        for (int[] interval : test2)
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        System.out.println();

        int[][] test3 = mergeIntervals(new int[][] { { 10, 12 }, { 5, 6 }, { 7, 9 }, { 1, 3 } });
        for (int[] interval : test3)
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        // sort based on the start of an interval
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prevInterval = merged.get(merged.size() - 1);
            int[] curInterval = intervals[i];

            if (curInterval[0] <= prevInterval[1])
                // start of next interval overlaps previous interval so merge the two
                merged.get(merged.size() - 1)[1] = Math.max(prevInterval[1], curInterval[1]);
            else
                merged.add(intervals[i]);
        }
        int[][] res = new int[merged.size()][2];
        merged.toArray(res);
        return res;
    }
}
// Time Taken: 30 mins
