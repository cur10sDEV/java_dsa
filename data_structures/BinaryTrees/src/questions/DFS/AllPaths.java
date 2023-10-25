package questions.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPaths {
    private static class Node {
        Node left;
        Node right;
        int val;
        Node() {}
        Node(int val) {
            this.val = val;
        }
        Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public List<List<Integer>> allPaths(Node node, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        allPaths(node, sum, ans, path);
        return ans;
    }

    private void allPaths(Node node, int sum, List<List<Integer>> ans, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);

        // find no of paths that we can have so that their individual nodes sum == sum
        int pathSum = 0;
        // checking from last index
        int i = path.size() - 1;
        List<Integer> currentPath = new LinkedList<>();
        while (i >= 0) {
            pathSum += path.get(i);
            currentPath.add(path.get(i));
            if (pathSum > sum) break;
            if (pathSum == sum) {
                ans.add(currentPath);
            }
            i--;
        }

        allPaths(node.left, sum, ans, path);
        allPaths(node.right, sum, ans, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}
