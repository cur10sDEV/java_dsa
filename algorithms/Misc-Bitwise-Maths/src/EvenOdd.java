public class EvenOdd {
    public static void main(String[] args) {
        System.out.println(isEven(3));
    }

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}