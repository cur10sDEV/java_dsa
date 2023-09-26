public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) throws StackException {
        if (this.isFull()) {
            increaseSize();
        }
        return super.push(item);
    }

    private void increaseSize() {
        // double the array size
        int[] temp = new int[data.length * 2];
        // copy all items to new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
