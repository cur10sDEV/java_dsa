package questions;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> first; // main stack
    private Stack<Integer> second; // helper stack

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) throws Exception {
        first.push(x); // add normally like in stack - O(1)
    }

    public int pop() throws Exception {
        // to delete first item
        // copy all items to second in reverse order
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        // removed the last item added in second stack
        int removed = second.pop();
        // copy back all the items in original order to first stack
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        // return removed item
        return removed;
    }

    public int peek() throws Exception {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        int front = second.peek();
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        return front;
    }

    public boolean empty() {
        return first.isEmpty();
    }

}
