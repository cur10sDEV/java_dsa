import java.util.*;

public class AllMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> result = findMissingNumbers(arr);
        System.out.println(result.toString());
    }

    static List<Integer> findMissingNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else i++;
        }

        // find all missing numbers
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            int correctIndex = arr[j] - 1;
            if (j != correctIndex) {
                result.add(j+1);
            }
        }
        return result;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

