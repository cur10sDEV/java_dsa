package questions.BFS;

import java.util.*;

public class Cousins {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0) && !isSiblings(root, xx, yy));
    }

    private boolean isSiblings(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }
        return (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSiblings(node.left, x, y) || isSiblings(node.right, x, y);
    }

    private int level(TreeNode node, TreeNode x, int currLevel) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return currLevel;
        }

        int l = level(node.left, x, currLevel + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, currLevel + 1);
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode left = findNode(node.left, x);
        if (left != null) {
            return left;
        }
        return findNode(node.right, x);
    }
}
