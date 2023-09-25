public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(happyNumber(2));
    }

    public static boolean happyNumber(int n) {
        int f = n;
        int s = n;

        do {
            s = sumSquareDigits(s);
            f = sumSquareDigits(sumSquareDigits(f));
            if (s == 1) {
                return true;
            }
        }
        while (f != s);
        return false;
    }

    public static int sumSquareDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n/10;
        }
        return sum;
    }
}
