public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2,2,3,2,7,7,8,7,8,8};
//        System.out.println(findUniqueInN(arr, 3));
    }

    // find unique number in array of numbers where every number is repeated exactly 2 times except the ans
    static int findUnique(int[] arr) {
        int unique = 0;
        for (int n: arr) {
            unique ^= n;
        }
        return unique;
    }


    // find unique number in array of numbers with their negative counterparts
    static int ansTwo(int[] arr) {
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }
        return sum;
    }

    // provided an array of numbers with every number repeated exactly n times except one number,
    // that is the answer
//    static int findUniqueInN(int[] arr, int n) {
//
//    }
}
