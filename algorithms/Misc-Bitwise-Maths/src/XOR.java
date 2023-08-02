public class XOR {
    public static void main(String[] args) {
        System.out.println(sumRange(3,9));
    }

    static int sumRange(int a, int b) {
        // range xor for a,b = xor(b) ^ xor(a-1)
        return sum(b) ^ sum(a-1);
    }

    // find XOR of all num from 0 to a
    static int sum(int a) {
        int ans = a % 4;
        if (ans == 0) return a;
        if (ans == 2) return a+1;
        if (ans == 3) return 0;
        if (ans == 1) return 1;
        return -1;
    }
}
