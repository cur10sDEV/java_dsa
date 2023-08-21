import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(paths("",3,3));
        System.out.println(pathWDiagonal("",3,3));
    }

    // returns all the ways you can be at the last position of the maze
    // if only allowed to go "down" & "right"
    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int down = count(r - 1, c);
        int right = count(r, c - 1);
        return down + right;
    }

    // can only go "right" & "down"
    static ArrayList<String> paths(String p, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }
        // down
        if (r > 1) ans.addAll(paths(p + "D", r - 1, c));
        // right
        if (c > 1) ans.addAll(paths(p + "R", r, c - 1));
        return ans;
    }

    // can only go "right", "down" & "diagonal(right-down)"
    static ArrayList<String> pathWDiagonal(String p, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }
        // diagonal
        if (r > 1 && c > 1) ans.addAll(pathWDiagonal(p + "d",r-1,c-1));
        // down
        if (r > 1) ans.addAll(pathWDiagonal(p + "D", r - 1, c));
        // diagonal
        if (c > 1) ans.addAll(pathWDiagonal(p + "R", r, c - 1));
        return ans;
    }
}