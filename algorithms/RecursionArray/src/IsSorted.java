import java.util.Arrays;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,7,9,11};
        System.out.println(isSorted(arr,0));
    }

    // returns true/false based on whether the array is sorted or not
    static boolean isSorted(int[] arr,int i) {
        // i is the index - from where the array will be checked - default 0
        i = Math.max(i,0);
        if (i >= arr.length - 1) return true;
        return arr[i] <= arr[i+1] && isSorted(arr,i+1);
    }
}