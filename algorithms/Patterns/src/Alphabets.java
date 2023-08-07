public class Alphabets {
    public static void main(String[] args) {
        printA(5);
        printS(5);
    }

    static void printA(int n) {
        for (int row = 0; row < n; row++) {
            for (int startSpace = 0; startSpace < n - row; startSpace++) {
                System.out.print("  ");
            }
            int midRow = (int)(Math.floor(n/2));
            if (row == midRow) {
                for (int mid = n - row; mid < (2 * n) - row; mid++) {
                    System.out.print("* ");
                }
            } else {
                for (int star = n-row; star <= n-row; star++) {
                    System.out.print("* ");
                }
                for (int endSpace = 1; endSpace < 2*row; endSpace++) {
                    System.out.print("  ");
                }
                if (row != 0) System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printS(int n) {
        for (int row = 0; row < n; row++) {
            if (row == 0 || row == n-1 || row == Math.floor(n/2)) {
                for (int i = 0; i < n; i++) {
                    System.out.print("* ");
                }
            } else {
                if (row < Math.floor(n/2)) {
                    for (int i = 0; i < Math.floor(n/2); i++) {
                        if (i == 0) System.out.print("* ");
                    }
                } else if (row > n/2) {
                    for (int i = 0; i < n; i++) {
                        if (i == n-1) System.out.print("* ");
                        else System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
}