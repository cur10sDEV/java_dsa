package questions.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountPaths {
    private static class Node {
        Node left;
        Node right;
        int val;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public int countPaths(Node node, int sum) {
        List<Integer> path = new ArrayList<>();
        return countPaths(node,sum,path);
    }

    private int countPaths(Node node, int sum, List<Integer> path) {
        if (node == null) {
            return 0;
        }
        path.add(node.val);

        // find no of paths that we can have so that their individual nodes sum == sum
        int count = 0;
        int pathSum = 0;
        // checking from last index
        int i = path.size() - 1;
        while (i >= 0) {
            pathSum += path.get(i);
            if (pathSum > sum) break;
            if (pathSum == sum) {
                count++;
            }
            i--;
        }

        count += countPaths(node.left, sum, path) + countPaths(node.right, sum, path);

        // backtrack
        path.remove(path.size() - 1);

        return count;
    }
}
