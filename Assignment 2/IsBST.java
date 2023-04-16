// Technique: Generic Traversal
// Time Complexity: O(n) - n is the number of nodes. Traverse the entire tree to verify that it follows proper ordering
// Space Complexity: O(h) - where h is the tree height.  Uses recursive stack to store the result of at max h nodes at a time
public class IsBST {
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        // TEST 1 - Example 1
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(16);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);
        root.right.right.right = new TreeNode(20);
        System.out.println("Example 1: " + isBST(root));

        // TEST 2 - Example 2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(8);
        root2.left.right = new TreeNode(9);
        root2.right = new TreeNode(16);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(17);
        root2.right.right.right = new TreeNode(15);
        System.out.println("Example 2: " + isBST(root2));
    }

    public static boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.data >= max || root.data <= min)
            return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
// Time Taken: 15 mins
