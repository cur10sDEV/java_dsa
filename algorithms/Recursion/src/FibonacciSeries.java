public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    // return the nth fibonacci number
    static int fib(int n) {
        if (n >= 0) {
            if (n < 2) return n;
            return fib(n-1) + fib(n-2);
        }
        return 0;
    }
}
