public class CeilValue {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int result = findCeil(arr, 15);
        System.out.println(arr[result]);
    }

    // returns the index of the smallest number >= target in the array
    static int findCeil(int[] arr, int target) {
        if (arr.length == 0) return -1;
        // if the target element is greater than the greatest element in the array
        if (target > arr[arr.length-1]) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (target == arr[mid]) return mid;
            if (target < arr[mid]) end = mid -1;
            if (target > arr[mid]) start = mid +1;
        }
        return start;
    }
}
