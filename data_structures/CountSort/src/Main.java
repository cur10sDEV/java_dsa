import java.util.Arrays;

public class Main {
    // no comparison sorting algo
    // works with small no.s
    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // calculating max element
        int max = arr[0];
        for (int ele : arr) {
            max = Math.max(max, ele);
        }

        // generating the freq arr
        // storing element's freq at their respective index i.e., ele == index
        int[] freqArr = new int[max + 1];
        for (int ele: arr) {
            freqArr[ele] += 1;
        }

        int curr = 0;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > 0) {
                for (int j = 0; j < freqArr[i]; j++) {
                    arr[curr] = i;
                    curr++;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,1,3,2,5,2,8};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}