import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// no comparison sorting algo
public class Main {

    // works with small and positive numbers
    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // calculating max element
        int max = arr[0];
        for (int ele : arr) {
            max = Math.max(max, ele);
        }

        // generating the freq arr of length one more than the max element in the array
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

    // works with negative numbers
    public static void countSortHash(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // calculate min and max for efficient traversal
        // store key-value pairs in hashmap where key == ele & value == freq
        int max = arr[0];
        int min = arr[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            max = Math.max(max,ele);
            min = Math.min(min,ele);
            map.put(ele,map.getOrDefault(ele,0) + 1);
        }

        int curr = 0;
        for (int i = min; i <= max; i++) {
            // what if there's no key-value pair for the values in between min and max
            // tip :- you can also use map.getOrDefault() and 0 as default value so that
            // the loop won't run for that i value
            if (map.get(i) != null) {
                for (int j = 0; j < map.get(i); j++) {
                    arr[curr] = i;
                    curr++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,-1,1,-3,2,5,-2,8};
//        countSort(arr);
        countSortHash(arr);
        System.out.println(Arrays.toString(arr));
    }
}