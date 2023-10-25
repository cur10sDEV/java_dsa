package questions.DFS;

import java.util.Stack;

// iterative - using stacks
public class DFS {
    class Node {
        Node left;
        Node right;
        int val;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    // pre-order traversal
    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
}
