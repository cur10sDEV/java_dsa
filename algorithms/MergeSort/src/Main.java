import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 4, 12, 3, 7};
        int[] result = mergeSort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            result[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length) {
            result[k] = right[j];
            k++;
            j++;
        }
        return result;
    }

    // Time Complexity - O(N * logN) - N is the work at a single level * N(no of levels)
    // Auxiliary Space - O(N)
}