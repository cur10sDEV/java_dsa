public class ZeroCount {
    public static void main(String[] args) {
        System.out.println(countZeros(1035070));
    }

    // return the count of zeros of the number
    static int countZeros(int n) {
        if (n < 10) {
            if (n == 0) return 1;
            else return 0;
        }
        if (n % 10 == 0) {
            return 1 + countZeros(n/10);
        }
        return countZeros(n/10);
    }
}