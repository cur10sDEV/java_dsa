public class DigitProduct {
    public static void main(String[] args) {
        System.out.println(prodOfDigits(1203));
        int n=12;
        System.out.println(n--);
    }

    // return product of digits of a number
    static int prodOfDigits(int n) {
        n = Math.abs(n);
        if (n < 10) return n;
        return n%10 * prodOfDigits(n/10);
    }
}
