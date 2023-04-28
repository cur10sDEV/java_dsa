import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {};
        int[] result = selectionSort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] selectionSort(int[] arr) {
        // for every iteration we will ignore the already sorted sub-array
        for (int i = arr.length - 1; i > 0; i--) {
            // assume that last item is the max element in the array at the start of the loop
            int max = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[max]) max = j;
            }
            // swap the current max element with its proper position in a sorted array
            swap(arr, max, i);
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}