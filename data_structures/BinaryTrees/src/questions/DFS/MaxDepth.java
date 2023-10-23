package questions.DFS;

public class MaxDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            // depth at null is 0 - 0 nodes
            return 0;
        }
        // no of nodes at left and right side
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // increase the depth by also counting the root node
        return Math.max(left, right) + 1;
    }
}
