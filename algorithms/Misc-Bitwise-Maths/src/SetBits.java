public class SetBits {
    public static void main(String[] args) {
        System.out.println(findRMSB(36));
        System.out.println(Integer.toBinaryString(36));
    }

    // find no of set bits (1) in a given no
    static int findSetBits(int n) {
        // steps
        // 1. bitwise-ans (&) of n with 1 gives lsb(least significant digit)
        // 2. if lsb == 1 - increase count
        // 3. right shift n by 1 bit - all this while n > 0
        int count = 0;
//        while(n > 0) {
//            int lsb = n&1;
//            if (lsb == 1) count++;
//            n = n >> 1;
//        }
        // or
        while (n > 0) {
            count++;
            n -= (n & -n);
        }
        return count;
    }

    // find the right most set bit - position
    static int findRMSB(int n) {
        // indexing starts from 0
        int pos = 0;
        while (n > 0) {
            int lsb = n&1;
            if (lsb == 1) return pos;
            n = n >> 1;
            pos++;
        }
        // if no set bits
        return -1;
    }
}
