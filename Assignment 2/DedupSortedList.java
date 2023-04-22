// Technique: LinkedList reset/catchup two pointer
// Time Complexity: O(n) - We traverse the list once with two pointers, removing duplicates and placing cur at the end of the duplicates
// Space Complexity: O(1) - Constant space is used since we are just removing from the list
public class DedupSortedList {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(2);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);
        h1.next.next.next.next.next = new Node(5);
        h1.next.next.next.next.next.next = new Node(5);
        h1.next.next.next.next.next.next.next = new Node(5);
        h1.next.next.next.next.next.next.next.next = new Node(10);
        printList(h1);
        removeDuplicates(h1);
        printList(h1);

        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(3);
        printList(h2);
        removeDuplicates(h2);
        printList(h2);
    }

    public static Node removeDuplicates(Node head) {
        Node cur = head;
        while (cur != null) {
            Node tmp = cur;
            while (tmp != null && tmp.data == cur.data) {
                tmp = tmp.next;
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return head;
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
// Time Taken: 10 mins
