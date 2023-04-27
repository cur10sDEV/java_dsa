public class SearchInRange {
    public static void main(String[] args) {
//        String str = "Java is a great language";
//        char target = 'a';
//        boolean result = searchInRange(str,target,24,24);
        int[] arr = {-1,2,-25,69,87,23,11,9};
        int target = 11;
        int result = searchInRange(arr,target,2,5);
        System.out.println(result);
    }

    // for integer arrays
    static int searchInRange(int[] arr, int target, int start, int end) {
        // if arr is empty
        if (arr.length == 0) return -1;
        // if indexes provided are greater than string's length (index out of bound error)
        if (start >= arr.length || end >= arr.length) return -1;

        // search for the element if and only if start index is less than or equal to end
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                if (target == arr[i]) return i;
            }
        }

        // if element not found
        return -1;
    }

    // for strings
    static boolean searchInRange(String str, char target, int start, int end) {
        // if str is empty
        if (str.length() == 0) return false;
        // if indexes provided are greater than string's length (index out of bound error)
        if (start >= str.length() || end >= str.length()) return false;

        // if start index is less than or equal to end index then only search for the char
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                // if char found in the string return true
                if (target == str.charAt(i)) return true;
            }
        }

        // if char not found
        return false;
    }
}
