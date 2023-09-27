public class CustomQueue {
    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    private int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        data = new int[size];
    }

    private boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int value) throws QueueException {
        if (isFull()) {
            throw new QueueException("Queue is full.");
        }
        data[end] = value;
        end++;
        return true;
    }

    public int delete() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty.");
        }
        int temp = data[0];
        for (int i = 0; i < end - 1; i++) {
            data[i] = data[i + 1];
        }
        end--;
        return temp;
    }

    public int front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty.");
        }
        return data[0];
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < end; i++) {
            if (i == end - 1) {
                System.out.print(data[i]);
            } else {
                System.out.print(data[i] + ", ");
            }
        }
        System.out.println("]");
    }

}
