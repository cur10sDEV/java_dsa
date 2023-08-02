import java.util.Arrays;

public class FlipImage {
    public static void main(String[] args) {
        int[][] img = new int[][] {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
        int[][] ans = flipImage(img);
        for (int[] arr: ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] flipImage(int[][] arr) {
        // first reverse the rows
        for (int[] ints : arr) {
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                swap(ints, start, end);
                start++;
                end--;
            }
        }
        // second flip the elements of the rows - 1 to 0 and vice versa
        for (int[] ints: arr) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = ints[i] ^ 1;
                // n ^ 1 = ~n(complement)
            }
        }
        return arr;
    }

    static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
