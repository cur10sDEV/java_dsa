import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.prettyDisplay();

        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        for (int num : nums) {
//            bst.insert(num);
//        }
        bst.populateSorted(nums);
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.prettyDisplay();
    }
}
