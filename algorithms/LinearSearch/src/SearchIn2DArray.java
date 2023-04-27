import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {-1, 23, 55},
                {63, 89, 97, 355},
                {-97, 65, -255, 29, 7}
        };
        int target = -97;
        int[] result = search(arr, target); // result format is [row, col]
        System.out.println(Arrays.toString(result));
        int max = findMax(arr);
        int min = findMin(arr);
        System.out.println("Max: "+max+", Min: "+min);
    }

    // find element in 2d array
    static int[] search(int[][] arr, int target) {
        // if array is empty
        if (arr.length == 0) return new int[]{};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // if element found return index
                if (arr[i][j] == target) return new int[]{i,j};
            }
        }

        // if element not found return empty array
        return new int[]{};
    }

    // find min element in 2d array
    static int findMin(int[][] arr) {
        // if array is empty
        if (arr.length == 0) return Integer.MAX_VALUE;
        // suppose min value at start
        int minValue = Integer.MAX_VALUE;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                // updates min value if current element is less than the min value
                if (anInt < minValue) minValue = anInt;
            }
        }

        // return min value at last
        return minValue;
    }

    // find max element in 2d array
    static int findMax(int[][] arr) {
        // if array is empty
        if (arr.length == 0) return Integer.MIN_VALUE;
        // suppose max value at start
        int maxValue = Integer.MIN_VALUE;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                // updates max value if current element is less than the max value
                if (anInt > maxValue) maxValue = anInt;
            }
        }

        // return max value at last
        return maxValue;
    }
}
