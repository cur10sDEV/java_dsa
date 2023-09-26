public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int size;
    protected int head;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
        this.size = 0;
        this.head = -1;
    }

    // add the item to the stack(if possible) and returns true or false
    public boolean push(int item) throws StackException {
        if (isFull()) {
            throw new StackException("Stack is full!");
        }
        head++;
        data[head] = item;
        size++;
        return true;
    }

    // removes the item from the stack(if possible) and returns the removed item or throws an exception
    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is empty");
        }
        int temp = data[head];
        head--;
        size--;
        return temp;
    }

    // returns the last added item i.e., the item head pointer is pointing to
    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is empty");
        }
        return data[head];
    }


    protected boolean isFull() {
        return head == data.length - 1;
    }

    protected boolean isEmpty() {
        return head == -1;
    }
}
