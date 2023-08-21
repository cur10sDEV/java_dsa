import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true, true},
                {true, true, false, true},
                {true, false, true, true},
                {true, true, true, true},
        };
        System.out.println(path("", maze, 1, 1));
    }

    // with diagonal routes also
    static ArrayList<String> path(String p, boolean[][] maze, int r, int c) {
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
        // diagonal
        if (r < maze.length - 1 && c < maze.length - 1) {
            ans.addAll(path(p + "d", maze, r + 1, c + 1));
        }
        // down
        if (r < maze.length - 1) {
            ans.addAll(path(p + "D", maze, r + 1, c));
        }
        // right
        if (c < maze[0].length - 1) {
            ans.addAll(path(p + "R", maze, r, c + 1));
        }
        return ans;
    }
}
