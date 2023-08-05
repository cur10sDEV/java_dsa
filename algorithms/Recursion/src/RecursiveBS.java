public class RecursiveBS {
    public static void main(String[] args) {
        int[] arr = {-7,-1,0,2,4,5,9,13};
        int result = recursiveBS(arr, 1, 0, arr.length-1);
        System.out.println(result);
    }

    // Recursive Binary Search
    static int recursiveBS(int[] arr, int target, int start, int end) {
        if (arr.length == 0) return -1;
        if (start <= end) {
            int mid = start+(end-start)/2;
            if (target == arr[mid]) return mid;
            if (target < arr[mid]) return recursiveBS(arr,target,start,mid-1);
            if (target > arr[mid]) return recursiveBS(arr,target,mid+1,end);
        }
        return -1;
    }
}
