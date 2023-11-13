public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        int[] arr = {91, 90, 73, 24, 96, 63, 7, 18, 25, 98};
        for (int e : arr) {
            heap.insert(e);
        }
        heap.insert(2);
        heap.remove();
        System.out.println(heap.getList());
        System.out.println(heap.heapSort());
    }
}
