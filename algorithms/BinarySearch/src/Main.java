public class Main {
    public static void main(String[] args) {
//        int[] arr = {-6,-1,2,5,18,37,64,89,112}; // asc order
        int[] arr = {118,89,78,64,39,2,-1,-12,-99}; // desc order
        int index = binarySearchTwo(arr,89, 0,arr.length - 1);
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int element) {
        if (arr.length == 0) return -1;
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (element == arr[mid]) return mid;
            if (element < arr[mid]) right = mid -1;
            if (element > arr[mid]) left = mid + 1;
        }
        return -1;
    }

    // recursive binarySearch
    static int binarySearch(int[] arr, int element, int left, int right) {
        if (arr.length == 0) return -1;
        int mid = left+(right-left)/2;
        if (left <= right) {
            if (element == arr[mid]) return mid;
            if (element < arr[mid]) return binarySearch(arr,element,left,mid -1);
            if (element > arr[mid]) return binarySearch(arr,element,mid+1,right);
        }
        return -1;
    }

    // order agnostic binary search
    static int binarySearchTwo(int[] arr, int element) {
        if (arr.length == 0) return -1;
        int left = 0;
        int right = arr.length-1;
        boolean isAsc = arr[left] <= arr[right];
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (element == arr[mid]) return mid;
            if (isAsc) {
                if (element < arr[mid]) right = mid - 1;
                if (element > arr[mid]) left = mid + 1;
            } else {
                if (element < arr[mid]) left = mid + 1;
                if (element > arr[mid]) right = mid - 1;
            }
        }
        return -1;
    }

//     recursive order agnostic binary search
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