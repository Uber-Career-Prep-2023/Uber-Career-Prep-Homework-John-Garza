public class Stack {
    public class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node top;

    public Stack() {
        this.top = null;
    }

    // Time Complexity: O(1) since only checking the value of the top of stack
    public int top() {
        return top != null ? top.data : -1;
    }

    // Time Complexity: O(1) since shifting the original top down in stack
    public void push(int x) {
        if (isEmpty()) {
            top = new Node(x);
        } else {
            Node newTop = new Node(x);
            newTop.next = top;
            top = newTop;
        }
    }

    // Time Complexity: O(1) since have access to top value and remove in O(1) time
    public int pop() {
        if (isEmpty())
            return -1;

        int res = top.data;
        top = top.next;
        return res;

    }

    public boolean isEmpty() {
        return top == null;
    }
}
