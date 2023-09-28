package questions;

import java.util.Stack;

// remove efficient
public class QueueUsingStackRemove {
    private Stack<Integer> first; // main stack
    private Stack<Integer> second; // helper stack

    public QueueUsingStackRemove() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) throws Exception {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(x);
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int pop() throws Exception {
        return first.pop(); // O(n)
    }

    public int peek() throws Exception {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }

}
