package questions;

import java.util.Arrays;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        int[] a = {4,2,4,6,1};
        int[] b = {2,1,8,5};
        int result = getMaxSteps(a, b, 10);
        System.out.println(result);
    }

    public static int getMaxSteps(int[] a, int[] b, int maxSum) {
        return getCount(a, b, 0, 0, maxSum);
    }

    private static int getCount(int[] a, int[] b, int currentSum, int steps, int maxSum) {
        if (currentSum > maxSum) {
            // at this we already have exceeded the maxSum that's why we return steps-1
            return steps - 1;
        }
        if (a.length == 0 || b.length == 0) {
            return steps;
        }
        int ans1 = getCount(Arrays.copyOfRange(a,1,a.length), b, currentSum + a[0], steps + 1, maxSum);
        int ans2 = getCount(a, Arrays.copyOfRange(b,1,b.length), currentSum + b[0], steps + 1, maxSum);

        return Math.max(ans1, ans2);
    }
}
