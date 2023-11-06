import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // primitives
        int a = 33;
        int b = 67;

        // big integer
        // convert int/long to BI
        // valueOf is static so no need of "new" keyword
        BigInteger A = BigInteger.valueOf(55);
        BigInteger B = BigInteger.valueOf(66);
        // convert BI to int
        int c = A.intValue();
        // when dealing with strings constructor is used
        BigInteger C = new BigInteger("17867638768737687");
        BigInteger D = new BigInteger("6878431346");

        // constants - check docs - ONE, TEN, TWO, ZERO
        BigInteger X = BigInteger.ZERO;
        System.out.println(X);

        // operations

        // addition
        BigInteger add = C.add(D);
        // subtract
        BigInteger sub = C.subtract(D);
        // multiply
        BigInteger mul = C.multiply(D);
        // divide
        BigInteger div = C.divide(D);
        // remainder
        BigInteger rem = C.remainder(D);

        // comparison - compareTo method
        if (C.compareTo(D) < 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}