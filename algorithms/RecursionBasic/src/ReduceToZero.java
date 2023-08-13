public class ReduceToZero {
    public static void main(String[] args) {
        System.out.println(stepsToZero(8));
    }

    static int stepsToZero(int n) {
        if (n == 0) return 0;
        if (n%2 == 0) return 1 + stepsToZero(n/2);
        return 1 + stepsToZero(n-1);
    }
}
