package internal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // stack
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.push(1));
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());

        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println(stack.search(1));
        System.out.println(stack.contains(1));
        System.out.println(stack.lastElement());
        System.out.println(stack);


        // queue
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.add(1));
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.offer(6));
        System.out.println(queue.offer(7));

        System.out.println(queue.poll());
        System.out.println(queue.remove(5));

        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue);

        // Deque - double ended queue
        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println(deque.add(1));
        deque.addFirst(0);
        deque.addLast(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        System.out.println(deque.contains(2));
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.size());
        System.out.println(deque.pop());
        System.out.println(deque.remove());
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());
        System.out.println(deque.peek());
        System.out.println(deque);
    }
}
