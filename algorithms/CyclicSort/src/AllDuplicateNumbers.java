import java.util.*;

public class AllDuplicateNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> result = findAllDuplicateNumbers(arr);
        System.out.println(result.toString());
    }

    static List<Integer> findAllDuplicateNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else i++;
        }

        List<Integer> duplicates = new ArrayList<Integer>();
        for (int j = 0; j < arr.length; j++) {
            int correctIndex = arr[j] - 1;
            if (j != correctIndex) {
                duplicates.add(arr[j]);
            }
        }
        // if no duplicate number
        return duplicates;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
