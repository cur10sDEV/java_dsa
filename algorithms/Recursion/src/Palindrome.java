public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    // return whether the number is palindrome or not
    static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    // return the reverse of the number
    static int reverse(int n) {
        if (n < 10) return n;
        int noOfDigits = (int) Math.log10(n) + 1;
        int lastDigit = (int) ((n % 10) * Math.pow(10, noOfDigits - 1));
        return lastDigit + reverse(n / 10);
    }
}
