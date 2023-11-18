import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // calculate no of digits of the max number
        int max = Arrays.stream(arr).max().getAsInt();

        // now run the count sort max digits time
        // for the exp-th digit place i.e., 1's, 10's, 100's and so on
        int exp = 1;
        while (max / exp > 0) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    private static void countSort(int[] arr, int exp) {
        // only 0 - 9 possible digits so 10 is the length of count array
        int[] count = new int[10];
        int[] output = new int[arr.length];

        // calculate frequencies of particular digit value of every element
        for (int ele : arr) {
            count[(ele/ exp) % 10]++;
        }

        // now according to frequencies and digit value(index), sort the array
        int curr = 0;
        for (int i = 0; i < count.length; i++) {
            int freq = count[i];
            if (freq > 0) {
                for (int ele : arr) {
                    int index = (ele/ exp) % 10;
                    if (index == i) {
                        output[curr] = ele;
                        curr++;
                    }
                }
            }
        }
        System.arraycopy(output,0,arr,0,arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {29, 83, 471, 36, 91, 8};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}