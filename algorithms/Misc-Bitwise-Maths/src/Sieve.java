public class Sieve {

    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1];
        sieve(n, primes);
    }

    static void sieve(int n, boolean[] primes) {
        // false in array means prime and true means not prime
        // checking until (i>=2) i*i <= n
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                // setting multiple of prime numbers as true as they are not prime
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.println(i);
            }
        }
        // time complexity - O(n * log(log(n)))
    }

}

