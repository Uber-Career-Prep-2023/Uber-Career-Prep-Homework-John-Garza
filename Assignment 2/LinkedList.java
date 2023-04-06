public class LinkedList {
    public class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node insertAtFront(Node head, int val) {
        // Time Complexity: O(1), constant time to insert the node & no shifting needed
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public void insertAtBack(Node head, int val) {
        // Time Complexity: O(N), traverse the entire list with N nodes to the last spot
        // and insert single node in constant time

        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next; // move to last spot
        }
        cur.next = newNode;
    }

    public void insertAfter(Node head, int val, Node loc) {
        // Time complexity: Insertion is O(1) since we already have reference to the loc
        // node and all that is needed to do is modify next pointers
        Node newNode = new Node(val);
        if (loc.next != null) {
            newNode.next = loc.next;
            loc.next = newNode;
        } else {
            loc.next = newNode;
        }
    }

    public Node deleteFront(Node head) {
        // Time Complexity: O(1), since already have access to the head, no need to
        // traverse the list and can remove head in constant time
        if (head == null) {
            return null;
        }
        Node cur = head;
        head = head.next;
        cur.next = null; // disconnect original head node
        return head; // new head
    }

    public void deleteBack(Node head) {
        // Time complexity: O(N), traverses a list of N nodes to the N-1th spot, then
        // deletes the last node
        if (head == null || head.next == null)
            return;

        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;

    }

    public Node deleteNode(Node head, Node loc) {
        // Time Complexity: O(N), traverse the list to the node before loc in order to
        // delete loc
        if (head == null || head == loc) {
            head = null;
        } else {
            Node cur = head;
            while (cur != null && cur.next != loc) {
                cur = cur.next;
            }
            cur.next = loc.next;
            loc = null;
        }
        return head;
    }

    public int length(Node head) {
        // Time complexity: O(N), traverse entire list once
        Node cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public Node reverseIterative(Node head) {
        // Time Complexity: O(N), traverse the entire LinkedList only once and modify
        // the pointers of each node
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node next = cur.next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public Node reverseRecursive(Node head) {
        // Time Complexity: O(N), traverse the entire LinkedList only once and modify
        // the pointers of each node
        if (head == null || head.next == null) {
            return head;
        }

        // reverse direction of the node
        Node prev = null;
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = prev;
        return newHead;
    }

}