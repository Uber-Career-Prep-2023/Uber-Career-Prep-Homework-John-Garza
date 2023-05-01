// Technique: BST Traversal
// Time Complexity: O(N) - where N is the number of nodes
// Space Complexity: O(h) - where h is the height of the tree
public class FloorInBST {
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
        System.out.println("Example 1: ");
        Node h1 = new Node(10);
        h1.left = new Node(8);
        h1.right = new Node(16);
        h1.left.right = new Node(9);
        h1.right.left = new Node(13);
        h1.right.right = new Node(17);
        h1.right.right.right = new Node(20);
        System.out.println(floorInBST(h1, 13));

        System.out.println("\nExample 2:");
        Node h2 = new Node(10);
        h2.left = new Node(8);
        h2.right = new Node(16);
        h2.left.right = new Node(9);
        h2.right.left = new Node(13);
        h2.right.right = new Node(17);
        h2.right.right.right = new Node(20);
        System.out.println(floorInBST(h2, 15));

    }

    public static int floorInBST(Node head, int target) {
        int floor = -1;
        Node cur = head;
        while (cur != null) {
            if (cur.data == target) {
                floor = target;
                return floor;
            }

            if (cur.data < target) {
                floor = cur.data;
                cur = cur.right;
            }

            else {
                cur = cur.left;
            }
        }
        return floor;
    }
}
// Time Taken: 10 mins
