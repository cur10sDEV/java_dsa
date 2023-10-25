package questions.DFS;

public class CheckPath {
    // given an array of node values simulating a path from *root-to-leaf*
    // check whether the given exists in the tree or not
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

    public boolean checkPath(TreeNode root, int[] arr) {
        if (root == null) {
            return arr.length == 0;
        }
        return check(root, arr, 0);
    }

    private boolean check(TreeNode root, int[] arr, int index) {
        if (root == null) {
            return false;
        }
        if (index >= arr.length || root.val != arr[index]) {
            return false;
        }
        if (index == arr.length - 1) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        return check(root.left, arr, index + 1) || check(root.right, arr, index+1);
    }
}
