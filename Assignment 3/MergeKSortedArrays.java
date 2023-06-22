import java.util.*;

// Technique: Heap Sort - use a minHeap to add values and pop off
// Time Complexity: O(N * log K) where N is the number of total elements and k is the amount of arrays
// Space Complexity: O(N)
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int k1 = 2;
        int[][] arrays1 = { { 1, 2, 3, 4, 5 }, { 1, 3, 5, 7, 9 } };
        int[] res1 = mergeKSortedArr(k1, arrays1);
        System.out.print("[");
        for (int num : res1)
            System.out.print(num + ", ");
        System.out.println("]");

        int k2 = 3;
        int[][] arrays2 = { { 1, 4, 7, 9 }, { 2, 6, 7, 10, 11, 13, 15 }, { 3, 8, 12, 13, 16 } };
        int[] res2 = mergeKSortedArr(k2, arrays2);
        System.out.print("[");
        for (int num : res2)
            System.out.print(num + ", ");
        System.out.println("]");

    }

    public static int[] mergeKSortedArr(int k, int[][] arrays) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                pq.offer(arrays[i][j]);
            }
        }
        int size = pq.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
// Time Taken: