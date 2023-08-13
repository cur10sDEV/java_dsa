public class N {
    public static void main(String[] args) {
        funBoth(5);
    }

    // print 1 to n
    static void fun(int n) {
        if (n < 1) return;
        fun(n-1);
        System.out.println(n);
    }

    // print n to 1
    static void funRev(int n) {
        if (n < 1) return;
        System.out.println(n);
        funRev(n-1);
    }

    // print n to 1 then 1 to n
    static void funBoth(int n) {
        if (n < 1) return;
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}
