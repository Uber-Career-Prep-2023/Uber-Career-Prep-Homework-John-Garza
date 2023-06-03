
// Technique: Queue to store the future numbers
// Time Complexity: O(k) where k is the number of binary strings to be output
// Space Complexity: O(k) since creating queue
import java.util.*;

public class FirstKBinaryNumbers {
    public static void main(String[] args) {
        String[] ex1 = firstKBinary(5);
        for (String s : ex1) {
            System.out.print(s + ", ");
        }
        System.out.println();

        String[] ex2 = firstKBinary(10);
        for (String s : ex2) {
            System.out.print(s + ", ");
        }

    }

    public static String[] firstKBinary(int k) {
        int len = k;
        if (len <= 0) {
            return null;
        }
        String[] result = new String[len];
        Queue<String> queue = new LinkedList<>();

        result[0] = "0";
        queue.offer("1");

        while (--k > 0) {
            String s1 = queue.poll();
            result[len - k] = s1;

            String s2 = s1;
            queue.offer(s1 + "0");
            queue.offer(s2 + "1");
        }

        return result;
    }
}
// Time Taken: ~30 mins
