import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        int result = findMissingNumber(arr);
        System.out.println(result);
    }

    static int findMissingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // skip the value N
            if (arr[i] < arr.length && arr[i] != i) {
                swap(arr,i,arr[i]);
            }
            else i++;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) return j;
        }

        return arr.length;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
