
// Technique: Hash the Elements
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.util.*;

public class KAnagrams {
    public static void main(String[] args) {
        System.out.println(kAnagrams("apple", "peach", 1));
        System.out.println(kAnagrams("apple", "peach", 2));
        System.out.println(kAnagrams("cat", "dog", 3));
        System.out.println(kAnagrams("debit curd", "bad credit", 1));
        System.out.println(kAnagrams("baseball", "basketball", 2));
        System.out.println(kAnagrams("car", "flag", 20)); // false since different lengths
    }

    public static boolean kAnagrams(String s1, String s2, int k) {
        // ASSUMPTION: changing characters means substituting them, not adding/removing
        if (s1.length() != s2.length())
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int diffCount = 0; // to track differences that need to be changed

        // track character counts in each string
        for (Character c : s1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (Character c : s2.toCharArray())
            map2.put(c, map2.getOrDefault(c, 0) + 1);

        for (Character c : map1.keySet()) {
            if (!map2.containsKey(c))
                // s2 is missing a character so add count of that character
                diffCount += map1.get(c);
            else if (map1.get(c) != map2.get(c))
                // add the difference in the two characters as needed changes
                diffCount += Math.abs(map1.get(c) - map2.get(c));

            if (diffCount > k) // more than K changes needed
                return false;
        }
        return true;
    }
}
// Time Taken: 23 mins
