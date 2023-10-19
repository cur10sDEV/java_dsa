public class AVLTree {
    private Node root;

    public AVLTree() {
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int height() {
        return height(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public void populateSorted(int[] arr) {
        populateSorted(arr, 0, arr.length - 1);
    }

    private void populateSorted(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        this.insert(arr[mid]);
        populateSorted(arr,start,mid);
        populateSorted(arr,mid+1,end);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right case
                // first make it left-left case then right rotate
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right-left case
                // first make it right-right case then left rotate
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node node) {
        Node temp = node.left;
        Node temp2 = temp.right;
        temp.right = node;
        node.left = temp2;

        // update the heights
        node.height = Math.max(height(node.left), height(node.right) + 1);
        temp.height = Math.max(height(temp.left), height(temp.right) + 1);

        return temp;
    }

    private Node leftRotate(Node node) {
        Node temp = node.right;
        Node temp2 = temp.left;
        temp.left = node;
        node.right = temp2;

        // update the heights
        node.height = Math.max(height(node.left), height(node.right) + 1);
        temp.height = Math.max(height(temp.left), height(temp.right) + 1);

        return temp;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public void prettyDisplay() {
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-----> " + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level + 1);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
    }
}

