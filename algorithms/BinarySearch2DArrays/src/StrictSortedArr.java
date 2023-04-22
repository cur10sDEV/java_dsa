import java.util.Arrays;

public class StrictSortedArr {
    // given the matrix is column and row wise sorted
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11,12,13,14,15,16,17,18,19,20},
                {21,22,23,24,25,26,27,28,29,30},
                {31,32,33,34,35,36,37,38,39,40},
                {41,42,43,44,45,46,47,48,49,50},
                {51,52,53,54,55,56,57,58,59,60},
                {61,62,63,64,65,66,67,68,69,70},
                {71,72,73,74,75,76,77,78,79,80},
                {81,82,83,84,85,86,87,88,89,90},
                {91,92,93,94,95,96,97,98,99,100},
        };
        int[] result = search(matrix, 100);
        System.out.println(Arrays.toString(result));
    }

    // works with m*n matrix
    static int[] search(int[][] matrix, int target) {
        int[] pos = new int[] {-1,-1};

        if (matrix.length == 0) return pos;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int cols = matrix[0].length - 1; // matrix may be empty so be cautious

        while (rowStart <= rowEnd) {
            // calculate mid row
            int midRow = rowStart + (rowEnd - rowStart) / 2;
            int midCol = cols/2;
            int element = matrix[midRow][midCol];

            if (element == target) return new int[]{midRow, midCol};

            // at the end there will be only two rows
            if (rowEnd - rowStart == 1) {
                pos = binarySearch(matrix,target,rowEnd,0,cols);
                if (pos[0] == -1) return binarySearch(matrix,target,rowStart,0,cols);
                else return pos;
            }
            if (element > target) rowEnd = midRow;
            else rowStart = midRow;
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
