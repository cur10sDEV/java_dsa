package questions.DFS;

public class Diameter {
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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        updateHeightAndDiameter(root);
        return diameter;
    }

    private int updateHeightAndDiameter(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = updateHeightAndDiameter(node.left);
        int rightHeight = updateHeightAndDiameter(node.right);

        // diameter
        int dia = leftHeight + 1 + rightHeight + 1;
        diameter = Math.max(dia, diameter);

        // height
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
