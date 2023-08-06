public class RotatedBS {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 0, 1, 2, 3, 4};
        System.out.println(rotatedBS(arr, 4, 0, arr.length - 1));
    }

    static int rotatedBS(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) return mid;
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) end = mid - 1;
            else start = mid + 1;
        } else if (target >= arr[mid] && target <= arr[end]) start = mid + 1;
        else end = mid - 1;
        return rotatedBS(arr, target, start, end);
    }
}
