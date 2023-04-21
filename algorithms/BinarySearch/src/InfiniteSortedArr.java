import java.lang.reflect.Array;
import java.util.Arrays;

public class InfiniteSortedArr {
    public static void main(String[] args) {
        int[] arr = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40};
        int result = findInInfiniteArr(arr,22);
        System.out.println(result);
    }

    static int findInInfiniteArr(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int newStart = end + 1;
            // end = prevEnd + sizeOfBox * 2
            end += (end - start + 1) * 2;
            start = newStart;
        }
        return search(arr,target,start,end);
    }

    static int search(int[] arr, int element, int left, int right) {
        if (arr.length == 0) return -1;
        int mid = left+(right-left)/2;
        if (left <= right) {
            if (element == arr[mid]) return mid;
            if (element < arr[mid]) return search(arr,element,left,mid -1);
            if (element > arr[mid]) return search(arr,element,mid+1,right);
        }
        return -1;
    }
}
