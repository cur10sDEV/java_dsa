public class FindMinAndMax {
    public static void main(String[] args) {
        int[] arr = {1,-8,13,97,64,22,89,-55,132};
        int min = findMin(arr);
        int max = findMax(arr);
        int maxInRange = findMax(arr, 1,6);
        int minInRange = findMin(arr, 1,6);
        System.out.println("Max: "+max+", Min: "+min);
        System.out.println("Max in range: "+maxInRange+", Min in range: "+minInRange);
    }

    // Find min integer in the array
    static int findMin(int[] arr) {
        // if arr is empty
        if (arr.length == 0) return Integer.MAX_VALUE;
        // supposed min value at the start
        int minValue = arr[0];

        for (int num: arr) {
            // choose the min value between current array element and current min value
            if (num < minValue) minValue = num;
        }

        // return the min value at the end
        return minValue;
    }

    // Find max integer in the array
    static int findMax(int[] arr) {
        // if arr is empty
        if (arr.length == 0) return Integer.MAX_VALUE;
        // supposed max value at the start
        int maxValue = arr[0];

        for (int num: arr) {
            // choose the max value between current array element and current min value
            if (num > maxValue) maxValue = num;
        }

        // return the max value at the end
        return maxValue;
    }

    // find min in range
    static int findMin(int[] arr, int start, int end) {
        // if arr is empty
        if (arr.length == 0) return Integer.MAX_VALUE;
        // if start of end index is out of range of the array
        if (start >= arr.length || end >= arr.length) return Integer.MAX_VALUE;

        // supposed max value at the start
        int minValue = arr[start];
        // if start is greater than or equal to
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                // choose the max value between current array element and current min value
                if (arr[i] < minValue) minValue = arr[i];
            }
        }
        // return the max value at the end
        return minValue;
    }

    // find max in range
    static int findMax(int[] arr, int start, int end) {
        // if arr is empty
        if (arr.length == 0) return Integer.MAX_VALUE;
        // if start of end index is out of range of the array
        if (start >= arr.length || end >= arr.length) return Integer.MAX_VALUE;

        // supposed max value at the start
        int maxValue = arr[start];
        // if start is greater than or equal to
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                // choose the max value between current array element and current min value
                if (arr[i] > maxValue) maxValue = arr[i];
            }
        }
        // return the max value at the end
        return maxValue;
    }
}
