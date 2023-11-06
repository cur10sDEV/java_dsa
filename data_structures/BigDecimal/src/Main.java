import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BD();
    }

    static void BD() {
        double x = 0.03;
        double y = 0.04;
        double ans = y - x;
        // because these are floating point nos and due to binary representation
        // they give some error - somewhat random precision - check docs
        System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans2 = Y.subtract(X);
        // big decimal gives exact answer
        System.out.println(ans2);

        BigDecimal a = new BigDecimal("546546465.4656546");
        BigDecimal b = new BigDecimal("78987168.647866");

        // operations
        System.out.println(a.add(b));
        System.out.println(b.subtract(a));
        System.out.println(a.multiply(b));
        System.out.println(a.pow(2));
        System.out.println(a.negate());
    }
}