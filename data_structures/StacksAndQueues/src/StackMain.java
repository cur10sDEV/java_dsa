public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stack = new CustomStack(5);
        System.out.println(stack.push(1));
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // dynamic stack
        DynamicStack dStack = new DynamicStack(5);
        System.out.println(dStack.push(1));
        System.out.println(dStack.push(1));
        System.out.println(dStack.push(1));
        System.out.println(dStack.push(1));
        System.out.println(dStack.push(1));
        System.out.println(dStack.push(1));
        System.out.println(dStack.push(1));
        System.out.println(dStack);
    }
}