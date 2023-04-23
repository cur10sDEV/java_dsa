import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-32,78,0,5,-64,9};
        int[] result = bubbleSort(arr);
        System.out.println(Arrays.toString(result));
    }

    // bubble sort also known as sinking sort or exchange sort
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // to check if provided arr is already sorted
            boolean noSwap = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    noSwap = false;
                }
            }
            if (noSwap) return arr;
        }
        return arr;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}