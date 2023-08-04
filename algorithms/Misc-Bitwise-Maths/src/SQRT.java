public class SQRT {
    public static void main(String[] args) {
        System.out.printf("%.3f", squareRoot(40, 3));
    }

    static double squareRoot(int n, int p) {
        // time complexity - O(log(n))
        int start = 1;
        int end = n;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) return mid;
            else if (mid * mid > n) end = mid - 1;
            else start = mid + 1;
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}
