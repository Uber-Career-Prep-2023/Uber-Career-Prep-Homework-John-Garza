// Technique: Two Strings two-pointer
// Time Complexity: O(n) -  traverses each input string once
// Space Complexity: O(n) - uses stack to push and pop in O(1) time
import java.util.*;
public class BackspaceStringCompare {
    public static void main(String[] args) {
        // Test the given examples
        System.out.println("COMPARE: abcde, abcde");
        System.out.println(backspaceStringCompare("abcde", "abcde"));
        System.out.println("COMPARE: Uber Career Prep, u#Uber Careee#r Prep");
        System.out.println(backspaceStringCompare("Uber Career Prep", "u#Uber Careee#r Prep"));
        System.out.println("COMPARE: abcdef###xyz, abcw#xyz");
        System.out.println(backspaceStringCompare("abcdef###xyz", "abcw#xyz"));
        System.out.println("COMPARE: abcdef###xyz, abcdefxyz###");
        System.out.println(backspaceStringCompare("abcdef###xyz", "abcdefxyz###"));

        // Test more backspaces than characters
        System.out.println("COMPARE: abc#### , abc###");
        System.out.println(backspaceStringCompare("abc####", "abc###"));
    }

    public static boolean backspaceStringCompare(String s1, String s2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '#') {
                if (stack1.size() > 0)
                    stack1.pop();
            } 
            else stack1.push(s1.charAt(i));
        }
        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) == '#') {
                if (stack2.size() > 0)
                    stack2.pop();
            } 
            else stack2.push(s2.charAt(j));
        }
        return String.valueOf(stack1).equals(String.valueOf(stack2));
    }
}
// Time Taken: 17.5 mins
