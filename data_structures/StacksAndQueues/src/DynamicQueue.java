public class DynamicQueue extends CircularQueue {
    private static final int DEFAULT_SIZE = 10;

    public DynamicQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int value) throws QueueException {
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];

            // copy all previous elements
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(value);
    }
}
