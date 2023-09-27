public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    protected boolean isFull() {
        return size == data.length;
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int value) throws QueueException {
        if (isFull()) {
            throw new QueueException("Queue is full");
        }
        data[end++] = value; // sets the value then increases the end
        end = end % data.length; // it will start from zero after the last index
        size++;
        return true;
    }

    public int delete() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty");
        }
        int removed = data[front++]; // returns the value then increases the front
        front = front % data.length; // it will start from zero after the last index
        size--;
        return removed;
    }

    public int front() throws QueueException{
        if (isEmpty()) {
            throw new QueueException("Queue is empty");
        }
        return data[front];
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % data.length;
            if (i == size - 1) {
                System.out.print(data[index]);
            } else {
                System.out.print(data[index] + ", ");
            }
        }
        System.out.println("]");
    }
}
