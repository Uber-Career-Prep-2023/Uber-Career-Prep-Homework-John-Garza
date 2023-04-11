public class BinarySearchTree {
    public class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int val) {
        root = new Node(val);
    }

    int min() {
        // Time Complexity: O(N) where N is the height of the tree. Traverse to the
        // leftmost node since each node to the left is smaller than the parent.
        if (root == null)
            return Integer.MAX_VALUE;

        Node cur = root;
        // find the leftmost value
        while (cur.left != null) {
            cur = cur.left;
        }

        return cur.data;
    }

    int max() {
        // Time Complexity: O(N) where N is the number of nodes in the tree. Traverse to
        // the rightmost node since each node to the right is larger than the parent.
        if (root == null)
            return Integer.MIN_VALUE;

        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }

        return cur.data;
    }

    boolean contains(int val) {
        // Time Complexity: O(N) where N is the number of nodes in the tree. The binary
        // search tree is not a balanced tree (like an AVL tree), so in the worst case,
        // every node in the tree is sequential in one direction (like a LinkedList). In
        // that case, finding something would be a linear time complexity.
        return containsHelper(val, this.root);
    }

    void insert(int val) {
        // Time Complexity: O(N) where N is the number of nodes in the tree. Searching
        // the tree for the proper place of insertion is O(N) for the same reason as
        // listed in the contains method. Inserting/Creating a node is an O(1)
        // operation once the proper location has been found.
        this.root = insertHelper(val, this.root);
    }

    int delete(int val) {
        // Time Complexity: O(N + M) where N is the number of nodes in the tree and M is
        // the number of nodes in the left subtree of the node to be deleted. Searching
        // the tree for the proper place of insertion is O(N) for the same reason as
        // listed in the contains method. Finding the maximum node in the left subtree
        // is also O(M) since it traverses the left subtree looking for the maximum.
        // Deleting the individual node is an O(1) operation. so the overall time
        // complexity is O(N) + O(M)
        this.root = deleteHelper(val, this.root);
        return val;
    }

    boolean containsHelper(int val, Node root) {
        if (root == null)
            return false;
        else {
            if (val < root.data)
                return containsHelper(val, root.left);
            else if (val > root.data)
                return containsHelper(val, root.right);
            else
                return true;
        }
    }

    Node insertHelper(int val, Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (contains(val))
            return root; // to prevent duplicates

        if (val < root.data) {
            root.left = insertHelper(val, root.left);
        } else {
            root.right = insertHelper(val, root.right);
        }
        return root;
    }

    Node deleteHelper(int val, Node root) {
        if (root == null)
            return root;

        // find the node by traversing down the tree
        if (val < root.data)
            root.left = deleteHelper(val, root.left);
        else if (val > root.data)
            root.right = deleteHelper(val, root.right);
        else {
            // found the node to be deleted

            // for a node with 0 children or 1 child
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;

            // if there are two children, get the largest child in the left subtree and
            // assign to the current node
            root.data = maxVal(root.left);

            // delete the largest child in the left subtree
            root.left = deleteHelper(val, root.left);
        }
        return root;
    }

    int maxVal(Node root) {
        // get the maximum value of a subtree
        int max = root.data;
        while (root.right != null) {
            max = root.right.data;
            root = root.right;
        }
        return max;
    }
}
