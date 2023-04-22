// Technique: 
// Time Complexity: O(n) where n is the number of nodes. Traverses the entire list once. Uses a front and back pointer to keep the n+1 spacing so that 
//                         when the front pointer reaches the end of the list, the back pointer is at the n+1th from the end.
//                         Then from there swapping pointers are constant operations on the next node to swap it properly;
// Space Complexity: O(1) 
public class MoveNthLastToFront {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(15);
        h1.next = new Node(2);
        h1.next.next = new Node(8);
        h1.next.next.next = new Node(7);
        h1.next.next.next.next = new Node(20);
        h1.next.next.next.next.next = new Node(9);
        h1.next.next.next.next.next.next = new Node(11);
        h1.next.next.next.next.next.next.next = new Node(6);
        h1.next.next.next.next.next.next.next.next = new Node(19);
        printList(h1);
        h1 = moveNthLastToFront(h1, 2);
        printList(h1);

        System.out.println();

        Node h2 = new Node(15);
        h2.next = new Node(2);
        h2.next.next = new Node(8);
        h2.next.next.next = new Node(7);
        h2.next.next.next.next = new Node(20);
        h2.next.next.next.next.next = new Node(9);
        h2.next.next.next.next.next.next = new Node(11);
        h2.next.next.next.next.next.next.next = new Node(6);
        h2.next.next.next.next.next.next.next.next = new Node(19);
        printList(h2);
        h2 = moveNthLastToFront(h2, 7);
        printList(h2);

    }

    public static Node moveNthLastToFront(Node head, int n) {
        Node back = head;
        Node front = head;

        while (front != null && n + 1 > 0) {
            front = front.next;
            n--;
        }

        while (front != null) {
            back = back.next;
            front = front.next;
        }

        // now at n+1th node from the end so can access nth node from the end
        Node newHead = back.next;
        back.next = back.next.next;
        newHead.next = head;

        return newHead;
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
// Time Taken: 18 mins