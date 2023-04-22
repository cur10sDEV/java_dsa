import java.util.Arrays;

public class RowColMatrix {
    // given the matrix is column and row wise sorted
    public static void main(String[] args) {
//        int[][] matrix= {
//                {10, 15, 28, 33},
//                {20, 25, 29, 34},
//                {30, 35, 37, 38},
//                {40, 45, 49, 50}
//        };
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[] result = search(matrix, 16);
        System.out.println(Arrays.toString(result));
    }
        
    // works with m*n matrix
//    static int[] search(int[][] matrix, int target) {
//        int row = 0;
//        int col = matrix[0].length - 1;
//
//        while (row < matrix.length && col >= 0) {
//            int element = matrix[row][col];
//            if (target == element) return new int[]{row,col};
//            if (target < element) col--;
//            if (target > element) row++;
//        }
//        return new int[] {-1,-1};
//    }

    // works with m*n matrix
    static int[] search(int[][] matrix, int target) {
        int[] pos = new int[] {-1,-1};
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1; // matrix may be empty so be cautious

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // calculate mid row
            int midRow = rowStart + (rowEnd - rowStart) / 2;
            // calculate mid col
            int midCol = colStart + (colEnd - colStart) / 2;

            int element = matrix[midRow][midCol];

            if (element == target) return new int[]{midRow, midCol};

            // at the end there will be only two rows
            if (rowEnd - rowStart == 1) {
                pos = binarySearch(matrix,target,rowEnd,colStart,colEnd);
                if (pos[0] == -1) {
                    return binarySearch(matrix,target,rowStart,colStart,colEnd);
                }
            }

            if (element > target) {
                rowEnd = midRow;
            } else {
                rowStart = midRow;
            }
        }
        return pos;
    }

    static int[] binarySearch(int[][] matrix, int target, int row, int colStart, int colEnd) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart)/2;
            int element = matrix[row][mid];
            if (element == target) return new int[] {row,mid};
            if (element > target) colEnd = mid -1;
            else colStart = mid + 1;
        }
        return new int[] {-1,-1};
    }
}
