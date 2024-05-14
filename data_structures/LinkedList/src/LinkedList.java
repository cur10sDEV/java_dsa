import java.util.ArrayList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insert(int value) {
        if (tail == null) {
            this.insertFirst(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    // insert using recursion
    public void insertRec(int index, int value) {
        if (index <= size) {
            head = insertRec(index, value, head);
        }
    }

    private Node insertRec(int index, int value, Node currentNode) {
        if (index == 0) {
            Node node = new Node(value, currentNode);
            size++;
            return node;
        }
        currentNode.next = insertRec(index - 1, value, currentNode.next);
        return currentNode;
    }

    public void insertFirst(int value) {
        Node node = new Node(value, head);
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if (tail == null) {
            this.insertFirst(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insertAtIndex(int value, int index) {
        if (index == 0) {
            this.insertFirst(value);
            return;
        }
        if (index == size) {
            this.insertLast(value);
            return;
        }
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.next;
        }
        Node node = new Node(value, currentNode.next);
        currentNode.next = node;
        size++;
    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = head;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int value = tail.value;
        secondLast.next = null;
        tail = secondLast;
        return value;
    }

    public int deleteFromIndex(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node previous = get(index - 1);
        int value = previous.next.value;
        previous.next = previous.next.next;

        return value;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    private Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int getSize() {
        return this.size;
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
    // -------------------- questions -------------------------

    // helper method
    public Node getHead() {
        return this.head;
    }

    // leetcode 83 - remove all duplicates from sorted linked list
    public void deleteDuplicates(Node node) {
        if (node != null) {
            while (node.next != null) {
                if (node.value == node.next.value) {
                    node.next = node.next.next;
                    size--;
                } else {
                    node = node.next;
                }
            }
            tail = node;
        }
    }

    // recursive version
//    public Node deleteDuplicates(Node head) {
//        if (head != null) {
//            if (head.next == null) {
//                return head;
//            }
//            Node prevNode = deleteDuplicates(head.next);
//            if (prevNode.value == head.value) {
//                head.next = prevNode.next;
//            } else {
//                head.next = prevNode;
//            }
//        }
//        return head;
//    }

    // leetcode 23 - merge two sorted linked lists
    public static LinkedList merge(LinkedList first, LinkedList second) {
        Node head1 = first.head;
        Node head2 = second.head;
        LinkedList result = new LinkedList();

        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                result.insert(head1.value);
                head1 = head1.next;
            } else {
                result.insert(head2.value);
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            result.insert(head1.value);
            head1 = head1.next;
        }

        while (head2 != null) {
            result.insert(head2.value);
            head2 = head2.next;
        }

        return result;
    }

    public static boolean detectCycle(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head.value)) {
                return true;
            }
            list.add(head.value);
            head = head.next;
        }
        return false;
    }

    public void bubbleSort() {
        sort(size - 1, 0);
    }

    private void sort(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);
            if (first.value > second.value) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                    head = second;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    first.next = null;
                    tail = first;
                    second.next = tail;
                    prev.next = second;
                } else {
                    Node prev = get(col - 1);
                    first.next = second.next;
                    second.next = first;
                    prev.next = second;
                }
            }
            sort(row, col + 1);
        } else {
            sort(row - 1, 0);
        }
    }

    public Node reverse(Node node) {
        if (node.next == null) {
            head = node;
            return node;
        }
        Node prev = reverse(node.next);
        prev.next = node;
        node.next = null;
        // below line can be omitted if no tail is present
        tail = node;
        return node;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev_of_left = head;
        ListNode left_ele = head;
        for (int i = 1; i <= right; i++) {
            if (i == left - 1) {
                prev_of_left = curr;
            }
            if (i == left) {
                left_ele = curr;
            }
            if (i > left) {
                curr.next = prev;
            }
            prev = curr;
            curr = next;
            next = (next == null) ? next : next.next;
        }
        if (left == 1) {
            head = prev;
        }
        prev_of_left.next = prev;
        left_ele.next = curr;
        return head;
    }

    public boolean isPalindrome(Node head) {
        Node mid = getMid(head);
        Node secondHead = reverseList(head);
        Node reReverseHead = secondHead;

        // compare
        while (head != null && secondHead != null) {
            if (head.value != secondHead.value) {
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        reverseList(reReverseHead);
        return head == null || secondHead == null;
    }

    public Node getMid(Node head) {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // in place reversal of linked list
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = (next == null) ? next : next.next;
        }
        this.head = prev;
        return prev;
    }

    // rotate list
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode last = head;
        while(last.next != null) {
            last = last.next;
            length++;
        }
        int rotations = k % length;
        if (rotations == 0) {
            return head;
        }
        int skip = length - rotations;
        ListNode newLast = head;
        for(int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        ListNode newHead = newLast.next;
        newLast.next = last.next;
        last.next = head;
        head = newHead;
        return head;
    }
}
