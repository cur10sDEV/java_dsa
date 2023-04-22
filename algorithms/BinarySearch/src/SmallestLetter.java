public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j', 'j'};
        char result = findSmallest(letters, 'g');
        System.out.println(result);
    }

    // find the smallest letter greater than target
//    static char findSmallest(char[] letters, char target) {
//        int start = 0;
//        int end = letters.length -1;
//        while(start <= end) {
//            int mid = start + (end - start) / 2;
//            if (target < letters[mid]) end = mid - 1;
//            else start = mid + 1;
//        }
//        return letters[start % letters.length];
//    }




    static char findSmallest(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
//            if (target == arr[mid]) return arr[mid];
            if (target < arr[mid]) end = mid -1;
            else start = mid +1;
        }
        return arr[start % arr.length];
    }
}
