public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 19, 21, 35, -256, 99, 68};
        int target = 999;
        int result = linearSearch(arr,target);
        System.out.println(result);
    }

    // return the index of the target element
    static int linearSearch(int[] arr,int target) {
        // if array is empty
        if (arr.length == 0) return -1;

        for (int i=0; i < arr.length; i++) {
            // if element found return the index
            if (arr[i] == target) return i;
        }

        // if element not found
        return -1;
    }

    // return the target element itself
    static int linearSearchTwo(int[] arr,int target) {
        for (int i: arr) {
            // if element found return it
            if (i == target) return i;
        }

        // if element not found or array is empty - we return the constant because
        // it might be the case that -1 is one of the array elements
        return Integer.MAX_VALUE;
    }

    // return true of false
    static boolean linearSearchThree(int[] arr,int target) {
        for (int j : arr) {
            // if element found return the true
            if (j == target) return true;
        }

        // if element not found or array is empty
        return false;
    }
}