package questions.DFS;

import java.util.ArrayList;

public class KthSmallestInBST {
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



    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return findKth(root, k).val;
    }
    private TreeNode findKth(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = findKth(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return findKth(root.right, k);
    }

    // if node.val does not contain negative integers
//    public int kthSmallest(TreeNode root, int k) {
//        if (root == null) {
//            return -1;
//        }
//        int left = kthSmallest(root.left, k);
//        if (left >= 0) {
//            return left;
//        }
//        count++;
//        if (count == k) {
//            return root.val;
//        }
//        return kthSmallest(root.right, k);
//    }

    // alternate solution
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<Integer> list = new ArrayList<>();
//        find(root, list);
//        return list.get(k - 1);
//    }
//
//    private void find(TreeNode node, ArrayList<Integer> list) {
//        // in-order traversal and find k-1 item
//        if (node == null) {
//            return;
//        }
//        find(node.left, list);
//        list.add(node.val);
//        find(node.right, list);
//    }
}
