import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
        int[][] path = new int[maze.length][maze[0].length];
        printAllPaths("", maze, 0, 0, path, 1);
    }

    static ArrayList<String> allPaths(String p, boolean[][] maze, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        // if found obstacle return empty - no forward recursive calls
        if (!maze[r][c]) {
            return ans;
        }
        // finish point
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ans.add(p);
            return ans;
        }
        // considering this block/cell in my path
        maze[r][c] = false;
        // diagonal (forward - down-right)
        if (r < maze.length - 1 && c < maze.length - 1) {
            ans.addAll(allPaths(p + "d", maze, r + 1, c + 1));
        }
        // down
        if (r < maze.length - 1) {
            ans.addAll(allPaths(p + "D", maze, r + 1, c));
        }
        // right
        if (c < maze[0].length - 1) {
            ans.addAll(allPaths(p + "R", maze, r, c + 1));
        }
        // up
        if (r > 0) {
            ans.addAll(allPaths(p + "U", maze, r - 1, c));
        }
        // left
        if (c > 0) {
            ans.addAll(allPaths(p + "L", maze, r, c - 1));
        }
        // reverting changes to the path so that new calls can also accommodate these blocks in their path
        maze[r][c] = true;
        return ans;
    }

    static void printAllPaths(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        // if found obstacle return empty - no forward recursive calls
        if (!maze[r][c]) {
            return;
        }
        // finish point
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        // considering this block/cell in my path
        maze[r][c] = false;
        path[r][c] = step;
        // diagonal (forward - down-right)
        if (r < maze.length - 1 && c < maze.length - 1) {
            printAllPaths(p + "d", maze, r + 1, c + 1, path, step + 1);
        }
        // down
        if (r < maze.length - 1) {
            printAllPaths(p + "D", maze, r + 1, c, path, step + 1);
        }
        // right
        if (c < maze[0].length - 1) {
            printAllPaths(p + "R", maze, r, c + 1, path, step + 1);
        }
        // up
        if (r > 0) {
            printAllPaths(p + "U", maze, r - 1, c, path, step + 1);
        }
        // left
        if (c > 0) {
            printAllPaths(p + "L", maze, r, c - 1, path, step + 1);
        }
        // reverting changes to the path so that new calls can also accommodate these blocks in their path
        maze[r][c] = true;
        path[r][c] = 0;
    }
}