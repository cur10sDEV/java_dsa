public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(131));
    }

    static boolean isPrime(int n) {
        // time complexity = √n
        // only have to check until i*i <= n - cause after that numbers are repeating
        if (n <= 1) return false;
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) return false;
            i++;
        }
        return true;
    }
}
