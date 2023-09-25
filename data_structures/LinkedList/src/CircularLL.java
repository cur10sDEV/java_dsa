public class CircularLL {
    private int size;
    private Node head;
    private Node tail;

    public CircularLL() {
        this.size = 0;
    }

    public void insert(int value) {
        if (head == null) {
            insertAtFirst(value);
        } else {
            insertAtLast(value);
        }
    }

    public void delete(int value) {
        if (head != null && tail != null) {
            if (head == tail) {
                head = null;
                tail = null;
                size--;
            } else if (value == head.value) {
                deleteFromStart();
            } else if (value == tail.value) {
                deleteFromLast();
            } else {
                Node node = head;
                while (node.next != head && node.next.value != value) {
                    node = node.next;
                }
                if (node.value != tail.value) {
                    node.next = node.next.next;
                    size--;
                }
            }
        }
    }

    // alternate delete method
//    public void delete(int value) {
//        Node node = head;
//        if (node != null) {
//            if (node.value == value) {
//                head = head.next;
//                tail.next = head;
//            } else {
//                do {
//                    Node n = node.next;
//                    if (n.value == value) {
//                        node.next = n.next;
//                        break;
//                    }
//                    node = node.next;
//                } while(node != head);
//            }
//            size--;
//        }
//    }

    public void insertAfter(int after,int value) {
        Node afterNode = find(after);
        if (afterNode != null) {
            Node node = new Node(value);
            if (head == tail) {
                head.next = node;
                node.next = head;
                tail = afterNode;
            } else if (afterNode == tail) {
                tail.next = node;
                node.next = head;
                tail = node;
            } else {
                node.next = afterNode.next;
                afterNode.next = node;
            }
            size++;
        }
    }

    public Node find(int value) {
        Node node = head;
        do {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        } while (node != head);
        return null;
    }

    public void insertAtFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            tail.next = node;
        }
        head = node;
        size++;
    }

    public void insertAtLast(int value) {
        if (head == null) {
            insert(value);
        } else {
            Node node = new Node(value);
            node.next = head;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void deleteFromStart() {
        if (head != null && tail != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
        }
    }

    public void deleteFromLast() {
        if (head != null && tail != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {

                Node node = head;
                while (node.next != tail) {
                    node = node.next;
                }
                node.next = head;
                tail = node;
            }
            size--;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void display() {
        Node node = head;
        if (node != null) {
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            }
            while (node != head);
        }
        System.out.println("HEAD");
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
