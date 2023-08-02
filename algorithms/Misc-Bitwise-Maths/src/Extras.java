import java.util.Scanner;

public class Extras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        findArmstrongInRange(1, 10000);
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static void findArmstrongInRange(int start, int end) {
        for (int i = start; i < end; i++) {
            if (isArmstrong(i)) System.out.println(i);
        }
    }

    static int findDigits(int num) {
        // only works with base 10
        int noOfDigits = 0;
        while (num > 0) {
            num /= 10;
            noOfDigits++;
        }
        return noOfDigits;
    }

    static boolean isArmstrong(int num) {
        int result = 0;
        // find no of digits
        int noOfDigits = findDigits(num);
        // find if armstrong
        int tempNum = num;
        while (tempNum > 0) {
            int remainder = tempNum % 10;
            result += (int) Math.pow(remainder, noOfDigits);
            tempNum /= 10;
        }
        return  result == num;
    }
}