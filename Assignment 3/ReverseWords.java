
// Technique: Stack to add them in and pop them in reversed order
// Time Complexity: O(N) where N is the number of words separated by spaces
// Space Complexity: O(N) since created a stack 
import java.util.*;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("Uber Career Prep"));
        System.out.println(reverseWords("Emma lives in Brooklyn, New York."));
    }

    public static String reverseWords(String s) {
        String split[] = s.split(" ");
        Stack<String> stack = new Stack<>();

        for (String word : split) {
            stack.push(word);
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(stack.pop() + " ");
        }
        sb.append(stack.pop());
        return sb.toString();
    }
}
// Time Taken: 7 mins
