public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    // return sum of numbers from 1 to n
    static int sum(int n) {
        if (n <= 1) return 1;
        return n + sum(n-1);
    }
}