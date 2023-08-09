import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {18,10,5,19,21,4,0};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // implementation - One
    static void quickSort(int[] arr, int start, int end) {
        // dividing arrays until length == 1
        if (start >= end) {
            return;
        }
        // setting the pivot element at its correct position
        int pivot = pivot(arr,start,end);
        // sorting left sub-array leaving the pivot as it is already at its correct position
        quickSort(arr,start,pivot-1);
        // sorting right sub-array leaving the pivot as it is already at its correct position
        quickSort(arr,pivot+1,end);
    }

    static int pivot(int[] arr, int start, int end) {
        // assuming pivot element is the start element
        int pivot = arr[start];
        // keeping track of the pivot's correct index
        int swapIndex = start;
        // if array's length > 1
        if (start < end) {
            for (int i = start+1; i <= end; i++) {
                // checking for elements less than or equal to pivot
                if (arr[i] <= pivot) {
                    // increasing the index if any element is <= pivot
                    swapIndex++;
                    // swapping the current element with swapIndex so that
                    // left sub-array elements are always less than pivot
                    // and right sub-array elements are always greater than pivot
                    int temp = arr[i];
                    arr[i] = arr[swapIndex];
                    arr[swapIndex] = temp;
                }
            }
            // at last swapping the pivot with its correct position
            int temp = arr[start];
            arr[start] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
        // returning the pivot's index
        return swapIndex;
    }
}