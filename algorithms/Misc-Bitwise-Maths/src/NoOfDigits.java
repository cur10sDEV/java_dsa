public class NoOfDigits {
    public static void main(String[] args) {
        System.out.println(findNoOfDigits(3456,10));
    }

    // find no of digits in base b
    static int findNoOfDigits(int num, int base) {
        return (int)(Math.log(num)/Math.log(base)) + 1;
    }
}
