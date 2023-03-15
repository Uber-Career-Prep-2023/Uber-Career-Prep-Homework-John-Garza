
// Technique: Growing/Shrinking Sliding window
// Time Complexity: O(n) - iterate through the entire array only once with two pointers
// Space Complexity: O(n) - Created hashmaps to track the counts of the characters in the window and the pattern
import java.util.*;

public class ShortestSubstring {
    public static void main(String[] args) {
        System.out.println(shortestSubstring("abracadabra", "abc"));
        System.out.println(shortestSubstring("zxycbaabcdwxyzzxwdcbxyzabccbazyx", "zzyzx"));
        System.out.println(shortestSubstring("dog", "god"));
        System.out.println(shortestSubstring("abc", "def"));
    }

    public static int shortestSubstring(String s1, String pattern) {
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> requiredMap = new HashMap<>();

        for (char c : pattern.toCharArray())
            requiredMap.put(c, requiredMap.getOrDefault(c, 0) + 1);

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int targetCount = 0; // to track the correct characters in the pattern

        for (int right = 0; right < s1.length(); right++) {
            // add current character to the windowMap
            char r = s1.charAt(right);
            windowMap.put(r, windowMap.getOrDefault(r, 0) + 1);
            if (requiredMap.containsKey(r) && windowMap.get(r) == requiredMap.get(r))
                targetCount++;

            // shrink window while all required characters are in the window
            while (targetCount == requiredMap.size()) {
                minLen = Math.min(minLen, right - left + 1); // compare minLen with the current window size
                char l = s1.charAt(left);
                // decrease window
                windowMap.put(l, windowMap.get(l) - 1);
                if (requiredMap.containsKey(l) && windowMap.get(l) < requiredMap.get(l))
                    targetCount--;

                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen; // return -1 if no substring found
    }
}
// Time Taken: 37 mins
