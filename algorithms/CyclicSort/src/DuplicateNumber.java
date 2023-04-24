public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        int result = findDuplicateNumber(arr);
        System.out.println(result);
    }

//    static int findDuplicateNumber(int[] arr) {
//        int i = 0;
//        while (i < arr.length) {
//            int correctIndex = arr[i] - 1;
//            if (arr[i] != arr[correctIndex]) {
//                swap(arr, i, correctIndex);
//            } else i++;
//        }
//
//        // find duplicate number
//        for (int j = 0; j < arr.length; j++) {
//            int correctIndex = arr[j] - 1;
//            if (j != correctIndex) {
//                return arr[j];
//            }
//        }
//        // if no duplicate number
//        return -1;
//    }

    // or

    static int findDuplicateNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i+1) {
                if (arr[i] == arr[arr[i]-1]) return arr[i];
                swap(arr, i, arr[i]-1);
            } else {
                i++;
            }
        }
        // if no duplicate number
        return -1;
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
