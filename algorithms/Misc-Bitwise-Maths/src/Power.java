public class Power {
    public static void main(String[] args) {
        System.out.println(findPower(6,8));
    }

    // returns the power p of base b
    static int findPower(int b, int p) {
        int ans = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                ans *= b;
            }
            b *= b;
            p = p >> 1;
        }
        return ans;
    }

    static boolean isPowerOfTwo(int n) {
        n = Math.abs(n);
//        int count = 0;
//        while (n > 0) {
//            int lsb = n&1;
//            if (lsb == 1) count++;
//            n = n >> 1;
//        }
//        return count == 1;
        // or
        return (n & (n-1)) == 0;
    }
}
