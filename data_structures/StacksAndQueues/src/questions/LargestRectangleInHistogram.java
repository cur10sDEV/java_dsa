package questions;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int result = find(arr);
        System.out.println(result);
    }

    public static int find(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            findLargestInRange(arr, 0, i, stack);
        }
        max = findMaxInStack(stack);
        return max;
    }

    public static void findLargestInRange(int[] arr, int s, int e, Stack<Integer> stack) {
        if (s == e) {
            stack.push(arr[s]);
            return;
        }
        if (s < e) {
            int min = arr[s];
            for (int i = s; i <= e; i++) {
                min = Math.min(min,arr[i]);
            }
            int rectangle = min * ((e - s) + 1); // l * b
            stack.push(rectangle);
            findLargestInRange(arr,s+1,e,stack);
        }
    }

    public static int findMaxInStack(Stack<Integer> stack) {
        int max = stack.pop();
        while (!stack.isEmpty()) {
            max = Math.max(max,stack.pop());
        }
        return max;
    }
}
