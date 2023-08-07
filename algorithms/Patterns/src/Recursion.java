public class Recursion {
    public static void main(String[] args) {
        patternTwo(5,0);
    }

    static void patternOne(int row, int col) {
        if (row <= 0) {
            return;
        }else if (col >= row) {
            System.out.println();
            col=0;
            patternOne(row-1,col);
        } else {
            System.out.print("* ");
            patternOne(row,col+1);
        }
    }

    static void patternTwo(int row, int col) {
        if (row <= 0) {
            return;
        }else if (col >= row) {
            col=0;
            patternTwo(row-1,col);
            System.out.println();
        } else {
            patternTwo(row,col+1);
            System.out.print("* ");
        }
    }
}
