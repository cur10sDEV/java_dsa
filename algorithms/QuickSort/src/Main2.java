import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {58, 2, -2, -74, 3, 56, 205, -5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = arr[start];
        int swapIndex = start;

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                swapIndex++;
                int temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
            }
        }
        int temp = arr[start];
        arr[start] = arr[swapIndex];
        arr[swapIndex] = temp;

        quickSort(arr, start, swapIndex - 1);
        quickSort(arr, swapIndex + 1, end);
    }
}