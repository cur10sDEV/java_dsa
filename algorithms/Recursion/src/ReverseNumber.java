public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(1824));
    }

    // return reverse of a number
    static int reverse(int n) {
        if (n < 10) return n;
        int noOfDigits = (int) Math.log10(n) + 1;
        int lastDigit = (int) ((n % 10) * Math.pow(10, noOfDigits - 1));
        return lastDigit + reverse(n / 10);
    }
}
