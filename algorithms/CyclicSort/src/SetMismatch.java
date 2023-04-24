import java.util.Arrays;

// Q:- a number is repeated and has taken place of the other number
// return the repeated number and the missing number
// ex:- input => [1,2,2,4] output => [2,3]

public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {2,1,4,2,6,5};
        int[] result = findDuplicateAndMissingNumber(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] findDuplicateAndMissingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else i++;
        }

        for (int j = 0; j < arr.length; j++) {
            int correctIndex = arr[j] - 1;
            if (j != correctIndex) {
                return new int[] {arr[j], j+1};
            }
        }
        return new int[] {-1,-1};
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
