public class DoublyLL {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLL() {
        this.size = 0;
    }

    public void insert(int value) {
        Node node = new Node(value, tail, null);
        if (tail == null) {
            insertAtFirst(value);
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insertAtFirst(int value) {
        Node node = new Node(value, null, head);
        if (head != null) {
            head.prev = node;
        }
        if (tail == null) {
            tail = node;
        }
        head = node;
        size++;
    }

    public void insertAtLast(int value) {
        Node node = new Node(value, tail, null);
        if (tail == null) {
            insertAtFirst(value);
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insertAtIndex(int value, int index) {
        if (index == 0) {
            insertAtFirst(value);
        } else if (index == size - 1) {
            insertAtLast(value);
        } else {
            Node prev = getAtIndex(index - 1);
            Node node = new Node(value, prev, prev.next);
            prev.next = node;
            node.next.prev = node;
            size++;
        }
    }

    public void insertAfter(int after, int value) {
        Node afterNode = find(after); // node after which value is to be inserted
        if (afterNode != null) {
            Node node = new Node(value, afterNode, afterNode.next);
            afterNode.next = node;
            if (node.next != null) {
                node.next.prev = node;
            } else {
                tail = node;
            }
            size++;
        }
    }

    public void insertBefore(int before, int value) {
        Node beforeNode = find(before); // node before which value is to be inserted
        if (beforeNode != null) {
            Node node = new Node(value,beforeNode.prev,beforeNode);
            beforeNode.prev = node;
            if (node.prev != null) {
                node.prev.next = node;
            } else {
                head = node;
            }
            size++;
        }
    }

    public int getSize() {
        return this.size;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null && node.value != value) {
            node = node.next;
        }
        return node;
    }

    public Node getAtIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " <-> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public void displayRev() {
        Node node = tail;
        while (node != null) {
            System.out.print(node.value + " <-> ");
            node = node.prev;
        }
        System.out.println("START");
    }

    // without tail insertion
//    public void insertAtLastWithoutTail(int value) {
//        if (head == null) {
//            Node node = new Node(value, null, null);
//            head = node;
//        } else {
//            Node last = getAtIndex(size-1);
//            Node node = new Node(value, last, null);
//            last.next = node;
//            size++;
//        }
//    }

    public void delete(int value) {
        Node node = find(value);
        if (node != null) {
            Node prev = node.prev;
            Node next = node.next;
            if (head.value == value) {
                next.prev = prev;
                head = next;
            } else if (tail.value == value) {
                prev.next = next;
                tail = prev;
            } else {
                prev.next = next;
                next.prev = prev;
            }
            size--;
        }
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
