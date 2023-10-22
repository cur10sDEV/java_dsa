package questions.DFS;

public class FlattenBT {
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

    // turn to a linked list - O(1) space complexity
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // as left is now null, no need to compute
        flatten(root.right);
    }

    // convert to a LL - O(n) space complexity
//    private void convert(TreeNode node, Queue<TreeNode> queue) {
//        if (node == null) {
//            return;
//        }
//        queue.add(node);
//        convert(node.left, queue);
//        convert(node.right,queue);
//
//        TreeNode root = queue.poll();
//        while(!queue.isEmpty()) {
//            TreeNode temp = queue.poll();
//            root.left = null;
//            root.right = temp;
//        }
//    }
}
