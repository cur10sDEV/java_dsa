public class Spiral {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
        };
        spiral(arr);
    }

    static void spiral(int[][] arr) {
        for (int i = 0; i <= arr.length/2; i++) {
            int row = i;
            int col = i;
            while (col < arr[row].length - i) {
                System.out.print(arr[row][col] + " ");
                col++;
            }
            row++;
            col--;
            System.out.println();
            while (row < arr.length - i) {
                System.out.print(arr[row][col] + " ");
                row++;
            }
            col--;
            row--;
            System.out.println();
            while (col >= i) {
                System.out.print(arr[row][col] + " ");
                col--;
            }
            row--;
            col++;
            System.out.println();
            while (row >= i+1) {
                System.out.print(arr[row][col] + " ");
                row--;
            }
            System.out.println();
        }
    }
}