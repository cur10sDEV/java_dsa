public class Bit {
    public static void main(String[] args) {
        int ans = setBit(31, 3);
        System.out.println(ans);
        System.out.println(Integer.toBinaryString(ans));
    }

    // returns the bit(1 or 0) of number n at position
    static int find(int n, int p) {
        // steps
        // 1. find mask - bits with all zeroes except pth position - (1<<(p-1))
        // 2. bitwise-and (&) of number n with the mask
        // 3. right shift the above result to p-1 pos to get the value of pth position bit
        System.out.println(Integer.toBinaryString(n));
        return ((n & (1 << (p-1))) >> (p-1));
    }

    // return the number after setting the pth bit to 1
    static int setBit(int n, int p) {
        // steps
        // 1. find mask - bits with all zeroes except pth position - (1<<(p-1))
        // 2. bitwise-or (|) of number n with the mask
        System.out.println(Integer.toBinaryString(n));
        return (n | (1 << (p-1)));
    }

    // return the number after resetting the pth bit to 0
    static int resetBit(int n, int p) {
        // steps
        // 1. find mask - bits with all zeroes except pth position - (1<<(p-1))
        // 2. mask = complement the above mask to get all bits 1 except pth position
        // 2. bitwise-ans (&) of number n with the mask
        System.out.println(Integer.toBinaryString(n));
        int mask = (1 << (p-1));
        mask = ~mask;
        return (n & mask);
    }


}
