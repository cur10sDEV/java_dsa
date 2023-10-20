package questions;

import java.util.*;

public class ZigZagLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isRev = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (isRev) {
                    TreeNode back = queue.pollLast();
                    list.add(back.val);
                    if (back.right != null) {
                        queue.addFirst(back.right);
                    }
                    if (back.left != null) {
                        queue.addFirst(back.left);
                    }
                } else {
                    TreeNode front = queue.pollFirst();
                    list.add(front.val);
                    if (front.left != null) {
                        queue.addLast(front.left);
                    }
                    if (front.right != null) {
                        queue.addLast(front.right);
                    }
                }
            }
            isRev = !isRev;
            result.add(list);
        }
        return result;
    }
}
