import java.util.Arrays;

public class RecursiveBS {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 11, 3, 4, 0, -3};
        recursiveBubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    static int[] recursiveBubbleSort(int[] arr, int i, int j) {
        if (i <= 0) {
            return arr;
        } else if (j >= i) {
            return recursiveBubbleSort(arr,i-1,0);
        } else {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            return recursiveBubbleSort(arr,i,j+1);
        }
    }
}
