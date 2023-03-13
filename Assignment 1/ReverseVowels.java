
// Technique: Forward/Backward Two Pointer
// Time Complexity: O(n) - Used HashSet with vowels to compare in O(1) time and iterate over the array once by comparing with two pointers
// Space Complexity: O(n) - Created an char array with the original characters and returned a new string at the end
import java.util.*;

public class ReverseVowels {
    public static void main(String[] args) {
        String ucp = "Uber Career Prep";
        System.out.println("Input String: " + ucp);
        System.out.println("Modified String: " + reverseVowel(ucp));
        System.out.println();

        String xyz = "xyz";
        System.out.println("Input String: " + xyz);
        System.out.println("Modified String: " + reverseVowel(xyz));
        System.out.println();

        String flamingo = "flamingo";
        System.out.println("Input String: " + flamingo);
        System.out.println("Modified String: " + reverseVowel(flamingo));
    }

    public static String reverseVowel(String str) {
        // Assumption: String is not null
        Set<Character> vowels = new HashSet<>(
                Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' }));
        char[] strArr = str.toCharArray();
        int l = 0, r = strArr.length - 1;
        while (l < r) {
            if (vowels.contains(strArr[l]) && vowels.contains(strArr[r])) {
                // swap the two
                char temp = strArr[l];
                strArr[l++] = strArr[r];
                strArr[r--] = temp;
            } else {
                if (!vowels.contains(strArr[l]))
                    l++;
                if (!vowels.contains(strArr[r]))
                    r--;
            }
        }
        return new String(strArr);
    }
}
// Time Taken: 10 mins
