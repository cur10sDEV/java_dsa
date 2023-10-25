package questions.DFS;

import java.util.ArrayList;

public class SumRootToLeafNumbers {
    // leetcode 129
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

    // recommended
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int sumSoFar) {
        if (root == null) {
            return 0;
        }
        sumSoFar = sumSoFar > 0 ? (sumSoFar * 10) + root.val : sumSoFar + root.val;
        if (root.left == null && root.right == null) {
            return sumSoFar;
        }
        int left = sumNumbers(root.left, sumSoFar);
        int right = sumNumbers(root.right, sumSoFar);
        return left + right;
    }

// alternate solution
//    public int sumNumbers(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        sumNumbers(root, 0, list, 0);
//        int totalSum = 0;
//        for (int i = 0; i < list.size(); i++) {
//            totalSum += list.get(i);
//        }
//        return totalSum;
//    }
//
//    private void sumNumbers(TreeNode node, int level, ArrayList<Integer> list, int sumSoFar) {
//        if (node == null) {
//            return;
//        }
//        sumSoFar = level != 0 ? (sumSoFar * 10) + node.val : sumSoFar + node.val;
//        if (node.left == null && node.right == null) {
//            list.add(sumSoFar);
//            return;
//        }
//        sumNumbers(node.left, level+1, list,sumSoFar);
//        sumNumbers(node.right, level+1, list,sumSoFar);
//    }
}
