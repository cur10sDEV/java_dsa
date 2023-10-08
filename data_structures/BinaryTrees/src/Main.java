import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.prettyDisplay();

        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {15, 6, 9, 8, 11, 3, 4, 2, 19, 23, 21, 18};
        for (int num : nums) {
            bst.insert(num);
        }

        bst.display();
    }
}
