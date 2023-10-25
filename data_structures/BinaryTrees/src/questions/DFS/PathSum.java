package questions.DFS;

public class PathSum {
    // sum of all nodes along the path from *root-to-leaf* node == targetSum
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

    // recommended solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

// alternate solution
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        return hasPathSum(root, targetSum, 0);
//    }
//
//    private boolean hasPathSum(TreeNode node, int targetSum, int sum) {
//        if (node == null) {
//            return false;
//        }
//        sum += node.val;
//        if (node.left == null && node.right == null) {
//            return sum == targetSum;
//        }
//        return hasPathSum(node.left, targetSum, sum) || hasPathSum(node.right, targetSum,sum);
//    }
}
