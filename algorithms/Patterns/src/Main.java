public class Main {
    public static void main(String[] args) {
        patternOne(5);
        System.out.println();
        patternTwo(5);
        System.out.println();
        patternThree(5);
        System.out.println();
        patternFour(5);
        System.out.println();
        patternFive(5);
        System.out.println();
        patternSix(5);
        System.out.println();
        patternSeven(5);
        System.out.println();
        patternEight(5);
        System.out.println();
        patternNine(5);
        System.out.println();
        patternTen(5);
    }

    static void patternOne(int n) {
        for (int rows = 0; rows < n; rows++) {
            for (int col = 0; col < rows; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void patternTwo(int n) {
        for (int rows = 0; rows < n; rows++) {
            for (int col = 0; col < n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void patternThree(int n) {
        int rows = 0;
        while (rows < n) {
            if (rows < (2*n-1)) {
                System.out.print("* ");
            }
            rows++;
        }
        System.out.println();
    }

    static void patternFour(int n) {
        for (int rows = 0; rows < n; rows++) {
            for (int col = 0; col <= rows; col++) {
                System.out.printf(col+1 + " ");
            }
            System.out.println();
        }
    }

    static void patternFive(int n) {
        for (int row = 0; row < 2*n; row++) {
            int col = row > n ? 2*n - row : row;
            for (int i = 0; i < col; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    static void patternSix(int n) {
        for (int rows = 0; rows < n; rows++) {
            int starStart = n-(rows+1);
            for (int col = 0; col < starStart; col++) {
                System.out.print("  ");
            }
            for (int j = starStart; j < n; j++ ) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void patternSeven(int n) {
        for (int row = 0; row < 2*n; row++) {
            int starIndex = row < n ? n-row: row-n;
            for (int i = 0; i < starIndex; i++) {
                System.out.print(" ");
            }
            for (int j = starIndex; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void patternEight(int n) {
        for (int row = 1; row <= n; row++) {
            int colStart = n-row;
            for (int i = 0; i < colStart; i++) {
                System.out.print("  ");
            }
            for (int j = row; j >= 1; j--) {
                System.out.print(j+" ");
            }
            for (int k = 2; k <= row; k++) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }

    static void patternNine(int n) {
        for (int row = 1; row < 2*n; row++) {
            int colStart = row < n ? n-row: row - n;
            for (int i = 0; i < colStart; i++) {
                System.out.print("  ");
            }
            for (int j = row < n ? row : n-colStart; j > 1; j--) {
                System.out.print(j+" ");
            }
            for (int k = 1; k <= n-colStart; k++) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }

    static void patternTen(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n+1; col++) {
                if (row == 0 || row == n-1 || col == 0 || col == n) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}