public class RotatedSortedArr {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,0,1};
        // checking for all elements { for my own sanity }
        for (int num:nums) {
            int result = RBS(nums, num);
            System.out.println(result);
        }
    }

    // find an element in rotated sorted array
    static int RBS(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int pivot = findPivot(arr);
        // if pivot not found perform simple binary search
        if (pivot == -1) return binarySearchTwo(arr,target,0,arr.length - 1);
        // if arr[pivot] element == target element
        if (target == arr[pivot]) return pivot;
        // if target element > start then search in the first half of the array
        if (target >= arr[0]) return binarySearchTwo(arr, target, 0, pivot - 1);
        // if target < start search in the later half of the array
        return binarySearchTwo(arr,target,pivot+1,arr.length - 1);
    }

    // this will not work with duplicate values
    static int findPivot(int[] arr) {
        if (arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid < end && arr[mid] > arr[mid+1]) return mid;
            if (arr[mid] < arr[mid -1] && mid > start) return mid;
            if (arr[mid] >= arr[start]) start = mid;
            if (arr[mid] < arr[start]) end = mid - 1;
        }
        return -1;
    }

    // works with duplicate values
    static int findDuplicatePivot(int[] arr) {
        if (arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid < end && arr[mid] > arr[mid+1]) return mid;
            if (mid > start && arr[mid] < arr[mid -1]) return mid - 1;
            // if start, mid and end elements are equal then skip the duplicates - start & end
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // but first check whether the start or end element is pivot or not
                if (arr[start] > arr[start + 1]) return start;
                start++;
                if (arr[end] < arr[end - 1]) return end - 1;
                end--;
            }
            else if (arr[mid] > arr[start] || arr[mid] == arr[start] && arr[mid] > arr[end]) {
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return -1;
    }

    // find rotation count in rotated sorted array
    static int countRotations(int[] arr) {
        // use this for non-duplicate values
        return findPivot(arr);
        // use this for duplicate values
        // return findDuplicatePivot(arr);
    }

    // order agnostic binary search
    static int binarySearchTwo(int[] arr, int element, int left, int right) {
        if (arr.length == 0) return -1;
        boolean isAsc = arr[left] <= arr[right];
        int mid = left+(right-left)/2;
        if (left <= right) {
            if (element == arr[mid]) return mid;
            if (isAsc) {
                if (element < arr[mid]) return binarySearchTwo(arr,element,left,mid-1);
                if (element > arr[mid]) return binarySearchTwo(arr,element,mid + 1,right);
            } else {
                if (element < arr[mid]) return binarySearchTwo(arr,element,mid+1,right);
                if (element > arr[mid]) return binarySearchTwo(arr,element,left,mid-1);
            }
        }
        return -1;
    }
}