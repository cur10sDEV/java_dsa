public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123));
    }

    // return the sum of the digits of a number
    static int sumOfDigits(int n) {
        n = Math.abs(n);
        if (n < 10) return n;
        return n%10 + sumOfDigits(n/10);
    }
}
