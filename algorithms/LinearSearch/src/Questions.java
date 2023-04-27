import java.util.Arrays;

public class Questions {
    public static void main(String[] args) {
        // find the count of numbers which have even no of digits
        int[] arr = {152,-11,999,67,4545,124,0};
        int even = findEven(arr);
        System.out.println(even);

        // find richest customer wealth
        int[][] customers = {{3,2,1},{1,3,3},{4,2}};
        int maxWealth = findMaxWealth(customers);
        System.out.println(maxWealth);
    }

    // =============== Q. 1. ================
    static int findEven(int[] arr) {
        if (arr.length == 0) return -1;
        int count = 0;
        for (int num: arr) {
            int noOfDigits = findDigits(num);
            if (noOfDigits % 2 == 0) count++;
        }
        return count;
    }

    static int findDigits(int num) {
//        if (num == 0) return 1;
//        int noOfDigits = 0;
//        while (currentNum > 0) {
//            currentNum = currentNum / 10;
//            noOfDigits++;
//        }
//        return noOfDigits;

        // or
        int digits = (int) (Math.log10(Math.abs(num))) + 1;
        return digits;
    }

    // =============== Q. 2. ================
    static int findMaxWealth(int[][] customers) {
        if (customers.length == 0) return -1;
        int maxWealth = Integer.MIN_VALUE;
        for (int[] customer: customers) {
            int currentWealth = findWealth(customer);
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }
        return maxWealth;
    }

    static int findWealth(int[] customer) {
        if (customer.length == 0) return -1;
        int totalWealth = 0;
        for (int wealth: customer) {
            totalWealth += wealth;
        }
        return totalWealth;
    }
}
