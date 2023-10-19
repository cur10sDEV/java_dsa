public class SegmentTree {
    private static class Node {
        Node left;
        Node right;
        int value;
        int start;
        int end;

        public Node(int value, int start, int end) {
            this.value = value;
            this.start = start;
            this.end = end;
        }

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node node = new Node(arr[start], start, end);
            return node;
        }
        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.value = node.left.value + node.right.value;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str += "Interval [" + node.left.start + ", " + node.left.end + "], data: " + node.left.value + " => ";
        } else {
            str += "No left child";
        }

        str += "Interval [" + node.start + ", " + node.end + "], data: " + node.value + " <= ";

        if (node.right != null) {
            str += "Interval [" + node.right.start + ", " + node.right.end + "], data: " + node.right.value;
        } else {
            str += "No right child";
        }

        System.out.println(str + "\n");

        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(int qsi, int qei) {
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.start > qei || node.end < qsi) {
            // outside the range
            return 0;
        } else if (node.start >= qsi && node.end <= qei) {
            // completely inside the range
            return node.value;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        this.root.value = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.start && index <= node.end) {
            if (index == node.start && index == node.end) {
                node.value = value;
                return node.value;
            } else {
                int leftAns = this.update(node.left, index, value);
                int rightAns = this.update(node.right, index, value);
                node.value = leftAns + rightAns;
                return node.value;
            }
        }
        return node.value;
    }
}