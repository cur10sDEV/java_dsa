public class QueueMain {
    public static void main(String[] args) throws QueueException {
//        CustomQueue queue = new CustomQueue(5);
//        System.out.println(queue.insert(1));
//        queue.insert(2);
//        queue.insert(3);
//        queue.insert(4);
//        queue.insert(5);
//        queue.insert(6); // throws exception - queue is full
//
//        queue.delete();
//        queue.display();

        // circular queue
//        CircularQueue cq = new CircularQueue(5);
//        System.out.println(cq.insert(1));
//        cq.insert(2);
//        cq.insert(3);
//        cq.insert(4);
//        cq.insert(5);
//
//        cq.delete();
//        cq.delete();
//        cq.delete();
//
//        cq.insert(10);
//        cq.insert(11);
//        cq.insert(12);
//
//        cq.delete();
//
//        System.out.println(cq.front());
//
//        cq.display();

        // dynamic circular queue
        DynamicQueue cq = new DynamicQueue(5);
        System.out.println(cq.insert(1));
        cq.insert(2);
        cq.insert(3);
        cq.insert(4);
        cq.insert(5);

        System.out.println(cq.delete() + " <= deleted");
        cq.delete();
        cq.delete();


        cq.insert(10);
        cq.insert(11);
        cq.insert(12);
        cq.insert(56);

        System.out.println(cq.front());

        cq.display();

    }
}
