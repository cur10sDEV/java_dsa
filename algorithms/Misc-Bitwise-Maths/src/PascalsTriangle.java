public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(findSum(6));
    }

    // find sum of the nth row in pascal's triangle
    // pascal's triangle is something like this
    // 1
    // 1  1
    // 1  2  1
    // 1  3  3  1
    // 1  4  6  4 1
    // 1  5 10 10 5 1
    static int findSum(int n) {
//        return (int)(Math.pow(2,n-1));
        // or
        return (1 << (n-1));
    }




















}
