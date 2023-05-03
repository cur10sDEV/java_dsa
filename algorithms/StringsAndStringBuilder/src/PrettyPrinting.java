public class PrettyPrinting {
    public static void main(String[] args) {
        // fomatted strings placeholders
        // %c - character
        // %d - decimal(base 10)
        // %e - exponential
        // %f - floating
        // %i - Integer
        // %o - Octal
        // %s - String
        // %u - Unsigned decimal(integer)
        // %x - Hexadecimal (base 16)
        // %t - Date/Time
        // %n - Newline
        // formatted strings
        float a = 5.45445642452f;
        System.out.printf("The rounded value is: %.2f", a);
        System.out.println();
        System.out.printf("The value of pi is %.3f", Math.PI);
        // strings
        System.out.println();
        System.out.printf("Hello my name is %s and I'm %s", "Elliot", "insane");

    }
}
