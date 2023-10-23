package questions.DFS;

import java.util.Arrays;

public class ConstructBT {
    // construct bt from two arrays - in-order and pre-order
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,rootIndex+1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder,rootIndex+1,preorder.length), Arrays.copyOfRange(inorder,rootIndex+1, inorder.length));
        return root;
    }
}
