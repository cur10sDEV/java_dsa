import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 8, 8, 8, 8, 8, 8, 10};
        int[] result = findFirstAndLast(arr, 8);
        System.out.println(Arrays.toString(result));
    }

    static int[] findFirstAndLast(int[] arr, int target) {
        int[] positions = {-1,-1};
        if (arr.length == 0) return positions;
        positions[0] = search(arr, target, true);
        if (positions[0] != -1) positions[1] = search(arr,target,false);
        return positions;
    }

    static int search(int[] arr, int target, boolean findStartIndex) {
        int ans = -1;
        if (arr.length == 0) return ans;
        int start = 0;
        int end = arr.length -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (target == arr[mid]) {
                ans = mid;
                if (findStartIndex) end = mid - 1;
                else start = mid + 1;
            }
            if (target < arr[mid]) end = mid -1;
            if (target > arr[mid]) start = mid + 1;
        }
        return ans;
    }
}
