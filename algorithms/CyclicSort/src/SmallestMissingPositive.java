import java.util.Arrays;

public class SmallestMissingPositive {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        int result = findSmallestMissingPositiveNum(arr);
        System.out.println(result);
    }

    static int findSmallestMissingPositiveNum(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > 0 && arr[i] < arr.length && arr[i] != i+1) {
                swap(arr, i, arr[i]-1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int j = 0; j < arr.length; j++) {
            if (arr[j] != j+1) {
                return j+1;
            }
        }
        return arr.length+1;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
