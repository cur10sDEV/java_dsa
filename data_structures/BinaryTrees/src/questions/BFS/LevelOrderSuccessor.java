package questions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderSuccessor {
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

    public TreeNode findSuccessor(TreeNode root, int key) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front.left != null) {
                queue.offer(front.left);
            }
            if (front.right != null) {
                queue.offer(front.right);
            }
            if (front.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}
