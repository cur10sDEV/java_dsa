package questions.DFS;

public class MaxPathSum {
    // leetcode 124
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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPath;
    }
    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);

        // if value is negative then don't add it
        // otherwise it will reduce your maxPath
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int sum = left + right + root.val;

        // global max path
        maxPath = Math.max(sum, maxPath);

        // max path from that subtree
        return Math.max(left, right) + root.val;
    }
}
