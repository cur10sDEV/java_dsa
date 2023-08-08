import java.util.Arrays;

public class InPlace {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 4, 12, 3, 7};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (end-start == 1) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int[] result = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            result[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            result[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < result.length; l++) {
            arr[start + l] = result[l];
        }
    }
}
