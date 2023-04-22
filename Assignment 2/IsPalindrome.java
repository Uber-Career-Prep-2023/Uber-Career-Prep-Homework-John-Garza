// Technique: Doubly LL Forward-backward two pointer
// Time Complexity: O(n) where n is the number of nodes. Traverses to the end of the list then uses a
//                       left and right pointer to check if the values are the same until reaching the middle
// Space Complexity: O(1) - creating pointers to a node is constant space operation
public class IsPalindrome {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;

        }

        public Node(int data, Node prev) {
            this.data = data;
            this.prev = prev;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(9);
        h1.next = new Node(2, h1);
        h1.next.next = new Node(4, h1.next);
        h1.next.next.next = new Node(2, h1.next.next);
        h1.next.next.next.next = new Node(9, h1.next.next.next);
        printList(h1);
        System.out.println(isPalindrome(h1));

        System.out.println();

        Node h2 = new Node(9);
        h2.next = new Node(12, h2);
        h2.next.next = new Node(4, h2.next);
        h2.next.next.next = new Node(2, h2.next.next);
        h2.next.next.next.next = new Node(9, h2.next.next.next);
        printList(h2);
        System.out.println(isPalindrome(h2));

    }

    public static boolean isPalindrome(Node head) {
        if (head == null)
            return false;

        // navigate to the end of the list
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }

        Node left = head;
        while (left != right) {
            if (left.data != right.data)
                return false;

            left = left.next;
            right = right.prev;
        }
        return true;
    }

    public static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
// Time Taken: 9 mins
