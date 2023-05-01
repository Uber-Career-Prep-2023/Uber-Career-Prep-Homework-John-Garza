// Technique: Generic DFS
// Time Complexity: O(N) - where N is the number of nodes
// Space Complexity: O(h) - where h is the height of the tree. This is due to the recursive stack being used

import java.util.ArrayList;
import java.util.List;

public class LeftView {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Example 1:");
        Node h1 = new Node(7);
        h1.left = new Node(8);
        h1.right = new Node(3);
        h1.right.left = new Node(9);
        h1.right.right = new Node(13);
        h1.right.left.left = new Node(20);
        h1.right.right.left = new Node(14);
        h1.right.right.left.right = new Node(15);
        System.out.println(leftView(h1));

        System.out.println("\nExample 2:");
        Node h2 = new Node(7);
        h2.left = new Node(20);
        h2.right = new Node(4);
        h2.left.left = new Node(15);
        h2.left.right = new Node(6);
        h2.right.left = new Node(8);
        h2.right.right = new Node(11);
        System.out.println(leftView(h2));

    }

    public static List<Integer> leftView(Node head) {
        List<Integer> res = new ArrayList<>();
        leftViewHelper(res, head, 0);
        return res;
    }

    public static void leftViewHelper(List<Integer> res, Node cur, int depth) {
        if (cur != null) {
            if (depth == res.size())
                res.add(cur.data);

            leftViewHelper(res, cur.left, depth + 1);
            leftViewHelper(res, cur.right, depth + 1);
        }
    }
}
// Time Taken: 19 mins