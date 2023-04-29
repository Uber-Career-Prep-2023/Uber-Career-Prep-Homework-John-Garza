// Technique: Slow and Fast Pointer
// Time Complexity: O(N) - where N is the number of nodes in the LL. We use Floyd's cycle 
//                         finding algo to find the cycle with slow and fast pointers and 
//                         then are able to remove it if it exists.
// Space Complexity: O(1) - There is no extra space used in the solution other than variables
public class DisconnectCycle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Example 1");

        // Example 1 - Cycle from last node (4) to 12
        Node h1 = new Node(10);
        h1.next = new Node(18);
        Node cycleNode = new Node(12);
        h1.next.next = cycleNode;
        cycleNode.next = new Node(9);
        cycleNode.next.next = new Node(11);
        cycleNode.next.next.next = new Node(4, cycleNode); // cycle from 4 to 12
        h1 = disconnectCycle(h1);
        printList(h1);

        System.out.println("\nExample 2");

        // Example 2 - Cycle from last node (4) to itself
        Node h2 = new Node(10);
        h2.next = new Node(18);
        h2.next.next = new Node(12);
        h2.next.next.next = new Node(9);
        h2.next.next.next.next = new Node(11);
        Node cycleNode2 = new Node(4);
        h2.next.next.next.next.next = cycleNode2;
        cycleNode2.next = cycleNode2; // cycle from 4 to 4
        h2 = disconnectCycle(h2);
        printList(h2);

        System.out.println("\nExample 3");

        // Example 3 - No cycle
        Node h3 = new Node(10);
        h3.next = new Node(18);
        h3.next.next = new Node(12);
        h3.next.next.next = new Node(9);
        h3.next.next.next.next = new Node(11);
        h3.next.next.next.next.next = new Node(4);
        h3 = disconnectCycle(h3);
        printList(h3);

    }

    public static Node disconnectCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (slow == fast) {
            // Loop found so disconnect
            System.out.println("Loop found at: " + slow.data);
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            // handle the edge case if the slow and fast pointer meet at the first position
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            }
            // have now reached the node prior to the cycle so can remove the loop
            fast.next = null;
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
// Time Taken: 32 mins
