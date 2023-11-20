import java.util.ArrayList;

// min heap code
public class Heap<T extends Comparable<T>> {
    // heap is actually stored in array
    // but for representation purposes we use complete binary tree
    final private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    public ArrayList<T> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    private T getRoot() {
        return list.get(0);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightIndex(int index) {
        return (index * 2) + 2;
    }

    private void swap(int i, int j) {
        T first = list.get(i);
        T second = list.get(j);
        list.set(i, second);
        list.set(j, first);
    }

    public void insert(T element) {
        list.add(element);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        // check the parent value
        int p = getParentIndex(index);
        // min heap
        if (list.get(p).compareTo(list.get(index)) > 0) {
            // swap the elements
            swap(p, index);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }
        T first = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return first;
    }

    private void downheap(int index) {
        int left = getLeftIndex(index);
        int right = getRightIndex(index);
        // if there's no left or right children - return
        if (left >= list.size()) {
            return;
        }
        // assume min is left
        int min = left;
        // if there's a right child - check for min value
        if (right < list.size()) {
            min = list.get(left).compareTo(list.get(right)) < 0 ? left : right;
        }
        // if the parent is greater than the children - swap
        if (list.get(index).compareTo(list.get(min)) > 0) {
            swap(index, min);
            downheap(min);
        }
    }

    // heap sort
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while(!list.isEmpty()) {
            data.add(this.remove());
        }

        return data;
    }
}
