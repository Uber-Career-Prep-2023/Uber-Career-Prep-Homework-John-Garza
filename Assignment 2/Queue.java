public class Queue {
    public class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;
    Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    // Time Complexity: O(1) - accessing the head which we already have is constant
    public int peek() {
        return head != null ? head.data : -1;
    }

    // Time Complexity: O(1) - inserting is constant since have access to tail
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
        } else {
            if (tail == null)
                tail = newNode;
            else
                tail.next = newNode;
        }
    }

    // Time Complexity: O(1) - remove the head from the LL and return it
    public int dequeue() {
        if (isEmpty())
            return -1;

        int res = head.data;
        head = head.next;
        return res;
    }

    // Time Complexity: O(1) - just need to check if the head is null or not
    public boolean isEmpty() {
        return head == null;
    }
}