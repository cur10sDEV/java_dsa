import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        int[] result = insertionSort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] insertionSort(int[] arr) {
        int count = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                System.out.println(count);
                count++;
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                } else break;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}