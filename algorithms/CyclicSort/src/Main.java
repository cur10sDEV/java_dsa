import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        int[] result = cyclicSort(arr);
        System.out.println(Arrays.toString(result));
    }

    // Note:- When given numbers from range 1 to N => use cyclic sort
    // Note:- only works with positive numbers

    static int[] cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (correctIndex != i) swap(arr, i, correctIndex);
            else i++;
        }
        return arr;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}