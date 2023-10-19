public class Main {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.insert(55);
        avl.insert(40);
        avl.insert(25);
        avl.insert(42);
        avl.insert(65);
        avl.insert(51);
        avl.insert(31);
        avl.insert(54);
        avl.insert(68);
        System.out.println(avl.height());
        avl.prettyDisplay();
    }
}