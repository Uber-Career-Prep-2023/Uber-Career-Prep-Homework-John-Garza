// Technique: Preorder Traversal
// Time Complexity: O(n) -  n is the number of nodes in the original tree. Traverses the entire tree once to create the copy
// Space Complexity: O(n) - n is the number of nodes in the original tree. Create a new node is constant time but being done n times. 
public class CopyTree {
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
        // TEST 1 - create balanced tree with numbers 0-6
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n3;
        n1.right = n4;
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n2.left = n5;
        n2.right = n6;
        // verify preorders are the same
        TreeNode copyRoot = copyTree(root);
        preOrderPrint(root);
        System.out.println();
        preOrderPrint(copyRoot);

        System.out.println();

        // TEST 2 - create left only tree
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(2);
        root2.left.left.left = new TreeNode(3);
        TreeNode copyRoot2 = copyTree(root2);
        // verify preorders are the same
        preOrderPrint(root2);
        System.out.println();
        preOrderPrint(copyRoot2);

        System.out.println();

        // TEST 3 - create right only tree
        TreeNode root3 = new TreeNode(0);
        root3.right = new TreeNode(1);
        root3.right.right = new TreeNode(2);
        root3.right.right.right = new TreeNode(3);
        TreeNode copyRoot3 = copyTree(root3);
        // verify preorders are the same
        preOrderPrint(root3);
        System.out.println();
        preOrderPrint(copyRoot3);

        System.out.println();

        // TEST 4 - create unbalanced tree
        TreeNode root4 = new TreeNode(0);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(3);
        root4.right.right = new TreeNode(4);
        root4.right.right.left = new TreeNode(5);
        TreeNode copyRoot4 = copyTree(root4);
        // verify preorders are the same
        preOrderPrint(root4);
        System.out.println();
        preOrderPrint(copyRoot4);

    }

    public static TreeNode copyTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode newRoot = new TreeNode(root.data);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;
    }

    public static void preOrderPrint(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderPrint(root.left);
            preOrderPrint(root.right);
        }
    }
}
// Time Taken: 8 mins
