public class SortedMountainArr {
    // mountain array is also known as bitonic array
    public static void main(String[] args) {
        int[] arr = {-1,6,8,9,11,25,12,10,5,2};
        // checking for every element {for my own sanity  :-)}
        for (int i: arr) {
            int result = findInMountain(arr, i);
            System.out.println(result);
        }
    }

    // find target element in mountain array
    static int findInMountain(int[] arr, int target) {
        // first find the peak
        int peak = findPeak(arr);

        // check whether the peak indexed element == target
        if (target == arr[peak]) return peak;

        // find element in the first half i.e., asc order of the array
        int ans = orderAgsBS(arr,target,0,peak - 1);

        // find element in the second half i.e., desc order of the array
        if (ans == -1) ans = orderAgsBS(arr,target,peak + 1,arr.length-1);

        return ans;
    }

    // find peak element in mountain array
    static int findPeak(int[] arr) {
        if (arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid-1]) return mid;
            if (arr[mid] < arr[mid+1]) start = mid + 1;
            if (arr[mid] > arr[mid+1]) end = mid - 1;
        }
        return -1;
    }

    // order agnostic binary search
    static int orderAgsBS(int[] arr, int element, int start, int end) {
        if (arr.length == 0) return -1;
        boolean isAsc = arr[start] <= arr[end];
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (element == arr[mid]) return mid;
            if (isAsc) {
                if (element < arr[mid]) end = mid - 1;
                if (element > arr[mid]) start = mid + 1;
            } else {
                if (element < arr[mid]) start = mid + 1;
                if (element > arr[mid]) end = mid - 1;
            }
        }
        return -1;
    }

}
